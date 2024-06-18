package com.hbelmiro.demos.intelligentjavablogreader;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface WeatherForecastService {

    @SystemMessage("You are an assistant that forecasts the weather of the city.")
    @UserMessage("""
                Here's the city, please:
                {city}
            """)
    String forecast(String city);
}
