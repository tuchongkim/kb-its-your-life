package ch15.sec00;

import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        // 파일을 읽기용으로 load
        properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));

        
    }
}
