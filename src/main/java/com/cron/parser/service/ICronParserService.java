package com.cron.parser.service;

import java.util.Map;

public interface ICronParserService {

    Map<String, String> parseCronExpression(String expression);

}
