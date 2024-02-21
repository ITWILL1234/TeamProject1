package com.itwill.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConfig {
    private static final String FILE_NAME = "database.properties";
    private static final Properties prop = new Properties();

    // static 초기화 블록을 사용하여 클래스 로딩 시 설정값 로드
    static {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Database 설정 파일 로딩 실패", e);
        }
    }

    public static String getDbUrl() {
        return prop.getProperty("db.url");
    }

    public static String getDbUser() {
        return prop.getProperty("db.user");
    }

    public static String getDbPassword() {
        return prop.getProperty("db.password");
    }
}