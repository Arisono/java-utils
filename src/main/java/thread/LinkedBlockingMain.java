package thread;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingMain {
    /**
     * 队列
     */
    private  static  LinkedBlockingQueue<Integer> videoDataQueue;


    public static void main(String[] args) {
        videoDataQueue=new LinkedBlockingQueue<>(5000);
        WriteDataThread writeDataThread=new WriteDataThread();
        writeDataThread.start();

        ReadDateThread readDateThread=new ReadDateThread();
        readDateThread.start();

        while (true){

        }

    }

    public static  class WriteDataThread extends Thread{
        private static  Integer i=0;
        @Override
        public void run() {
            while (true){

                boolean s=videoDataQueue.offer(i);
                System.out.println("生产者增加数据 i："+i+" add:"+s+"  times:"+System.currentTimeMillis());;
                i++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public static class ReadDateThread extends Thread{
        private Integer pre=-1;
        @Override
        public void run() {
            while (true){
                Integer i=videoDataQueue.poll();
                if(i!=null){
                    if(i-pre!=1){
                        System.out.println("-----错误-------消费者取数据 i："+i);;
                    }else{
                        System.out.println("消费者取数据 i："+i);;
                    }

                    pre=i;
                }
            }
        }
    }
}
