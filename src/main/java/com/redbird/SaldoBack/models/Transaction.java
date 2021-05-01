package com.redbird.SaldoBack.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
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
    @NotNull
    @CollectionTable(name = "payments", joinColumns = @JoinColumn(name = "transaction_payment"))
    @Enumerated(EnumType.STRING)
    private Payment payment;

    @NotNull
    @CollectionTable(name = "category", joinColumns = @JoinColumn(name = "transaction_category"))
    @Enumerated(EnumType.STRING)
    private Category category;

    @Hidden
    @NotNull
    @ManyToOne
    private User user;
}
