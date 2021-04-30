package com.redbird.SaldoBack.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Class which describes transactions that the client has made
 */
@Data
@Entity
@Table(name = "transactions")
@RequiredArgsConstructor
public class Transaction {

    /**
     * Id of transaction
     */
    @JsonIgnore
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Total transaction amount
     */
    @NotNull
    private Double amount;
    /**
     * Transaction title
     */
    @NotNull
    private String title;
    /**
     * Transaction description
     */
    private String description;
    /**
     * Transaction date
     */
    @NotNull
    private ZonedDateTime date;
    /**
     * Type of transaction
     */
    @CollectionTable(name = "payments", joinColumns = @JoinColumn(name = "transaction_payment"))
    @Enumerated(EnumType.STRING)
    private Payment payment;
}
