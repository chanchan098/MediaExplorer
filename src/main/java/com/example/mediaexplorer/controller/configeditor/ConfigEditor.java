package com.example.mediaexplorer.controller.configeditor;


import com.example.mediaexplorer.bean.Config;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigEditor {


    @RequestMapping("/configeditor")
    public String configEditor(){

        return "configeditor";
    }

}
