package com.example.socialmedia.log;

public class LoggerFactory {
    public static ILogger createLogger(Class<?> clazz){
        return new Log4jLogger(clazz);
    }
}
