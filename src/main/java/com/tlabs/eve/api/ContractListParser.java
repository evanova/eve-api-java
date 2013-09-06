package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.util.TimeZone;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Rule;
import org.xml.sax.Attributes;

import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;
/**@since Eve API V3 (30 Aug 2011*/
public class ContractListParser extends EveAPIParser<ContractListResponse>{
    
    private static final class LimitedContractRule extends SetAttributePropertyRule {
        
        private final int maxContracts;
        private int countContracts;
        
        public LimitedContractRule(final int maxContracts) {
            this.maxContracts = maxContracts;
            this.countContracts = 0;
        }
        @Override
        public void doBegin(String name, Attributes attributes) {            
            if (this.countContracts > this.maxContracts) {
                return;
            }
            
            final EveContract contract = new EveContract();
            getDigester().push(contract);            
            super.doBegin(name, attributes);
        }

        @Override
        public void doBody(String name, String text) {
            if (this.countContracts > this.maxContracts) {
                return;
            }
            super.doBody(name, text);
        }

        @Override
        public void doEnd(String name) {
            if (this.countContracts > this.maxContracts) {
                return;
            }
            
            final EveContract contract = (EveContract)getDigester().pop();
            boolean addContract = false;
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
                    final long nowInEveTime = 
                            System.currentTimeMillis() - TimeZone.getDefault().getOffset(System.currentTimeMillis());  
                    
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
                final ContractListResponse r = (ContractListResponse)getDigester().peek();
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
