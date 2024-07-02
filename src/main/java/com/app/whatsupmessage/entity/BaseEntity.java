package com.app.whatsupmessage.entity;

import com.app.whatsupmessage.enums.RecordStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    static final Long serialVersionUID = 1L;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", updatable = false)
    protected Date createdAt;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_AT")
    protected Date updatedAt;

    //default one, auto increment for each operation like update
    @Version
    @JsonIgnore
    @Column(name = "RECORD_VERSION")
    private Integer recordVersion;

    @JsonIgnore
    @Column(name = "RECORD_ID")
    private Integer recordId;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = "RECORD_STATUS",length = 50)
    private RecordStatus recordStatus;

    @Column(name = "CREATOR", updatable = false)
    private Long createdBy;

    @Column(name = "UPDATER")
    private Long updatedBy;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
    }
}
