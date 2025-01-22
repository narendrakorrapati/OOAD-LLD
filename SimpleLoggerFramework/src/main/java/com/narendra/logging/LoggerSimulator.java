package com.narendra.logging;

import com.narendra.logging.appenders.FileLogAppender;

public class LoggerSimulator {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.getLogConfiguration().addLogAppender(new FileLogAppender("F:\\Learning\\2024\\OOAD\\logger\\log.txt"));

        logger.debug("debug message");
        logger.info("info message");
        logger.warning("warning message");
        logger.error("error message");
        logger.fatal("fatal message");
    }
}
