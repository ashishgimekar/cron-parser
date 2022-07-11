package com.cron.parser;

import static org.junit.Assert.assertTrue;

import com.cron.parser.exception.CronParserException;
import org.junit.Test;

public class ApplicationTest
{
    @Test(expected = CronParserException.class)
    public void testIfInputIsEmpty()
    {
        Application.main(new String[0]);
    }
}
