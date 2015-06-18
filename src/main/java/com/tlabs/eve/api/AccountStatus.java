package com.tlabs.eve.api;



import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountStatus implements Serializable {

    private static final long serialVersionUID = -1731735135378886230L;

    private long userID;
    private long creationDate;
    private long paidUntil;

    private int logonCount;
    private long logonMinutes;


}
