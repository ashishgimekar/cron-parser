package com.cron.parser.service.impl;

import com.cron.parser.exception.CronParserException;
import com.cron.parser.model.CronEnum;
import com.cron.parser.service.ICronParserService;
import com.cron.parser.utils.Constants;

import java.util.HashMap;
import java.util.Map;

import static com.cron.parser.utils.Constants.*;

public class CronParserServiceImpl implements ICronParserService {

    @Override
    public Map<String, String> parseCronExpression(String expression) {
        String[] inputs = expression.split(" ");

        // validate input
        if(inputs.length != 6) {
            throw new CronParserException(Constants.INVALID_INPUT);
        }
        Map<String, String> output = new HashMap<>();

        // traversing the input array
        for(int index = 0; index < 6; index++) {
            handleInput(inputs[index], CronEnum.getByIndex(index), output);
        }

        return output;
    }

    private void handleInput(String input, CronEnum cronEnum, Map<String, String> output) {
        if(cronEnum == null) {
            throw new CronParserException(Constants.INVALID_ENUM);
        }

        String expandedString = null;

        switch (cronEnum) {
            case Minute:
                expandedString = CronExpansionService.expandCron(input, MIN_MINUTE_VALUE, MAX_MINUTE_VALUE);
                output.put(CronEnum.Minute.getDesc(), expandedString);
                break;
            case HOUR:
                expandedString = CronExpansionService.expandCron(input, MIN_HOUR_VALUE, MAX_HOUR_VALUE);
                output.put(CronEnum.HOUR.getDesc(), expandedString);
                break;
            case DAY_OF_MONTH:
                expandedString = CronExpansionService.expandCron(input, MIN_DAY_OF_MONTH_VALUE, MAX_DAY_OF_MONTH_VALUE);
                output.put(CronEnum.DAY_OF_MONTH.getDesc(), expandedString);
                break;
            case MONTH:
                expandedString = CronExpansionService.expandCron(input, MIN_MONTH_VALUE, MAX_MONTH_VALUE);
                output.put(CronEnum.MONTH.getDesc(), expandedString);
                break;
            case DAY_OF_WEEK:
                expandedString = CronExpansionService.expandCron(input, MIN_DAY_OF_WEEK_VALUE, MAX_DAY_OF_WEEK_VALUE);
                output.put(CronEnum.DAY_OF_WEEK.getDesc(), expandedString);
                break;
            case COMMAND:
                output.put(CronEnum.COMMAND.getDesc(), input);
                break;
        }
    }

}
