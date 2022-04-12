package thread;

public class User {

    EventMessageRunnable eventMessageRunnable;

    public void startEvent(){
        if(eventMessageRunnable==null){
            //确保一个对象只能开启一个线程
            eventMessageRunnable=new EventMessageRunnable();
            new Thread(eventMessageRunnable).start();
        }else{

        }
    }

    public void endEvent(){
        if (eventMessageRunnable!=null) {
            System.out.println("关闭线程");
            eventMessageRunnable.stopRunnable();
        }
    }
}
