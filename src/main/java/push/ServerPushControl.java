package push;

import com.mixpush.sender.*;

public class ServerPushControl {

    public static void main(String[] args) {
        MixPushSender sender = new MixPushSender.Builder()
                .packageName("com.vatilon.wananpro")
                .mi("nyNK2GZInZnJ8CaZXOYz0A==",false)
//                .meizu("<appId>", "<appSecretKey>")
//                .huawei("<appId>", "<appSecretKey>")
//                .oppo("<appKey>", "<masterSecret>")
                .vivo("105794831", "8208f3784682ffe0d6c15be01e2452d5", "c5e83f27-1071-4c26-82b8-cdede2fb499e")
//                .miAPNs("<appSecretKey>")
                .test(true)
                .build();
        MixPushMessageConfig activitiesMessageConfig = new MixPushMessageConfig.Builder()
                // OPPO 必须在“通道配置 → 新建通道”模块中登记通道，再在发送消息时选择
                .oppoPushChannelId("activities")
                .vivoSystemMessage(true)
                .build();
        //intent://com.vatilon.wananpro/thirdpush#Intent;scheme=agoo;launchFlags=0x10000000;component=com.vatilon.wananpro/com.aliyun.iot.ilop.page.message.MessageActivity;end
        MixPushMessage message = new MixPushMessage.Builder()
                .title("移动侦测事件")
                .description("您的设备办公室检测到移动")
//                .payload("{\"url\":\"\"}")
                .payload("intent://com.vatilon.wananpro/thirdpush#Intent;scheme=agoo;launchFlags=0x10000000;component=com.vatilon.wananpro/com.aliyun.iot.ilop.page.message.MessageActivity;S.iotId=xadXwd9LKcwWjaK9AUFx000000;end")
                .config(activitiesMessageConfig)
                .build();

        MixPushTarget target = MixPushTarget.single("vivo","v2-CRjugGOOrfI07zv5_EeUs27yFamXn0_LPHOVwIhLgLUzaDZmAvAh3gGD");
        MixPushResult result= sender.sendMessage(message,target);
        System.out.println("发送成功result= "+result.toJSON());
    }
}
