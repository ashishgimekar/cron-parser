package com.cron.parser.model;

public enum CronEnum {
    Minute(0, "minute"),
    HOUR(1, "hour"),
    DAY_OF_MONTH(2, "day of month"),
    MONTH(3, "month"),
    DAY_OF_WEEK(4, "day of week"),
    COMMAND(5, "command");

    private final int index;
    private final String desc;

    CronEnum(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }

    public static CronEnum getByIndex(int index) {
        for(CronEnum cron : values()) {
            if(cron.index == index)
                return cron;
        }
        return null;
    }
}
