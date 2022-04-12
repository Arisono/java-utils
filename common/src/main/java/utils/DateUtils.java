package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {


    /**
     *  根据毫秒时间戳转时间字符串
     *
     */
    public static  String getDateStr(long time){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String dateStr= df.format(new Date(time));
        return  dateStr;
    }


    /**
     * 统计两个时间的时间差
     * 相差几天几小时几分几秒几毫秒
     */
    public static String getDistanceTime(String str1, String str2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date one;
        Date two;
        long day = 0;//天数差
        long hour = 0;//小时数差
        long min = 0;//分钟数差
        long second=0;//秒数差
        long diff=0 ;//毫秒差
        String result = null;
        try {
            final Calendar c = Calendar.getInstance();
            c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            one = df.parse(str1);
            c.setTime(one);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            diff = time2 - time1;
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            second = diff/1000;
            System.out.println("day="+day+" hour="+hour+" min="+min+" ss="+second%60+" SSS="+diff%1000);
            result=second%60+"秒"+diff%1000+"毫秒";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}


