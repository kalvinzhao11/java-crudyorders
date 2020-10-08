package com.kalvinzhao.crudyorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    @Column
    private double advanceamount;
    private double ordamount;
    private String orderdescription;

    @ManyToOne()
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties(value = "order", allowSetters = true)  //Prevent infinite loop
    private Customer customer;

    @ManyToMany()
    @JoinTable(name = "orderspayments",
    joinColumns = @JoinColumn(name = "ordnum"),
    inverseJoinColumns =  @JoinColumn(name = "paymentid"))
    @JsonIgnoreProperties(value = "order", allowSetters = true)  //Prevent infinite loop
    private Set<Payment> payment = new HashSet<>();


    public Order() {
    }

    public Order(double advanceamount, double ordamount, Customer customer, String orderdescription) {
        this.advanceamount = advanceamount;
        this.ordamount = ordamount;
        this.orderdescription = orderdescription;
        this.customer = customer;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Payment> getPayment() {
        return payment;
    }

    public void setPayment(Set<Payment> payment) {
        this.payment = payment;
    }

    public void addPayments(Payment pay){
        this.payment.add(pay);
    }
}
