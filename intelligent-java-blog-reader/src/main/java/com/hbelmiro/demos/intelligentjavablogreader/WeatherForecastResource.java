package com.hbelmiro.demos.intelligentjavablogreader;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;

import java.util.List;

@Path("/weather")
public class WeatherForecastResource {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(WeatherForecastResource.class);

    private final WeatherForecastService weatherForecastService;

    @Inject
    public WeatherForecastResource(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @Path("/forecast")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String forecast(String city) {

        LOGGER.info("\uD83D\uDCDD Preparing response...");

        String result = weatherForecastService.forecast(city);

        LOGGER.info("✅ Response for {} ready", city);

        return result;
    }
}