package com.tlabs.eve.api;



import java.util.HashMap;
import java.util.Map;

public class ErrorListResponse extends EveAPIResponse {

    private static final long serialVersionUID = 1883263792642168903L;

    private Map<Integer, String> errors;//names by id

    public ErrorListResponse() {
        super();
        this.errors = new HashMap<>();
    }

    public Map<Integer, String> getErrors() {
        return this.errors;
    }

    public void addError(Integer id, String name) {
        this.errors.put(id, name);
    }
}
