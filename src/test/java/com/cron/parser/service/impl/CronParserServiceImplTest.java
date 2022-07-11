package com.cron.parser.service.impl;

import com.cron.parser.exception.CronParserException;
import com.cron.parser.model.CronEnum;
import com.cron.parser.service.ICronParserService;
import com.cron.parser.utils.OutputPrinterService;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CronParserServiceImplTest {

    @Test
    public void testParseCronExpression() {
        Map<String, String> expected = new HashMap<>();
        expected.put(CronEnum.Minute.getDesc(), "0 15 30 45");
        expected.put(CronEnum.HOUR.getDesc(), "0");
        expected.put(CronEnum.DAY_OF_MONTH.getDesc(), "1 15");
        expected.put(CronEnum.MONTH.getDesc(), "1 2 3 4 5 6 7 8 9 10 11 12");
        expected.put(CronEnum.DAY_OF_WEEK.getDesc(), "1 2 3 4 5");
        expected.put(CronEnum.COMMAND.getDesc(), "/usr/bin/find");

        ICronParserService cronParserService = new CronParserServiceImpl();
        Map<String, String> actual = cronParserService.parseCronExpression("*/15 0 1,15 * 1-5 /usr/bin/find");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParseCronExpressionWithAllStar() {
        Map<String, String> expected = new HashMap<>();
        expected.put(CronEnum.Minute.getDesc(), "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59");
        expected.put(CronEnum.HOUR.getDesc(), "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23");
        expected.put(CronEnum.DAY_OF_MONTH.getDesc(), "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31");
        expected.put(CronEnum.MONTH.getDesc(), "1 2 3 4 5 6 7 8 9 10 11 12");
        expected.put(CronEnum.DAY_OF_WEEK.getDesc(), "0 1 2 3 4 5 6");
        expected.put(CronEnum.COMMAND.getDesc(), "/usr/bin/find");

        ICronParserService cronParserService = new CronParserServiceImpl();
        Map<String, String> actual = cronParserService.parseCronExpression("* * * * * /usr/bin/find");
        OutputPrinterService.printOutput(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParseCronExpressionWithOverlappingMinuteRange() {
        Map<String, String> expected = new HashMap<>();
        expected.put(CronEnum.Minute.getDesc(), "10 12 14 15 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58");
        expected.put(CronEnum.HOUR.getDesc(), "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23");
        expected.put(CronEnum.DAY_OF_MONTH.getDesc(), "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31");
        expected.put(CronEnum.MONTH.getDesc(), "1 2 3 4 5 6 7 8 9 10 11 12");
        expected.put(CronEnum.DAY_OF_WEEK.getDesc(), "0 1 2 3 4 5 6");
        expected.put(CronEnum.COMMAND.getDesc(), "/usr/bin/find");

        ICronParserService cronParserService = new CronParserServiceImpl();
        Map<String, String> actual = cronParserService.parseCronExpression("15,10/2 * * * * /usr/bin/find");
        OutputPrinterService.printOutput(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = CronParserException.class)
    public void testParseCronExpressionWithPartialInput() {
        ICronParserService cronParserService = new CronParserServiceImpl();
        cronParserService.parseCronExpression("*/15 0 1,15 * 1-5");
    }

}
