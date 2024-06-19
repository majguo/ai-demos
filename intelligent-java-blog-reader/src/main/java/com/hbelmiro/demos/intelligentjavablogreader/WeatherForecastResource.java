package com.hbelmiro.demos.intelligentjavablogreader;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Path("/weather")
public class WeatherForecastResource {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(WeatherForecastResource.class);

    private final WeatherForecastService weatherForecastService;
    private final String weatherHistory;

    @Inject
    public WeatherForecastResource(WeatherForecastService weatherForecastService) throws IOException {
        this.weatherForecastService = weatherForecastService;
        this.weatherHistory = new String(getClass().getClassLoader().getResourceAsStream("Paris.csv").readAllBytes());
    }

    @Path("/ask")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String askAi(String question) {

        LOGGER.info("\uD83D\uDCDD Preparing response...");

        String result = weatherForecastService.ask(
            LocalDate.now().toString(),
            "Paris",
            weatherHistory,
            question
        );

        LOGGER.info("✅ Response for \"{}\" ready", question);

        return result;
    }
}