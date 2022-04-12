package thread.task;

import java.util.Timer;
import java.util.TimerTask;

public class TimeCountDownTask extends TimerTask {

    public  long midTime =120;
    private CountDownListener countDownListener;

    public TimeCountDownTask() {
    }

    public TimeCountDownTask(CountDownListener countDownListener) {
        this.countDownListener=countDownListener;
    }

    @Override
    public void run() {
        midTime--;
        long hh = midTime / 60 / 60 % 60;
        long mm = midTime / 60 % 60;
        long ss = midTime % 60;
        //System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
        if (countDownListener!=null){
            countDownListener.countDownInfoNotice(mm,ss);
        }
        if (mm==0){
            if (ss<=10){
               // System.out.println("倒计时10秒开始！"+ss +"秒");
                countDownListener.countDownLastTenSeconds(ss);
                if (ss==0){
                  //  System.out.println("倒计时结束！");
                    TimerManager.getInstance().stopTimerTask();
                    countDownListener.countDownEnd();
                }
            }
        }

    }
}
