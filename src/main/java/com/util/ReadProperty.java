package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {


    static Properties pro;

    public static Properties getProperty(){
        pro = new Properties();
        try {
            FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\config\\objectRepo.properties");
            pro.load(fi);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return pro;
    }

    public static String propertyReader(String key){
        pro = getProperty();
        return pro.getProperty(key);
    }

}
