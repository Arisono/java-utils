package thread.task;

public class TaskMain {

    public static void main(String[] args) {
        TimerManager.getInstance().startTimerTask(new CountDownListener() {
            @Override
            public void countDownEnd() {
                System.out.println("倒计时结束！");
            }

            @Override
            public void countDownInfoNotice(long mm, long ss) {
                System.out.println("还剩"  + mm + "分钟" + ss + "秒");
            }

            @Override
            public void countDownLastTenSeconds(long ss) {
                System.out.println("倒计时10秒开始！  "+ss +"秒");
            }
        });
    }
}
