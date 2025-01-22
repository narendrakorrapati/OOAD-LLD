package com.narendra.logging.appenders;

import com.narendra.logging.LogMessage;

public class ConsoleLogAppender implements LogAppender{
    @Override
    public void log(LogMessage logMessage) {
        System.out.println(logMessage);
    }
}
