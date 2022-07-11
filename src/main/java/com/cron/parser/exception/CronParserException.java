package com.cron.parser.exception;

public class CronParserException extends RuntimeException {

    public CronParserException() {
        super();
    }

    public CronParserException(String message) {
        super(message);
        System.out.println("Exception : " + message);
    }
}
