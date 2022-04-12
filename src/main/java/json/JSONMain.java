package json;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONObject;

import java.util.HashMap;

public class JSONMain {

    public static void main(String[] args) {
        //test01();

    }

    private static void test01() {
        int i= (int) 634.67;
        double p=634.66;
        System.out.println(i);
        if(i>p){
            System.out.println("i>p=true");
        }else{
            System.out.println("i>p=false");
        }


        HashMap<String, Object> rtmpMap = new HashMap<String, Object>();
        rtmpMap.put("isEnable", 1);
        rtmpMap.put("iProperty", 5);
        rtmpMap.put("isEnableAudio", 1);
        rtmpMap.put("szStreamId", "");
        rtmpMap.put("isMainStream", 1);
        rtmpMap.put("szPublishToken", "1");
        rtmpMap.put("szGuid", "1");
        rtmpMap.put("szDevId", "");
        rtmpMap.put("szAccessToken", "");
        rtmpMap.put("szPortal", "https://dev-smartbuildingcs.ivyiot.cn:443");

        System.out.println(JSON.toJSONString(rtmpMap));

        String data = new JSONObject(rtmpMap).toString();

        System.out.println(data);


        String d = "{\"szDevId\":\"\",\"isMainStream\":1,\"szStreamId\":\"\",\"szGuid\":\"1\",\"szAccessToken\":\"\",\"iProperty\":5,\"szPortal\":\"https:\\/\\/dev-smartbuildingcs.ivyiot.cn:443\",\"szPublishToken\":\"1\",\"isEnableAudio\":1,\"isEnable\":1}";

        System.out.println(d);
        String str1 = StringEscapeUtils.unescapeJava(d);
        System.out.println(str1);

        String str2 = d.replaceAll("\\\\", "");
        System.out.println(str2);
    }
}
