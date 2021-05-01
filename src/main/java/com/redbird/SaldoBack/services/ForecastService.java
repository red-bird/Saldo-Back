package com.redbird.SaldoBack.services;

import com.redbird.SaldoBack.models.Forecast;

import java.util.List;

public interface ForecastService {
    public Forecast getById(Long id);
    public List<Forecast> getAll();
    public Forecast save(Forecast forecast, String username);
    public void delete(Long id);
    public void deleteByUser(Long id, String username);
    public Forecast getByIdByUser(Long id, String username);
    public List<Forecast> getAllByUser(String username);
//    public Forecast update();
}
