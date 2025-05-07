package com.example.mediaexplorer.controller.index;

import com.example.mediaexplorer.bean.FileInfo;
import com.example.mediaexplorer.util.FileUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.*;

@Controller
public class Index {

    @Value("${myResourceRoot}")
    private String myResourceRoot;

    @Value("#{'${viewerRules}'.split(',')}")
    private String[] viewerRules;

    @RequestMapping("/")
    public String index(@RequestParam(defaultValue = "/") String path,
                        Model model){

        if(path.contains("../")){
            throw  new IllegalArgumentException("Error path");
        }

        List<FileInfo> directory = new ArrayList<FileInfo>();

//        if(!location.startsWith(myResourceRoot)){
//            throw new IllegalArgumentException("Wrong path: "+location);
//        }
        String location = myResourceRoot+path;
        directory = FileUtil.scanDirectory(new File(location));


        viewerRules = Arrays.stream(viewerRules).map(String::strip).toArray(String[]::new);

        model.addAttribute("directoryData", directory);
        model.addAttribute("myResourceRoot", myResourceRoot);
        model.addAttribute("viewerRules", viewerRules);

        return "index";
    }

}
