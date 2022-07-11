package com.cron.parser.utils;

import com.cron.parser.exception.CronParserException;
import com.cron.parser.model.CronEnum;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OutputPrinterServiceTest {

    @Test
    public void testPrintOutput() {
        Map<String, String> output = new HashMap<>();
        output.put(CronEnum.Minute.getDesc(), "0 15 30 45");
        output.put(CronEnum.HOUR.getDesc(), "0");
        output.put(CronEnum.DAY_OF_MONTH.getDesc(), "1 15");
        output.put(CronEnum.MONTH.getDesc(), "1 2 3 4 5 6 7 8 9 10 11 12");
        output.put(CronEnum.DAY_OF_WEEK.getDesc(), "1 2 3 4 5 6");
        output.put(CronEnum.COMMAND.getDesc(), "/usr/bin/find");

        OutputPrinterService.printOutput(output);
    }

    @Test(expected = CronParserException.class)
    public void testPrintOutputWithError() {
        Map<String, String> output = new HashMap<>();
        output.put(CronEnum.Minute.getDesc(), "0 15 30 45");
        output.put(CronEnum.HOUR.getDesc(), "0");
        output.put(CronEnum.DAY_OF_MONTH.getDesc(), "1 15");
        output.put(CronEnum.MONTH.getDesc(), "1 2 3 4 5 6 7 8 9 10 11 12");
        output.put(CronEnum.DAY_OF_WEEK.getDesc(), "1 2 3 4 5 6");
        // missing command
        OutputPrinterService.printOutput(output);
    }

}
