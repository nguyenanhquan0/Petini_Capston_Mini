package com.capstone.mini.petini.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Column
    private String createdDate;
    @Column
    private String updatedDate;
    @Column(columnDefinition = "nvarchar(500)")
    private String createdBy;
    @Column(columnDefinition = "nvarchar(500)")
    private String updatedBy;
}
