package com.example.mediaexplorer.controller.configeditor;

import com.example.mediaexplorer.bean.ApiResponse;
import com.example.mediaexplorer.bean.Config;
import com.example.mediaexplorer.config.AppConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

@RestController
@RequestMapping("/config")
public class ConfigEditorApi {

    @Resource
    private AppConfig appConfig;

    @PostMapping("/update")
    public ApiResponse<Object> updateConfig(@RequestBody Config config){
        try {

            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("config.json"), config);

            appConfig.updateConfig();

            return new ApiResponse<Object>(200,"success", new HashMap());
        } catch (IOException e) {
            e.printStackTrace();
            return new ApiResponse<Object>(400,"failed", new HashMap());
        }

    }

    @GetMapping("/load")
    public ApiResponse<Config> loadconfig(){
       try {
           ObjectMapper mapper = new ObjectMapper();

           Config config = mapper.readValue(new File("config.json"), Config.class);

           return new ApiResponse<Config>(200,"success", config);
       }catch (Exception e){
            e.printStackTrace();
           return new ApiResponse<Config>(200,"failed", new Config());
       }
    }
}
