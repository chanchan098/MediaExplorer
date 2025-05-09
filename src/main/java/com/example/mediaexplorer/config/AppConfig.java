package com.example.mediaexplorer.config;


import com.example.mediaexplorer.bean.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class AppConfig {

    private volatile Config config;

    public void updateConfig() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            config = mapper.readValue(new File("config.json"), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Config getConfig() {
        if (config == null) {
            updateConfig();
        }
        return config;
    }

}
