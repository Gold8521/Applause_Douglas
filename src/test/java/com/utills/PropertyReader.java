package com.utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    protected static Properties prop;

    public static Properties getProp() {
        if (prop == null) {
            prop = new Properties();
            try (FileInputStream fis = new FileInputStream("C:\\\\Users\\\\ADMIN\\\\IdeaProjects\\\\Applause_Douglas\\\\config.properties")) {
                prop.load(fis);
            } catch (IOException e) {
                System.out.println(STR."Warning: \{e.getMessage()}");
            }
        }
        return prop;
    }
}
