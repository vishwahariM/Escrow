package com.example.Escrow.milestone.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "milestones")
public class milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private BigDecimal amount;

    private String status;

    private boolean clientApproved;

    private boolean paymentReleased;

    public milestone() {
    }

    public milestone(String title,
                     String description,
                     BigDecimal amount,
                     String status,
                     boolean clientApproved,
                     boolean paymentReleased) {

        this.title = title;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.clientApproved = clientApproved;
        this.paymentReleased = paymentReleased;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isClientApproved() {
        return clientApproved;
    }

    public void setClientApproved(boolean clientApproved) {
        this.clientApproved = clientApproved;
    }

    public boolean isPaymentReleased() {
        return paymentReleased;
    }

    public void setPaymentReleased(boolean paymentReleased) {
        this.paymentReleased = paymentReleased;
    }
}