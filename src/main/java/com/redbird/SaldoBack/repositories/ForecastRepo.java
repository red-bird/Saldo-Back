package com.redbird.SaldoBack.repositories;

import com.redbird.SaldoBack.models.Forecast;
import com.redbird.SaldoBack.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForecastRepo extends JpaRepository<Forecast, Long> {
    List<Forecast> findAllByUser(User user);
}
