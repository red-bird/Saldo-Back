package com.redbird.SaldoBack.controllers;

import com.redbird.SaldoBack.models.Forecast;
import com.redbird.SaldoBack.services.ForecastService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    @GetMapping("/admin/{id}")
    @PreAuthorize("hasAuthority('permission:admin')")
    public Forecast getById(@PathVariable("id") Long id) {
        return forecastService.getById(id);
    }

    /**
     * Endpoint to get all forecasts
     * @return List of all forecasts
     */
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('permission:admin')")
    public List<Forecast> getAll() {
        return forecastService.getAll();
    }

    /**
     * Endpoint to save forecast
     * @param forecast - forecast to save
     * @return Saved forecast
     */
    @PostMapping
    @PreAuthorize("hasAuthority('permission:user')")
    public Forecast save(@RequestBody Forecast forecast, Principal principal) {
        return forecastService.save(forecast, principal.getName());
    }

    /**
     * Endpoint to delete forecast
     * @param id - id of forecast
     */
    @DeleteMapping("/admin/{id}")
    @PreAuthorize("hasAuthority('permission:admin')")
    public void delete(@PathVariable("id") Long id) {
        forecastService.delete(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('permission:user')")
    public void deleteByUser(@PathVariable("id") Long id, Principal principal) {
        forecastService.deleteByUser(id, principal.getName());
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('permission:user')")
    public List<Forecast> getAllByUser(Principal principal) {
        return forecastService.getAllByUser(principal.getName());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('permission:user')")
    public Forecast getByIdByUser(@PathVariable Long id, Principal principal) {
        return forecastService.getByIdByUser(id, principal.getName());
    }
}
