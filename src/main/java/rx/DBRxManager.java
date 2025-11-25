package rx;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


/**
 *
 */
public class DBRxManager implements IDBRxManager{

    private volatile static DBRxManager dbRxManager;

    public static DBRxManager getInstance(){
        if (dbRxManager == null) {
            synchronized (DBRxManager.class) {
                if (dbRxManager == null) {
                    dbRxManager = new DBRxManager();
                }
            }
        }
        return dbRxManager;
    }

    /**
     * 获取数据库学生信息
     * @return
     */
    public Observable<List<Student>> queryStudentAll() {
        return Observable.create(new ObservableOnSubscribe<List<Student>>() {
            public void subscribe(@NotNull ObservableEmitter<List<Student>> e) throws Exception {
                 System.out.println("run task current thread="+Thread.currentThread().getId());
                 List<Student> students=new ArrayList<Student>();
                 Thread.sleep(3000);

                 e.onNext(students);
                 e.onComplete();
                System.out.println("run task  end current thread="+Thread.currentThread().getId());

            }
        })
//                .observeOn(Schedulers.single())
                .subscribeOn(Schedulers.io())
                ;
    }


    /**
     * 把student写入sp缓存
     * @param student
     * @return
     */
    public Observable<Boolean> rxWrapSyncForSharePreferences(final Student student) {
        return Observable.fromCallable(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                System.out.println("开始存入sp缓存   线程id:"+Thread.currentThread().getId());
                Thread.sleep(3000);
                return true;
            }
        }).subscribeOn(Schedulers.io());
    }


}
