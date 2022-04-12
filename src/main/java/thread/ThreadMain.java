package thread;

public class ThreadMain {

    public static void main(String[] args) {
        User user=new User();
        user.startEvent();
        user.startEvent();
        user.startEvent();
        user.startEvent();
        user.startEvent();

        User user1=new User();
        user1.startEvent();
        user1.startEvent();
        user1.startEvent();

        User user2=new User();
        user2.startEvent();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("30秒时间到了，准备关闭线程");
        user.endEvent();
        user1.endEvent();
    }
}
