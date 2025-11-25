package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimeTask {

    public static void main(String[] args) {
        // 启动异步任务
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                // 模拟耗时任务
                Thread.sleep(8000);
                return "任务完成";
            } catch (InterruptedException e) {
                return "任务被中断";
            }
        });

        try {
            // 等待任务执行结果，最多等待5秒 block
            String result = future.get(5, TimeUnit.SECONDS);
            System.out.println("result:"+result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("任务执行超时或出现异常：" + e.getMessage());
        }

    }
}
