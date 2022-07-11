package com.cron.parser.model;

import org.junit.Assert;
import org.junit.Test;

public class CronEnumTest {

    @Test
    public void testGetByIndexValidIndex() {
        Assert.assertTrue(CronEnum.Minute == CronEnum.getByIndex(0));
    }

    @Test
    public void testGetByIndexInvalidIndex() {
        Assert.assertTrue(null == CronEnum.getByIndex(10));
    }
}
