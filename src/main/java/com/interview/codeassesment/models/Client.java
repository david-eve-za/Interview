package com.interview.codeassesment.models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Sales> sales = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sales> getSales() {
        return this.sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public void setSurname(String surename) {
        this.surname = surename;
    }
}
