package com.narendra.logging;

import com.narendra.logging.appenders.LogAppender;

import java.util.ArrayList;
import java.util.List;

public class LogConfiguration {
    private final LogLevel logLevel;
    private final List<LogAppender> logAppenders;

    public LogConfiguration(LogLevel logLevel) {
        this.logLevel = logLevel;
        this.logAppenders = new ArrayList<>();
    }

    public void addLogAppender(LogAppender logAppender) {
        logAppenders.add(logAppender);
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public List<LogAppender> getLogAppenders() {
        return logAppenders;
    }
}
