package com.caribou.bank.config;

import org.springframework.http.HttpHeaders;

public class HeaderUtil {


    public static HttpHeaders createEntityCreationAlert(String applicationName, boolean enableTranslation,
    String entityName, String param)
    {
        String message = enableTranslation ? applicationName  + "." + entityName + ".created" :
                "A new " + entityName + "is created with identifier "+param;
        HttpHeaders header = new HttpHeaders();
        header.add("X-" + applicationName + "-alert", message);
        //ye header dige ham bood nanveshtam
        return  header;

    }
}
