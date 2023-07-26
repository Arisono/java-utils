package utils;

/**
 * 日志工具类
 */
public class LogUtils {

    /**
     * 获取当前方法调用的类名+方法+代码行
     * @param currClassName
     * @return
     */
    public static  String  getParentClassStackTrace(String currClassName){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement log = stackTrace[2];
        String tag = null;
        int parent=0;
        for (int i = 1; i < stackTrace.length; i++) {
            StackTraceElement e = stackTrace[i];
            if(e.getClassName().equals(currClassName)){
                parent=i;
                break;
            }
        }
        StackTraceElement parentStack = stackTrace[parent+1];
        tag = "《"+parentStack.getClassName() + "》.《" + parentStack.getMethodName()+"》.《"+parentStack.getLineNumber()+"》";
        if (tag == null) {
            tag = log.getClassName() + "." + log.getMethodName()+"."+log.getFileName()+"."+log.getLineNumber();

        }
        return tag;
    }
}
