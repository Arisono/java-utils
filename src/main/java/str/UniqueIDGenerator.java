package str;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIDGenerator {
    // 使用 AtomicInteger 来保证线程安全
    private static final AtomicInteger counter = new AtomicInteger(0);

    // 获取自增长的唯一数字
    public static int getNextId() {
        return counter.incrementAndGet();
    }

    // 将计数器归零
    public static void resetCounter() {
        counter.set(0);
    }

    public static void main(String[] args) {
        // 测试生成的自增长数字
        System.out.println(getNextId()); // 1
        System.out.println(getNextId()); // 2
        System.out.println(getNextId()); // 3

        // 归零
        resetCounter();

        // 重新开始自增长
        System.out.println(getNextId()); // 1
        System.out.println(getNextId()); // 2
    }
}
