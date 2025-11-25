package thread.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularUtils {
    /**
     * qr格式1： 24位uid正则表达式（2019年，兼容捷高NVR，字母数字共24位）
     */
    public static final String reg_qr_uid_24 = "[a-zA-Z0-9]{24}";

    /**
     * 有感设备uid正则
     */
    public static final String REG_UID_FEELING_IPC = "^[0-9A-Za-z]{20}[Qq][0-9A-Za-z]+$";

    public static final String reg_username="^[a-z0-9_-]{3,15}$";


    /**
     * 邮箱正则（有缺陷）
     */
    public static final String reg_email="[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+";

    /**
     * 邮箱正则2
     */
    public static final String reg_email2="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";


    public static final String reg_china_lan = "[\\w!#$%&amp;'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&amp;'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";




    /**
     * 云平台账户的密码正则【长度6-18 允许特殊字符，不允许中文字符，数字加字母显示一般，数字加字母加特殊字符显示安全】
     * 提示语：密码应为6〜18个数字，字母和符号组合
     * [0-9a-zA-Z~!@$#%^*()_+={}:"|<>?`\-;'\,./]{6,18}
     *
     */
    public static final String reg_cloud_password = "^(?:(?=.*[A-Za-z])(?=.*\\d)|(?=.*[A-Za-z])(?=.*[\\W_])|(?=.*\\d)(?=.*[\\W_]))[A-Za-z\\d\\W_]{6,50}$";


    public static void main(String[] args) {
       String strPwd="daffadfafd5";

        System.out.println(!strPwd.matches(RegularUtils.reg_cloud_password));


//        String username="gitbaike@gmail.com.";
//        System.out.println(username.matches(reg_email2));
//
//        String wifi_pwd="123456:";
//        String s=wifi_pwd.replaceAll(":","::");
//        System.out.println(""+wifi_pwd+" s="+s);


//        String str = "192.168.12.245";
//        String pattern = "^(\\d{1,3}\\.){3}\\d{1,3}$";
//
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(str);
//        System.out.println(m.matches());
//
//        System.out.println(pattern.matches(str));

        //四舍五入



//        String email="中国@163.com";
//        System.out.println("是否包含中文："+email.matches( reg_china_lan));
//
//        Pattern r = Pattern.compile(reg_china_lan);
//        Matcher m = r.matcher(email);
//        System.out.println("是否包含中文："+m.matches());




        //时间戳转时间
//        long t=41499;
//        System.out.println( getVideoDur(t));
//
//        float t1=Math.round((t/1000f))*1000;
//        System.out.println("t1:"+t1);
//        Date date = new Date();
//        date.setTime(Long.valueOf(String.valueOf(t1).replace(".0","")));
//        //时间格式化
//        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
//        String fmDate = sdf.format(date);
//        System.out.println(fmDate);
    }

    private static void testUid() {
        String uid="COCMT99MYKWYPSH2ZZZZQ28I";
        if (uid.matches(reg_qr_uid_24)&&uid.matches(REG_UID_FEELING_IPC)){
            System.out.println(uid+" 低功耗uid");
        }else{
            System.out.println("不是低功耗uid");
        }
    }


    /**
     * 返回时长：
     * 00:00
     * @param time 毫秒
     * @return
     */
    public static String getVideoDur(long time){
        long nowTime=System.currentTimeMillis();
        float s=  time/1000f;
        float m= time/1000f/60f;
        String minute="";
        String sec="";
        s=Math.round(s);
        m=Math.round(m);
        if(m>=10){
            minute=String.valueOf(m).replace(".0","");
        }else{
            minute="0"+String.valueOf(m).replace(".0","");
        }
        if(s>=10){
            sec=String.valueOf(s).replace(".0","");
        }else{
            sec="0"+String.valueOf(s).replace(".0","");
        }
        System.out.println("耗时："+(System.currentTimeMillis()-nowTime));
        return minute+":"+sec;
    }


}
