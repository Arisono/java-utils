package utils;

public class RegularUtils {
    /**
     * qr格式1： 24位uid正则表达式（2019年，兼容捷高NVR，字母数字共24位）
     */
    public static final String reg_qr_uid_24 = "[a-zA-Z0-9]{24}";

    /**
     * 有感设备uid正则
     */
    public static final String REG_UID_FEELING_IPC = "^[0-9A-Za-z]{20}[Qq][0-9A-Za-z]+$";


    public static void main(String[] args) {
         String uid="COCMT99MYKWYPSH2ZZZZQ28I";
         if (uid.matches(reg_qr_uid_24)&&uid.matches(REG_UID_FEELING_IPC)){
             System.out.println(uid+" 低功耗uid");
         }else{
             System.out.println("不是低功耗uid");
         }
    }
}
