package com.tlabs.eve.esi.impl;


import org.devfleet.esi.api.ContactsApi;
import retrofit2.Retrofit;

final class ContactRetrofit {

    private final ContactsApi contactApi;
    private final String datasource;

    public ContactRetrofit(final Retrofit rf, final String datasource){
        this.contactApi = rf.create(ContactsApi.class);
        this.datasource = datasource;
    }
}
