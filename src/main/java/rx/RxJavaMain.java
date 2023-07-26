package rx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class RxJavaMain {

    public static void main(String[] args) {
        //queryStudent();

        saveSharePreferences();
    }

    private static void saveSharePreferences() {
        DBRxManager.getInstance().rxWrapSyncForSharePreferences(new Student()).subscribe(new Consumer<Boolean>() {
            public void accept(Boolean aBoolean) throws Exception {
                System.out.println("保存sp结果："+aBoolean+" id="+Thread.currentThread().getId());
            }
        });

        System.out.println("---------同步或异步--------------");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main  end");
    }





    private static void queryStudent() {
        final Thread currentThread=new Thread();
        System.out.println("id="+currentThread.getId());
        DBRxManager.getInstance().queryStudentAll()
                .observeOn(Schedulers.from(Executors.newSingleThreadExecutor(new ThreadFactory() {
                            public Thread newThread(@NotNull Runnable r) {
                                Thread mainThread=new Thread(r);
                                System.out.println(" id="+mainThread.getId());
                                return mainThread;
                            }
                        })))
                .subscribe(
                new Observer<List<Student>>() {
                    public void onSubscribe(@NotNull Disposable disposable) {
                        System.out.println("onSubscribe  id="+Thread.currentThread().getId());
                    }

                    public void onNext(@NotNull List<Student> students) {
                        System.out.println("students=" +JSON.toJSON(students)+" thread id="+Thread.currentThread().getId());
                    }

                    public void onError(@NotNull Throwable throwable) {
                        System.out.println("onError");
                    }

                    public void onComplete() {
                        System.out.println("onComplete id="+Thread.currentThread().getId());
                    }
                }
        );

        System.out.println("---------同步或异步--------------");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        while (true){
//           // System.out.println("-------------s-----------");
//            if(isEnd){
//                System.out.println("break");
//                break;
//            }
//            //System.out.println("------------------------");
//        }

        System.out.println("main  end");
    }
}
