package com.tlabs.eve.api;

/*
 * #%L This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova %% Copyright (C) 2010 - 2012 Evanova
 * (Traquenard Labs) %% Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License. #L%
 */

import java.io.Serializable;

public class EveContractBid extends Object implements Serializable {

    private static final long serialVersionUID = -5988962546869289837L;
    
    private long bidID;
    private long contractID;
    private long bidderID;
    private String bidderName;//not in xml

    private long bidDate;
    private long amount;

    public long getBidID() {
        return bidID;
    }

    public void setBidID(long bidID) {
        this.bidID = bidID;
    }

    public long getContractID() {
        return contractID;
    }

    public void setContractID(long contractID) {
        this.contractID = contractID;
    }

    public long getBidderID() {
        return bidderID;
    }

    public void setBidderID(long bidderID) {
        this.bidderID = bidderID;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public long getBidDate() {
        return bidDate;
    }

    public void setBidDate(long bidDate) {
        this.bidDate = bidDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}
