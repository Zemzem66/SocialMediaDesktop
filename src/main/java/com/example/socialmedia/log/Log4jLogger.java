package com.example.socialmedia.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jLogger implements ILogger {

    private final Logger logger;
    public Log4jLogger(Class<?> clazz){
        logger = LogManager.getLogger(clazz);
    }

    @Override
    public void info(String message){
        logger.info(message);
    }
    @Override
    public void warn(String message){ logger.warn(message); }
    @Override
    public void error(String message){
        logger.error(message);
    }
    @Override
    public void fatal(String message){
        logger.fatal(message);
    }
    public void debug(String message){
        logger.debug(message);
    }
    @Override
    public void trace(String message){
        logger.trace(message);
    }
}
