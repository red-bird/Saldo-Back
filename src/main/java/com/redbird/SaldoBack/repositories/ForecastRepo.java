package com.redbird.SaldoBack.repositories;

import com.redbird.SaldoBack.models.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForecastRepo extends JpaRepository<Forecast, Long> {
}
