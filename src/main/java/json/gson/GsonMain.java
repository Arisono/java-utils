package json.gson;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import model.MotionDetectConfig1;

public class GsonMain {

    public static void main(String[] args) {

//        String json="{\"channel\":255,\"enable\":1,\"linkage\":3,\"snapInterval\":15,\"triggerInterval\":15,\"moveAlarmEnable\":0,\"pirAlarmEnable\":0,\"schedule\":[281474976710655,0,0,0,0,0,0],\"area\":[{\"x\":0,\"y\":90,\"width\":0,\"height\":0,\"sensitivity\":0,\"enable\":0}],\"sensitivity\":0,\"ret\":0}";
//
//       // MotionDetectConfig1 detectConfig = new Gson().fromJson(json, MotionDetectConfig1.class);
//        MotionDetectConfig1 detectConfig=JSON.parseObject(json,MotionDetectConfig1.class);
//        System.out.println(JSON.toJSONString(detectConfig));

        float i= 73.3f;
        i=i+43.5f+46.1f+51.2f;
        System.out.println(""+i);
    }
}
