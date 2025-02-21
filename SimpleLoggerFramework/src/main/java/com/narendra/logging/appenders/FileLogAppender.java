package com.narendra.logging.appenders;

import com.narendra.logging.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogAppender implements LogAppender{
    private final String filePath;
    public FileLogAppender(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public synchronized void log(LogMessage logMessage) {
        try(FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(logMessage.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFilePath() {
        return filePath;
    }
}
