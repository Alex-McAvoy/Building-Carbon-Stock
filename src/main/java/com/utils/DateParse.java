package com.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Description: 日期解析
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 23:00
 * @Version: 1.0
 **/
public class DateParse {
    private String date;

    public DateParse() {
    }

    public DateParse(String date) {
        this.date = date;
    }

    public Date getCreatedTime() {
        LocalDate localDate = LocalDate.parse(date);
        ZoneId zoneId = ZoneId.systemDefault();
        Date createdTime = Date.from(localDate.atStartOfDay().atZone(zoneId).toInstant());
        return createdTime;
    }
}
