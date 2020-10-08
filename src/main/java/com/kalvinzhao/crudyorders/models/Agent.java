package com.kalvinzhao.crudyorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    @Column(nullable = false)
    private String agentname;
    private double commission;
    private String country;
    private String phone;
    private String workingarea;

    @OneToMany(mappedBy = "agent",
        cascade = CascadeType.ALL, //cascadetype.all anything I do to the restaurant, I want to affect the menu
        orphanRemoval = true)
    @JsonIgnoreProperties(value = "agent", allowSetters = true)  //Prevent infinite loop
    private Set<Customer> customers = new HashSet<>();

    public Agent() {
    }

    public Agent(String agentname, String country, double commission, String phone, String workingarea) {
        this.agentname = agentname;
        this.commission = commission;
        this.country = country;
        this.phone = phone;
        this.workingarea = workingarea;
    }

    public long getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(long agentcode) {
        this.agentcode = agentcode;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
