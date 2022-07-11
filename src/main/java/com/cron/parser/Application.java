package com.cron.parser;

import com.cron.parser.exception.CronParserException;
import com.cron.parser.service.impl.CronParserServiceImpl;
import com.cron.parser.service.ICronParserService;
import com.cron.parser.utils.Constants;
import com.cron.parser.utils.OutputPrinterService;

import java.util.Map;

public class Application
{
    public static void main(String[] args)
    {
        if(args.length != 1) {
            throw new CronParserException(Constants.EMPTY_INPUT);
        }
        String input = args[0];
        ICronParserService cronParserServiceImpl = new CronParserServiceImpl();

        Map<String, String> output = cronParserServiceImpl.parseCronExpression(input);
        OutputPrinterService.printOutput(output);
    }
}
