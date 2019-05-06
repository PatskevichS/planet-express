package com.patskevich.planetexpress.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DELIVERY")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long senderId;
    @NotNull
    private String recipient;
    @NotNull
    private String planet;
    @NotNull
    private String address;
    private String note;
    private Long deliveryShip;
    private String status;
    private String comment;
}