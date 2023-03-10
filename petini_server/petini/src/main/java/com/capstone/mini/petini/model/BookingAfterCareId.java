package com.capstone.mini.petini.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingAfterCareId implements Serializable {
    @Column
    private Long bookingId;

    @Column
    private Long afterCareId;
}
