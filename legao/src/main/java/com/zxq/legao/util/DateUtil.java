package com.zxq.legao.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * <p>
 * 日期工具类
 * </p>
 *
 * @author dengzhenxiang
 * @Date 2018/11/11 17:41
 */
public class DateUtil {

    /**
     * 根据日期计算年龄
     *
     * @param date
     * @return
     */
    public static String getAge(Date date) {
        Long currentTime = System.currentTimeMillis();
        if ((currentTime - date.getTime()) <= 0 || date == null) {
            return "0岁0个月";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());

        int ageyear = calendar1.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        int agemonth = calendar1.get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
        if (agemonth <= 0) {
            agemonth = 0;
        }
        String age = ageyear + "岁" + agemonth + "个月";
        return age;

    }

    /**
     *  计算星期,周数
     * @param date
     * @return
     */
    public static List<Integer> getWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Integer week = calendar.get(Calendar.DAY_OF_WEEK);
        Integer weekYear = calendar.get(Calendar.WEEK_OF_YEAR);
        List<Integer> dateList = new ArrayList<>(2);
        dateList.add(week);
        dateList.add(weekYear);
        return dateList;
    }


}
