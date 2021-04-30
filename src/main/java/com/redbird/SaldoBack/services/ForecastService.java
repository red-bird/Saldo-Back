package com.redbird.SaldoBack.services;

import com.redbird.SaldoBack.models.Forecast;

import java.util.List;

public interface ForecastService {
    public Forecast getById(Long id);
    public List<Forecast> getAll();
    public Forecast save(Forecast forecast);
    public void delete(Long id);
//    public Forecast update();
}
