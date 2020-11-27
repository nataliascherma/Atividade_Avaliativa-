package com.fafram.webservice;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "tb_Phone")
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String type;
    private Integer number;


    @JsonIgnore
    @ManyToOne
    private Customer customer;

    public Phone() {
    }

    public Phone(Long id, String type, Integer number, Customer customer) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return id.equals(phone.id) &&
                type.equals(phone.type) &&
                number.equals(phone.number) &&
                customer.equals(phone.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, number, customer);
    }
}
