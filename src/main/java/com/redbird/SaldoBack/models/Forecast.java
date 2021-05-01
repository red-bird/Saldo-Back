package com.redbird.SaldoBack.models;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Monthly forecast that the client makes himself
 */
@Data
@Entity
@Table(name = "forecasts")
@RequiredArgsConstructor
public class Forecast {

    /**
     * Id of forecast
     */
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Total amount of forecast
     */
    @NotNull
    private Double amount;
    /**
     * Year and month of forecast
     */
    @NotNull
    private ZonedDateTime date;

    @Hidden
    @NotNull
    @ManyToOne
    private User user;
}
