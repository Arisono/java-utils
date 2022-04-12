package thread.task;

import java.util.Timer;

public class TimerManager {

    /**
     * 单例模式
     */
    private static TimerManager timerManager = null;


    private TimerManager(){}
    public static TimerManager getInstance(){
        if(timerManager == null){
            timerManager = new TimerManager();
        }
        return timerManager;
    }

    /**
     * 定时器
     */
    private Timer timer = new Timer("TimeCountDown");

    /**
     * 定时任务
     */
    public TimeCountDownTask timerTask = null;

    /**
     * 启动定时任务
     */
    public void startTimerTask(){
        timer.purge();
        if(timerTask==null){
            timerTask = new TimeCountDownTask();
        }
        timer.schedule(timerTask, 0, 1000);
    }

    /**
     * 启动定时任务
     */
    public void startTimerTask(CountDownListener countDownListener){
        timer.purge();
        if(timerTask==null){
            timerTask = new TimeCountDownTask(countDownListener);
        }
        timer.schedule(timerTask, 0, 1000);
    }

    /**
     * 定时任务取消
     */
    public void stopTimerTask(){
        timerTask.cancel();
        timerTask = null;//如果不重新new，会报异常
    }


}
