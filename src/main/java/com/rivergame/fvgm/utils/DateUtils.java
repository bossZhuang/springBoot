package com.rivergame.fvgm.utils;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    /**
     * 返回当前时间整点
     * **/
    public static Date getCurrHourTime(Date date){
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        date = ca.getTime();
        return date;
    }

    // 获得当天0点时间
    public static long getTimesMorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }

    /**
     * yyyy-mm-dd
     * @param strDate
     * @return
     */
    public static Date string2Date(String strDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date date = sdf.parse(strDate, pos);
        return date;
    }


    public static void main(String[] args) {
        System.out.println(getCurrHourTime(new Date()));

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        System.out.println(format);

        System.out.println(getNextDay(new Date()));
    }
}
