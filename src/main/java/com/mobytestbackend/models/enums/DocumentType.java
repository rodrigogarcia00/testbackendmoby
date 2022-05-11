package com.mobytestbackend.models.enums;

public enum DocumentType {
    DNI("DNI"),
    LE("LE"),
    LC("LC");
    private final String type;

    DocumentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
