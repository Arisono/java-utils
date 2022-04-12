package thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class CountDownTask   {

    public static int time = 120;
    public static Calendar c;
    public static long endTime;
    public static Date date;
    public static long startTime;
    public static long midTime =120;

    public static void main(String[] args) {
//        c = Calendar.getInstance();
//        c.set(2017, 4, 17, 0, 0, 0);// 注意月份的设置，0-11表示1-12月
//        // c.set(Calendar.YEAR, 2017);
//        // c.set(Calendar.MONTH, 4);
//        // c.set(Calendar.DAY_OF_MONTH, 17);
//        // c.set(Calendar.HOUR_OF_DAY, 0);
//        // c.set(Calendar.MINUTE, 0);
//        // c.set(Calendar.SECOND, 0);
//        endTime = c.getTimeInMillis();
//        date = new Date();
//        startTime = date.getTime();
//        midTime = (endTime - startTime) / 1000;
        time3();

    }

    public static TimerTask timerTask;
    /**
     * 方式三： 使用java.util.Timer类进行倒计时
     */
    private static void time3() {
        final Timer timer = new Timer();
        timerTask=  new TimerTask() {
            public void run() {
                midTime--;
                long hh = midTime / 60 / 60 % 60;
                long mm = midTime / 60 % 60;
                long ss = midTime % 60;
                System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
                if (mm==0){
                    if (ss<=10){
                        System.out.println("倒计时10秒开始！"+ss +"秒");
                        if (ss==0){
                            System.out.println("倒计时结束！");
                             timerTask.cancel();
                             timerTask=null;
                        }
                    }
                }

            }
        };
        timer.schedule(timerTask, 0, 1000);
    }


}
