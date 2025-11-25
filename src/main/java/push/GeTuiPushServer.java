package push;

import com.alibaba.fastjson.JSON;
import com.getui.push.v2.sdk.ApiHelper;
import com.getui.push.v2.sdk.GtApiConfiguration;
import com.getui.push.v2.sdk.api.PushApi;
import com.getui.push.v2.sdk.common.ApiResult;
import com.getui.push.v2.sdk.dto.req.Audience;
import com.getui.push.v2.sdk.dto.req.Settings;
import com.getui.push.v2.sdk.dto.req.Strategy;
import com.getui.push.v2.sdk.dto.req.message.PushChannel;
import com.getui.push.v2.sdk.dto.req.message.PushDTO;
import com.getui.push.v2.sdk.dto.req.message.PushMessage;
import com.getui.push.v2.sdk.dto.req.message.android.AndroidDTO;
import com.getui.push.v2.sdk.dto.req.message.android.GTNotification;
import com.getui.push.v2.sdk.dto.req.message.android.ThirdNotification;
import com.getui.push.v2.sdk.dto.req.message.android.Ups;
import com.getui.push.v2.sdk.dto.req.message.harmony.HarmonyDTO;
import com.getui.push.v2.sdk.dto.req.message.harmony.HarmonyNotification;
import com.getui.push.v2.sdk.dto.req.message.ios.Alert;
import com.getui.push.v2.sdk.dto.req.message.ios.Aps;
import com.getui.push.v2.sdk.dto.req.message.ios.IosDTO;
import utils.DateUtils;

import java.util.HashMap;
import java.util.Map;

public class GeTuiPushServer {

    public static PushApi pushApi;

    public static void main(String[] args) {
        GtApiConfiguration apiConfiguration = new GtApiConfiguration();
        //填写应用配置
        apiConfiguration.setAppId("Cb0YfR99uh9DexOeBauh43");
        apiConfiguration.setAppKey("IL4slJ050P7bEVIj9SN8I1");
        apiConfiguration.setMasterSecret("Nb3dNUq2dw6Qm5xbqXSti7");
        // 接口调用前缀，请查看文档: 接口调用规范 -> 接口前缀
        apiConfiguration.setDomain("https://restapi.getui.com/v2/");
        // 实例化ApiHelper对象，用于创建接口对象
        ApiHelper apiHelper = ApiHelper.build(apiConfiguration);
        // 创建对象，建议复用。目前有PushApi、StatisticApi、UserApi
        pushApi = apiHelper.creatApi(PushApi.class);

        for (int i = 1; i <=1 ; i++) {
            try {
                testPush(i);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }


    }

    public static  void testPush(int i) {
        String time=DateUtils.getDateStr(System.currentTimeMillis());
        //根据cid进行单推
        PushDTO<Audience> pushDTO = new PushDTO<Audience>();
        // 设置推送参数
        pushDTO.setRequestId(System.currentTimeMillis() + "");
        /**** 设置个推通道参数 *****/
        PushMessage pushMessage = new PushMessage();
        pushDTO.setPushMessage(pushMessage);

        Settings settings=new Settings();
        Strategy strategy=new Strategy();
        strategy.put("default",1);
//        settings.setTtl(0);
        settings.setStrategy(strategy);
        pushDTO.setSettings(settings);

        GTNotification notification = new GTNotification();
       // pushMessage.setNotification(notification);

        notification.setTitle("门铃侦测事件 ["+i+"] 条(在线消息)");
//        notification.setNotifyId();
        notification.setBody("您的设备客厅1检测到门铃呼叫 "+time);
//        String json="{\n" +
//                "    \"push_title\": \"运动侦测报警(在线)\"[\n"+i+"]条" +
//                "    \"push_body\": \"{\\\"media_info\\\":{\\\"AIIoTID\\\":\\\"0\\\",\\\"AIIoTType\\\":\\\"1000\\\",\\\"AIIotName\\\":\\\"\\\",\\\"DID\\\":\\\"12000101411e95a9\\\",\\\"DeviceName\\\":\\\"办公室\\\",\\\"EventID\\\":\\\"100000\\\",\\\"PictureURL\\\":\\\"******************************************************************************************************************************************* 14:43:24\\\",\\\"URL\\\":\\\"\\\",\\\"URLMode\\\":\\\"\\\",\\\"Version\\\":\\\"2\\\",\\\"body\\\":\\\"您的设备“办公室1”画面发生了变化，请及时查看！\\\",\\\"notice\\\":4,\\\"title\\\":\\\"运动侦测报警(在线)\\\"}}\",\n" +
//                "    \"is_show_notify\": \"1\",\n" +
//                "    \"ext\": \"\"\n" +
//                "}";
        String json="{\n" +
                "    \"push_title\": \"运动侦测报警(在线)\"," +
                "    \"push_body\": \"{\\\"media_info\\\":{\\\"AIIoTID\\\":\\\"0\\\",\\\"AIIoTType\\\":\\\"1000\\\",\\\"AIIotName\\\":\\\"\\\",\\\"DID\\\":\\\"12000101411e95a9\\\",\\\"DeviceName\\\":\\\"办公室\\\",\\\"EventID\\\":\\\"100000\\\",\\\"PictureURL\\\":\\\"******************************************************************************************************************************************* 14:43:24\\\",\\\"URL\\\":\\\"\\\",\\\"URLMode\\\":\\\"\\\",\\\"Version\\\":\\\"2\\\",\\\"body\\\":\\\"您的设备“办公室1”画面发生了变化，请及时查看！\\\",\\\"notice\\\":4,\\\"title\\\":\\\"运动侦测报警(在线)\\\"}}\",\n" +
                "    \"is_show_notify\": \"1\",\n" +
                "    \"ext\": \"\"\n" +
                "}";


          notification.setClickType("intent");
//        notification.setClickType("payload_custom");
//        notification.setPayload(json);
        notification.setIntent("intent://com.vatilon.wananpro/thirdpush#Intent;scheme=getui;launchFlags=0x10008000;package=com.vatilon.wananpro;component=com.vatilon.wananpro/com.vatilon.wananpro.MessageActivity;S.deviceId=12000101411e95a9;end");


        System.out.println(" json:"+json);//透传
      // pushMessage.setTransmission(json);

         pushMessage.setNotification(notification);
          notification.setUrl("https://www.getui.com");
        /**** 设置个推通道参数，更多参数请查看文档或对象源码 *****/

        /**** 设置厂商相关参数 ****/
        PushChannel pushChannel = new PushChannel();
        pushDTO.setPushChannel(pushChannel);
        /*配置安卓厂商参数*/
        AndroidDTO androidDTO = new AndroidDTO();
        pushChannel.setAndroid(androidDTO);
        Ups ups = new Ups();
        androidDTO.setUps(ups);
        ThirdNotification thirdNotification = new ThirdNotification();


        //ups.setTransmission("测试透传消息");


        thirdNotification.setTitle("门铃侦测事件 ["+i+"] 条-(离线消息)");
        thirdNotification.setBody("您的设备客厅1检测到门铃 "+time);
       // thirdNotification.setClickType("startapp");
        thirdNotification.setClickType("intent");
        //com.vatilon.wananpro.MessageActivity
        //thirdNotification.setIntent("intent://com.vatilon.wananpro/thirdpush#Intent;scheme=getui;launchFlags=0x14000000;package=com.vatilon.wananpro;component=com.vatilon.wananpro/.MessageActivity;S.deviceId=12000101411e95a9;end");
        thirdNotification.setIntent("intent://com.vatilon.wananpro/thirdpush#Intent;scheme=getui;launchFlags=0x14000000;package=com.vatilon.wananpro;component=com.vatilon.wananpro/com.vatilon.wananpro.MessageActivity;S.deviceId=12000101411e95a9;end");
       // thirdNotification.setUrl("https://www.getui.com");


        ups.setNotification(thirdNotification);

        Map<String, Map<String, Object>> options=new HashMap<>();
        Map<String, Object> categoryMap=new HashMap<>();

         //VIVO
        categoryMap.put("/category","DEVICE_REMINDER");
        options.put("VV",categoryMap);


//        "XM": {
//            "/extra.channel_id": "Default"
//        }

        //华为
        categoryMap.put("/message/android/category","DEVICE_REMINDER");
        options.put("HW",categoryMap);

//        "OP": {
//            "/channel_id": "Default"
//        },

         // 小米
//        categoryMap.put("/extra.channel_id","126084");
//        options.put("XM",categoryMap);

         //oppo
//        categoryMap.put("/channel_id","com.vatilon.wananpro_alarm_notify_channel_id");
//        options.put("OP",categoryMap);

//        "HO":{
//            "/android/notification/importance":"LOW"
//        }

        //荣耀
//        categoryMap.put("/android/notification/importance","NORMAL");
//        options.put("OP",categoryMap);

        Map<String, Object> fcmMap=new HashMap<>();
        fcmMap.put("big_text","这是一条来自fcm推送的消息");
        options.put("FCM",fcmMap);

        ups.setOptions(options);



        // 两条消息的notify_id相同，新的消息会覆盖老的消息，取值范围：0-2147483647
        // thirdNotification.setNotifyId("11177");
        /*配置安卓厂商参数结束，更多参数请查看文档或对象源码*/

        /*设置ios厂商参数*/
        IosDTO iosDTO = new IosDTO();
       // pushChannel.setIos(iosDTO);
        // 相同的collapseId会覆盖之前的消息
        iosDTO.setApnsCollapseId("xxx");
        Aps aps = new Aps();
        iosDTO.setAps(aps);
        Alert alert = new Alert();
        aps.setAlert(alert);
        alert.setTitle("ios title");
        alert.setBody("ios body");
        /*设置ios厂商参数结束，更多参数请查看文档或对象源码*/

        /*配置鸿蒙厂商参数*/
        HarmonyDTO harmonyDTO = new HarmonyDTO();
        //pushChannel.setHarmony(harmonyDTO);
        HarmonyNotification harmonyNotification = new HarmonyNotification();
        harmonyDTO.setNotification(harmonyNotification);
        harmonyNotification.setTitle("鸿蒙厂商title");
        harmonyNotification.setBody("鸿蒙厂商body");
        harmonyNotification.setCategory("MARKETING");
        harmonyNotification.setClickType("want");
        harmonyNotification.setWant("{\"deviceId\":\"\",\"bundleName\":\"com.getui.push\",\"abilityName\":\"TestAbility\",\"uri\":\"https://www.test.com:8080/push/test\",\"action\":\"com.test.action\",\"parameters\":{\"name\":\"Getui\",\"age\":12}}");
        /*配置鸿蒙厂商参数结束，更多参数请查看文档或对象源码*/

        /*设置接收人信息*/
        Audience audience = new Audience();
        pushDTO.setAudience(audience);

//        audience.addCid("0d3b49ceaa51be21e531df98143a18f8");//华为V10

        audience.addCid("57e3ad8aa5f34dc1bf9871ab90fde3d2");//华为V10
        //
        /*设置接收人信息结束*/
        /**** 设置厂商相关参数，更多参数请查看文档或对象源码 ****/


        System.out.println("pushDTO:"+JSON.toJSON(pushDTO)+" 推送时间："+time);

        // 进行cid单推
        ApiResult<Map<String, Map<String, String>>> apiResult = pushApi.pushToSingleByCid(pushDTO);

        if (apiResult.isSuccess()) {
            // success
            System.out.println(apiResult.getData()+" 推送时间："+ DateUtils.getDateStr(System.currentTimeMillis()));
        } else {
            // failed
            System.out.println("code:" + apiResult.getCode() + ", msg: " + apiResult.getMsg());
        }
    }
}
