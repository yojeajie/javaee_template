package cn.com.allunion.common;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理工具类
 * Created by YangJie on 2016/4/18.
 */
public class DateUtils {
    /**
     * 将日期字符串转化为日期
     * @param dateString 日期字符串
     * @param pattern 日期字符串格式
     * @return 转化后的日期对象
     */
    public static Date convertToDate(String dateString, String pattern)  {
        SimpleDateFormat sfd = new SimpleDateFormat(pattern) ;
        try {
            return sfd.parse(dateString) ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null ;
    }

    /**
     * 根据日期对象构建指定格式的日期字符串
     * @param date 日期对象
     * @param pattern 日期格式字符串
     * @return 构建好的日期字符串，如果data为null或者pattern为空字符串，返回 ""
     */
    public static String buildDateString(Date date, String pattern) {
        if (null == date || StringUtils.isEmpty(pattern)) {
           return "" ;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern) ;
        return sdf.format(date) ;
    }

    /**
     * 计算日期差
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 返回时间差
     */
    public static int daysBetween(Date startTime, Date endTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endTime);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days)) + 1;
    }

    /**
     * 计算两个日期的相差天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 两个日期相差天数
     */
    public static int calculateDays(Date start, Date end) {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(start);

        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(end);
        int days = Math.abs((int) ((calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis()) / (1000 * 60 * 60 * 24) + 1));  // 获取多少天的用户

        return days;
    }

    /**
     * 返回格式化好的 开始时间
     * @param startDate
     * @return
     */
    public static Date startToDate(Date startDate){
        return DateUtils.convertToDate(DateUtils.buildDateString(startDate,"yyyy-MM-dd")+" 00:00:00","yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 返回格式化好的 结束时间
     * @param endDate
     * @return
     */
    public static Date endToDate(Date endDate){
        return DateUtils.convertToDate(DateUtils.buildDateString(endDate,"yyyy-MM-dd")+" 23:59:59","yyyy-MM-dd HH:mm:ss");
    }
}
