package com.tlabs.eve.api;



import com.tlabs.eve.parser.SetAttributePropertyRule;

import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import java.util.TimeZone;

/**@since Eve API V3 (30 Aug 2011*/
public class ContractListParser extends EveAPIParser<ContractListResponse> {

    private static final class LimitedContractRule extends SetAttributePropertyRule {

        private final int maxContracts;
        private int countContracts;

        public LimitedContractRule(final int maxContracts) {
            this.maxContracts = maxContracts;
            this.countContracts = 0;
        }

        @Override
        public void doBegin(String name, Attributes attributes) {
            if (this.countContracts >= this.maxContracts) {
                return;
            }

            final Contract contract = new Contract();
            getDigester().push(contract);
            super.doBegin(name, attributes);
        }

        @Override
        public void doBody(String name, String text) {
            if (this.countContracts >= this.maxContracts) {
                return;
            }
            super.doBody(name, text);
        }

        @Override
        public void doEnd(String name) {
            if (this.countContracts >= this.maxContracts) {
                return;
            }

            final Contract contract = (Contract) getDigester().pop();
            boolean addContract;
            switch (contract.getStatus()) {
            case IN_PROGRESS:
            case OUTSTANDING:
                addContract = true;
                break;

            case COMPLETED_COMPLETED:
            case COMPLETED_CONTRACTOR:
            case COMPLETED_ISSUER:
            case FAILED:
            case REJECTED:
            case REVERSED:
                //we need to set an arbitrary time lapse...
                final long expired = Math.max(contract.getDateExpired(), contract.getDateCompleted());
                final long nowInEveTime = System.currentTimeMillis() - TimeZone.getDefault().getOffset(System.currentTimeMillis());

                addContract = (expired > (nowInEveTime - 48l * 3600l * 1000l));
                break;

            case CANCELLED:
            case DELETED:
            case UNKNOWN:
            default:
                addContract = false;
                break;
            }
            if (addContract) {
                final ContractListResponse r = (ContractListResponse) getDigester().peek();
                r.addContract(contract);
                this.countContracts = this.countContracts + 1;
            }
        }
    }

    public ContractListParser() {
        super(ContractListResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addRule("eveapi/result/rowset/row", new LimitedContractRule(2500));
    }
}
