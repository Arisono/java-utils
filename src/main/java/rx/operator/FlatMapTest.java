package rx.operator;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class FlatMapTest {

    public static void main(String[] args) {
       // mapTest();

       // flatMapTest();

       // concatMapTest();

       // onErrorResumeNextTest();

        while (true){

        }
    }

    /**
     * 操作符： onErrorResumeNext
     * 用法：https://www.jianshu.com/p/95d510c45b6b
     */
    private static void onErrorResumeNextTest() {
        Observable.<Integer>create(emitter -> {
                    emitter.onNext(1);
                    emitter.onNext(2);
                    emitter.onError(new RuntimeException());
                    emitter.onNext(3);
                    emitter.onComplete();
                })
                .onErrorResumeNext(observer -> {
                    observer.onNext(4);
                    observer.onComplete();
                })
                .subscribe(i -> System.out.println("onNext: " + i),
                        e -> System.out.println("onError: " + e),
                        () -> System.out.println("complete"));


    }

    /**
     * 操作符：concatMap
     *
     */
    private static void concatMapTest() {
        Observable.just("1","2","3","4","5").concatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String s) throws Exception {

                return Observable.just(s);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                
            }
        });
    }

    /**
     * 操作符：map
     *
     */
    private static void mapTest() {
            Observable.just("1","2","3")
                    .map(new Function<String, String>() {
                        @Override
                        public String apply(String s) throws Exception {
                            String nexStr="map:"+s;
                            return nexStr;
                        }
                    })
                    .subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    System.out.println("mapTest s="+s);
                }
            });

    }

    /**
     * 操作符：flatMap
     *
     */
    private static void flatMapTest() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                final List<String> list = new ArrayList<>();
                for (int i = 0; i < 1; i++) {
                    list.add("I am value " + integer);
                }
                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
    }



}
