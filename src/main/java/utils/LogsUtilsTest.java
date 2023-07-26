package utils;

/**
 * 日之类测试方法
 */
public class LogsUtilsTest {

    public static void main(String[] args) {
        parentMethod01();
        parentMethod03();
        parentMethod05();
    }
    private static void parentMethod01(){
        childMethod();
    }

    private static void parentMethod02(){
        childMethod();
    }
    private static void parentMethod03(){
        childMethod();
    }
    private static void parentMethod04(){
        childMethod();
    }
    private static void parentMethod05(){
        childMethod();
    }
    private static  void childMethod(){
        System.out.println("childMethod StackTrace:"+LogUtils.getParentClassStackTrace(LogsUtilsTest.class.getName()));
    }
}
