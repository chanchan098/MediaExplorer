package com.example.mediaexplorer.util;

import com.example.mediaexplorer.bean.FileInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {
    public static List<FileInfo> scanDirectory(File directory) {
        // 获取目录中的所有文件和子目录
        File[] files = directory.listFiles();

        if (files != null) {
            // 将文件和目录封装成 FileInfo 对象
            FileInfo[] fileInfos = Arrays.stream(files)
                    .map(file -> new FileInfo(
                            file.getName(),
                            file.isDirectory() ? "directory" : "file",
                            file.lastModified()))
                    .toArray(FileInfo[]::new);

            List<FileInfo> directories = Arrays.stream(fileInfos)
                    .filter(file -> file.getType().equals("directory"))
                    .sorted(Comparator.comparing(FileInfo::getFilename, String.CASE_INSENSITIVE_ORDER))
                    .collect(Collectors.toList());

            List<FileInfo> files2 = Arrays.stream(fileInfos)
                    .filter(file -> file.getType().equals("file"))
                    .sorted(Comparator.comparing(FileInfo::getFilename, String.CASE_INSENSITIVE_ORDER))
                    .collect(Collectors.toList());

            List<FileInfo> res = new ArrayList<>();
            res.addAll(directories);
            res.addAll(files2);

            // 输出文件和目录
//            for (FileInfo fileInfo : res) {
//                System.out.println(fileInfo);
//            }
//            System.out.println(res.size());

            return res;

        }
        return new ArrayList<>();
    }
}
