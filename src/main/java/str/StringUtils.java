package str;

import java.text.DateFormat;
import java.text.DecimalFormat;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringUtils {

    public static void main(String[] args) {

        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        try {
            Date fromDate = simpleFormat.parse("2016-05-01 12:00:03:000");
            Date toDate = simpleFormat.parse("2016-05-01 12:50:49:152");
            long from = 0;
            from = fromDate.getTime();
            long to =toDate.getTime();
            int minutes = (int) ((to - from)/(1000 * 60));
            int ss = (int) ((to - from)/(1000 ));
            long diff=to-from;
            System.out.println("minutes="+minutes);
            System.out.println("ss="+ss%60);
            System.out.println("SSS="+diff%1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("时间差："+getDistanceTime("2016-05-01 12:00:00:000","2016-05-01 12:50:02:157"));

    }





    /**
     * 统计两个时间的时间差
     * 相差几秒几毫秒
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


    // 两次点击间隔不能少于1000ms
    private static final int FAST_CLICK_DELAY_TIME = 1000;
    private static long lastClickTime;

    public static boolean isFastClick() {
        boolean flag = true;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) >= FAST_CLICK_DELAY_TIME ) {
            flag = false;
        }
        lastClickTime = currentClickTime;
        return flag;
    }


    /**
     * 解析精确到秒的时间 转换为 XX:XX格式
     */
    public static String secForTime(long mill) {
        int hour = (int) (mill / 3600);
        int minutes = (int) ((mill / 60) % 60);
        System.out.println("hour="+hour+" minutes="+minutes);
        return String.format(Locale.US, "%02d:%02d", hour, minutes);
    }



    /**
     * 以0时区显示时间戳
     * @param seconds 精确到秒的字符串
     * @param
     * @return
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(format == null){
            format = "HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }


    private static void testNull() {
        ArrayList<String> ownerPackageNames=new ArrayList<String>();

        ownerPackageNames.add("com.foscam.foscam");
        ownerPackageNames.add(null);
        System.out.println(ownerPackageNames.toString());

        if(ownerPackageNames.toString()==null){
            System.out.println("null");
        }else{
            System.out.println("not null");
        }

        if(ownerPackageNames.toString().contains("null")){
            System.out.println("contains null");
        }else{

        }
    }

    private static void testDateTime() {
        Calendar cal = Calendar.getInstance();
        TimeZone timeZone = cal.getTimeZone();
        System.out.println(timeZone.getID());
        System.out.println(timeZone.getDisplayName());
        System.out.println(timeZone.getRawOffset());

        List<String> strings=new ArrayList<String>();
        strings.add("111");
        strings.add("222");
        strings.add("111");
        strings.add("111");
        strings.add("111");

        strings.add(1,"555");

        System.out.printf("strings="+strings.toString());

        // 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
//        long time = date.getTime();
//        System.out.println(time);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = null;
        try {
            date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);   //Mon Sep 02 00:00:00 CST 2019
        // date=new Date();
        long time = date.getTime()/1000;//1638374400
        System.out.println("time:"+time);
        System.out.println("time:"+(time-30*24*3600));
        //System.out.println(simpleDateFormat.format(date));  //2019-09-02


        System.out.println("date="+getTitleDateTime("12-09-2021"));


        System.out.println("时区："+getCurrentTimeZone());
    }


    private static void testBinaryString() {
        Long ability[]={3206305475L, 3668557608L, 134397264L, 54L};
        System.out.println(Long.toBinaryString(54));
        System.out.println(Long.toString(ability[3]));
    }

    private static void testDecimalFormat() {
        double i=0.21;
        System.out.println(String.valueOf(decimalFormat(i)));
    }

    private static void test() {
        int MAX_SCREEN_COUNT=4;
        int Global=5;
        int count=  (Global/ MAX_SCREEN_COUNT + (Global % MAX_SCREEN_COUNT > 0 ? 1 : 0)) * MAX_SCREEN_COUNT;
        System.out.println("count="+count);
    }

    /**
     *
     * 数字补零
     * @param i
     * @return List<T>
     */
    public  static String  decimalFormat(double i){
        return new DecimalFormat("#0.00").format(i);
    }



    private static long getTitleDateTime(String title) {
        String dateStr=title;
        String month= dateStr.split("-")[0];
        String day= dateStr.split("-")[1];
        String year=dateStr.split("-")[2];
        dateStr=year+"-"+month+"-"+day;
        dateStr="2021-12-09 16:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime()/1000;
    }


    /**
     * 秒转换为UTC时间
     * @param second
     * @return
     */
    public static int secondToUTCTime(long second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(second * 1000);//转换为毫秒
        /** 取得时间偏移量 */
        int zoneOffset = calendar.get(java.util.Calendar.ZONE_OFFSET);
        /** 取得夏令时差 */
        int dstOffset = calendar.get(java.util.Calendar.DST_OFFSET);
        /** 从本地时间里扣除这些差量，即可以取得UTC时间*/
        calendar.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        return (int) (calendar.getTimeInMillis()/1000);
    }


    /** * 获取当前时区 * @return */
    public static String getCurrentTimeZone() {
        TimeZone tz = TimeZone.getDefault();
        String strTz = tz.getDisplayName(false, TimeZone.SHORT);
        return strTz;

    }

}
