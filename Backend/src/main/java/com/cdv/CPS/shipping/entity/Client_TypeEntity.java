package com.cdv.CPS.shipping.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Client_Type")

public class Client_TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Client_Type_ID")
    private Integer clientTypeId;

    @Column(name = "Name", nullable = false, length = 20)
    private String name;

    @Column(name = "Discount", nullable = false)
    private Integer discount;

    public Integer getClientTypeId() {
        return clientTypeId;
    }

    public void setClientTypeId(Integer clientTypeId) {
        this.clientTypeId = clientTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
