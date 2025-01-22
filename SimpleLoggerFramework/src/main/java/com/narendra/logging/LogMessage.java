package com.narendra.logging;

import java.time.LocalDateTime;

public class LogMessage {
    private final String message;
    private final LocalDateTime timestamp;
    private final LogLevel logLevel;
    public LogMessage(String message, LogLevel logLevel) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    @Override
    public String toString() {
        return "[" + logLevel + "] " + "timestamp:" + timestamp + " message:" + message;
    }
}
