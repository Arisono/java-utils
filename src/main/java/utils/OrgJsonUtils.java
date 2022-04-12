package utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class OrgJsonUtils {


    public static void main(String[] args) {
        //
        System.out.println("时间差："+DateUtils.getDistanceTime("2016-05-01 12:00:00:000","2016-05-01 12:50:02:157"));
        //根据时间戳long  毫秒转成时间字符串

        System.out.println("dateStr="+DateUtils.getDateStr(1648913376130L));

    }

}
