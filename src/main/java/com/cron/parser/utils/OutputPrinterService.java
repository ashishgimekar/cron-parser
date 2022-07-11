package com.cron.parser.utils;

import com.cron.parser.exception.CronParserException;
import com.cron.parser.model.CronEnum;

import java.util.Map;

public class OutputPrinterService {

    public static void printOutput(Map<String, String> output) {
        for(CronEnum cronEnum: CronEnum.values()) {
            if(!output.containsKey(cronEnum.getDesc())) {
                throw new CronParserException("Invalid " + cronEnum);
            }
            printLine(cronEnum.getDesc(), output.get(cronEnum.getDesc()));
        }
    }

    private static void printLine(String key, String value) {
        System.out.println(String.format(Constants.KEY_FORMAT, key) + value);
    }

}
