package json;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JSONMain {

    public static void main(String[] args) {
        test02();

    }


    /**
     * 
     */
    private static void test02() {

        JSONObject paramObject = new JSONObject();
        paramObject.put("test1", "test1");
        paramObject.put("test2", "test2");
        paramObject.put("test3", "test3");

        Map<String, Object> objectMap = new HashMap<String, Object>();
        objectMap.put("map1", "map1");
        objectMap.put("map2", "map2");
        objectMap.put("map3", "map3");

        Map<String, Object> body_param = new HashMap<String, Object>();

        body_param.put("param", paramObject);
        body_param.put("param2", objectMap);
        body_param.put("param1", "param1");

        System.out.println("org json:" + JSONObject.valueToString(body_param));
        System.out.println("gson:" + new Gson().toJson(body_param));
    }


    private static void test01() {
        int i = (int) 634.67;
        double p = 634.66;
        System.out.println(i);
        if (i > p) {
            System.out.println("i>p=true");
        } else {
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
