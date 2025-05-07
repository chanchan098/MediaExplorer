package com.example.mediaexplorer;


import com.example.mediaexplorer.bean.FileInfo;
import com.example.mediaexplorer.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class UnitTest {

    @Test
    public void folderThrough(){
        // 传入需要扫描的目录路径
        String directoryPath = "D:\\liaoyj\\DevelopmentResources"; // 修改为你的目录路径
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            FileUtil.scanDirectory(directory);
        } else {
            System.out.println("The path is not a valid directory.");
        }


        String filePath = directoryPath;

        // 使用正则表达式去掉盘符部分
        filePath = filePath.replaceAll("^[A-Za-z]:/", "");

        System.out.println(filePath); // 输出 "Users/user/Documents/file.txt"
    }


}
