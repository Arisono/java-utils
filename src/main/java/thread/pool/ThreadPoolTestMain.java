package thread.pool;


import sun.rmi.runtime.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.*;

/**
 * 线程池测试
 */
public class ThreadPoolTestMain {

    /**
     * ipc应用固件版本大于等于2.0.0.0的正则【2.4.11.4_p1】(_p1表示补丁1)
     */
    public static final String reg_firmwareVer = "(\\d{2,}|[2-9])\\.\\d+\\.\\d+\\.\\d+(_[pP]\\d+)?";



    public static void main(String[] args) {
      //  getRuntimeInfo();
       // newFixedThreadPool();
       // definedExecutorService();

       // testOOMCreatThread();

//        boolean isop="1.0.0.1".matches(reg_firmwareVer);
//        System.out.println("reg_firmwareVer:"+isop);;

        System.out.println(""+getDateString("yyyy-MM-dd-HH-mm-ss",1673231021000L));

        SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Long time=new Long(1673231021*1000L);
        String d = format.format(time);
        Date date= null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Format To String(Date):"+d);
        System.out.println("Format To Date:"+date);
    }


    /**
     * 根据日期格式和time(毫秒)，返回日期/时间字符串
     *
     * @param dateFormat e.g. yyyy-MM-dd ; yyyyMMdd HH:mm:ss ; etc.
     * @param timeMillis 时间对应的毫秒数
     * @return 日期/时间的字符串
     */
    public static String getDateString(String dateFormat, long timeMillis) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            Date date = new Date(timeMillis);
            return formatter.format(date);
        } catch (Exception ex) {
          //  Log.e(TAG, "getDateString(String,long) method exception:" + ex.getMessage());
        }
        return "";
    }


    private static  void testOOMCreatThread() {
        int count = 0;
        while (true) {

            System.out.println("create thread : " + (++count));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "thread-" + count).start();
        }
    }




    /**
     * 自定义线程池
     */
    private static void definedExecutorService() {
        ExecutorService es = new ThreadPoolExecutor(
                2,
                8,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(799), // 必须指明，默认最大为Integer.MAX_VALUE
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 1; i <=800; i++) {
                //TimeUnit.SECONDS.sleep(1);
                es.execute(()->{
                    getRuntimeInfo();
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                    String s="jfkadskfadkfakdsfkds uewqrdkds dafdsaskjckjvas"+"5d6fas56da5"+"59a6f2626feqw"+"87d845sd4fa";
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } finally {
            es.shutdown();
        }
    }

    /**
     *  1KB等于1024个字节。 1MB等于1024KB。 1GB等于1024MB
     */
    public static synchronized void getRuntimeInfo(){
        // 得到JVM中的空闲内存量（单位是字节）
        System.out.println("空闲内存量:"+Runtime.getRuntime().freeMemory());
        // 的JVM内存总量（单位是字节）
        System.out.println("总内存量："+Runtime.getRuntime().totalMemory());
        // JVM试图使用额最大内存量（单位是字节）
        System.out.println("最大可申请内存量:"+Runtime.getRuntime().maxMemory());
        // 可用处理器的数目
        System.out.println("处理器数目："+Runtime.getRuntime().availableProcessors());
        System.out.println("----------------------------------------------------------");
    }

    public static void newFixedThreadPool(){
        ExecutorService es=  Executors.newCachedThreadPool();//线程会闪退
      //  es=Executors.newSingleThreadExecutor();
//        try {
            for (int i = 1; i <=800; i++) {
                System.out.println("线程提交 i="+i);


                es.execute(()->{
                    getRuntimeInfo();
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                    String s="jfkadskfadkfakdsfkds uewqrdkds dafdsaskjckjvas"+"5d6fas56da5"+"59a6f2626feqw"+"87d845sd4fa";
                    try {
                        Thread.sleep(0000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        getRuntimeInfo();
//                        System.out.println(Thread.currentThread().getName()+"\t 办理业务");
//                        try {
//                            Thread.sleep(35000);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }).start();

            }
//        } catch (Exception e ){
//            e.printStackTrace();
//        }finally {
//            es.shutdown();
//        }
    }

}
