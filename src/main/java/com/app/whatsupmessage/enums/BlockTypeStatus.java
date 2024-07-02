package com.app.whatsupmessage.enums;

public enum BlockTypeStatus {
    GENERAL("GENERAL"),
    DEFAULT("DEFAULT"),
    PREMIUM("PREMIUM");

    private final String label;

    BlockTypeStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
