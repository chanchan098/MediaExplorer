package com.example.mediaexplorer.controller.index;

import com.example.mediaexplorer.bean.FileInfo;
import com.example.mediaexplorer.util.FileUtil;
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
    public String index(@RequestParam(value = "filename", required = false) String filename,
                        @RequestParam(value = "location", required = false) String location,
                        @RequestParam(value = "type", required = false) String type,
                        Model model){
        List<FileInfo> directory = new ArrayList<FileInfo>();
        String currentPath = location;

        if (location != null && currentPath !=null && type !=null) {

            if(!location.startsWith(myResourceRoot)){
                throw new IllegalArgumentException("Wrong path: "+location);
            }

            if (Objects.equals(type, "directory")) {
                var finalPath = currentPath+"/"+filename;
                directory = FileUtil.scanDirectory(new File(finalPath));
                location = location + "/" + filename;
            }
//            requestData.forEach((key, value) -> System.out.println(key + ": " + value));
        } else {
            location = myResourceRoot;
            directory = FileUtil.scanDirectory(new File(myResourceRoot));
        }


        viewerRules = Arrays.stream(viewerRules).map(String::strip).toArray(String[]::new);

        model.addAttribute("directoryData", directory);
        model.addAttribute("myResourceRoot", myResourceRoot);
        model.addAttribute("myLocation", location);
        model.addAttribute("viewerRules", viewerRules);


        return "index";
    }

}
