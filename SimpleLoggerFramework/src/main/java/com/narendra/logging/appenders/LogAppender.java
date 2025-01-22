package com.narendra.logging.appenders;

import com.narendra.logging.LogMessage;

public interface LogAppender {
    void log(LogMessage logMessage);
}
