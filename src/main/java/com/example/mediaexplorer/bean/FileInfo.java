package com.example.mediaexplorer.bean;

import java.io.File;

public class FileInfo {
    private String filename;  // 文件名
    private String type;      // 文件类型（目录或文件）
    private long lastModified; // 最后修改时间（创建时间）

    // 构造函数
    public FileInfo(String filename, String type, long lastModified) {
        this.filename = filename;
        this.type = type;
        this.lastModified = lastModified;
    }

    // Getter 和 Setter 方法
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    // 重写 toString 方法以便打印文件信息
    @Override
    public String toString() {
        return "FileInfo{filename='" + filename + "', type='" + type + "', lastModified=" + lastModified + '}';
    }
}
