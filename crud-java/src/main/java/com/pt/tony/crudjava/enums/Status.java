package com.pt.tony.crudjava.enums;

public enum Status {
    
    ACTIVE("active"), INACTIVE("inactive");

    private String value;


    private Status(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }


    @Override
    public String toString() {
        
        return super.toString();
    }


}
