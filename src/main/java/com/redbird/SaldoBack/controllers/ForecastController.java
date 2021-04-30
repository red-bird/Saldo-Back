package com.redbird.SaldoBack.controllers;

import com.redbird.SaldoBack.models.Forecast;
import com.redbird.SaldoBack.services.ForecastService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for forecast entities
 */
@RestController
@RequestMapping("/api/forecast")
public class ForecastController {

    private final ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    /**
     * Endpoint to get forecast by id
     * @param id - id of forecast
     * @return Forecast object
     */
    @GetMapping("/{id}")
    public Forecast getById(@PathVariable("id") Long id) {
        return forecastService.getById(id);
    }

    /**
     * Endpoint to get all forecasts
     * @return List of all forecasts
     */
    @GetMapping
    public List<Forecast> getAll() {
        return forecastService.getAll();
    }

    /**
     * Endpoint to save forecast
     * @param forecast - forecast to save
     * @return Saved forecast
     */
    @PostMapping
    public Forecast save(@RequestBody Forecast forecast) {
        return forecastService.save(forecast);
    }

    /**
     * Endpoint to delete forecast
     * @param id - id of forecast
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        forecastService.delete(id);
    }
}
