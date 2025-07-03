package com.kodat.of.melasoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MelasoftApplication {

    public static void main(String[] args) {
        System.setProperty("jdk.xml.maxOccurNodeLimit", "100001");
        SpringApplication.run(MelasoftApplication.class, args);
    }

}
