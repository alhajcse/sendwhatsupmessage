package com.app.whatsupmessage.enums;

public enum RecordStatus {
    DRAFT(0),
    ACTIVE(1),
    DELETED(2),
    INACTIVE(3);

    private final Integer label;

    RecordStatus(Integer label) {
        this.label = label;
    }

    public Integer getLabel() {
        return label;
    }

}
