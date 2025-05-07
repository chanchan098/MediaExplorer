package com.example.mediaexplorer.controller.viewer;

import com.example.mediaexplorer.bean.FileInfo;
import com.example.mediaexplorer.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Viewer {
    @Value("${myResourceRoot}")
    private String myResourceRoot;

    @RequestMapping("/viewer")
    public String viewer(@RequestParam(value = "location", required = false) String location, Model model){
        List<FileInfo> files = new ArrayList<>();
        if (location != null ) {

            if(!location.startsWith(myResourceRoot)){
                throw new IllegalArgumentException("Wrong path: "+location);
            }
            files = FileUtil.scanDirectory(new File(location));

        }
        model.addAttribute("files", files);
        model.addAttribute("myLocation", location);
        model.addAttribute("myResourceRoot", myResourceRoot);
        return "viewer";
    }

}
