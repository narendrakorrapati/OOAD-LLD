package com.narendra.logging;

import com.narendra.logging.appenders.ConsoleLogAppender;
import com.narendra.logging.appenders.LogAppender;

public class Logger {
    private LogConfiguration logConfiguration;
    private static final Logger INSTANCE = new Logger();
    private Logger() {
        logConfiguration = new LogConfiguration(LogLevel.INFO);
        logConfiguration.addLogAppender(new ConsoleLogAppender());
    }

    public static Logger getInstance() {
        return INSTANCE;
    }
    public LogConfiguration getLogConfiguration() {
        return logConfiguration;
    }

    public void setLogConfiguration(LogConfiguration logConfiguration) {
        this.logConfiguration = logConfiguration;
    }

    private void log(LogLevel logLevel, String message) {
        if(logLevel.ordinal() >= logConfiguration.getLogLevel().ordinal()) {
            for(LogAppender logAppender : logConfiguration.getLogAppenders()) {
                logAppender.log(new LogMessage(message, logLevel));
            }
        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
