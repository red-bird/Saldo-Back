package com.redbird.SaldoBack.servicesImpl;

import com.redbird.SaldoBack.models.Forecast;
import com.redbird.SaldoBack.models.User;
import com.redbird.SaldoBack.repositories.ForecastRepo;
import com.redbird.SaldoBack.services.ForecastService;
import com.redbird.SaldoBack.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class which process queries about forecast
 */
@Service
@Transactional
@Slf4j
public class ForecastServiceImpl implements ForecastService {

    private final ForecastRepo forecastRepo;
    private final UserService userService;

    public ForecastServiceImpl(ForecastRepo forecastRepo, UserService userService) {
        this.forecastRepo = forecastRepo;
        this.userService = userService;
    }

    /**
     * Get forecast by it's id
     * @param id - unique number of forecast
     * @return Forecast object
     */
    @Override
    public Forecast getById(Long id) {
        Forecast forecast = forecastRepo.findById(id).orElse(null);
//        log.info(String.format("get %s", forecast.toString()));
        return forecast;
    }

    /**
     * Get all forecasts
     * @return List of forecast objects
     */
    @Override
    public List<Forecast> getAll() {
        List<Forecast> all = forecastRepo.findAll();
        log.info(String.format("get %s", all));
        return all;
    }

    /**
     * Save forecast
     * @param forecast forecast object to save
     * @return forecast object that was saved to DB
     */
    @Override
    public Forecast save(Forecast forecast, String username) {
        forecast.setUser(userService.findByUsername(username));
        Forecast save = forecastRepo.save(forecast);
        log.info(String.format("save %s", forecast));
        return save;
    }

    /**
     * Delete forecast by it's id
     * @param id - id of forecast
     */
    @Override
    public void delete(Long id) {
        forecastRepo.deleteById(id);
        log.info(String.format("delete forecast id%s", id));
    }

    @Override
    public void deleteByUser(Long id, String username) {
        Forecast forecast = getById(id);
        if (username.equals(forecast.getUser().getUsername())) {
            forecastRepo.deleteById(id);
        }
    }

    @Override
    public Forecast getByIdByUser(Long id, String username) {
        Forecast forecast = getById(id);
        return username.equals(forecast.getUser().getUsername()) ? forecast : null;
    }

    @Override
    public List<Forecast> getAllByUser(String username) {
        User user = userService.findByUsername(username);
        return forecastRepo.findAllByUser(user);
    }
}
