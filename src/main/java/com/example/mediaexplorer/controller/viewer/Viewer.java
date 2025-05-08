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

    @Value("${imagesNumOfOpenViewer}")
    private int imagesNumOfOpenViewer;

    @RequestMapping("/viewer")
    public String viewer(@RequestParam(value = "path", required = false) String path, Model model){
        if(path.contains("../")){
            throw  new IllegalArgumentException("Error path");
        }

        List<FileInfo> files = new ArrayList<>();

        String location = myResourceRoot+path;

        files = FileUtil.scanDirectory(new File(location));
        model.addAttribute("files", files);
        model.addAttribute("myResourceRoot", myResourceRoot);
        model.addAttribute("imagesNumOfOpenViewer", imagesNumOfOpenViewer);

        return "viewer";
    }

}
