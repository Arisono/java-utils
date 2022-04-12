package json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import model.User;

public class FastJsonMain {

    public static void main(String[] args) {
        User user=new User();
        user.setAge("12");
        user.setName("name");
        user.setPhone("1355656586");

        String userStr=  JSON.toJSONString(user);
        System.out.println(userStr);

        User user1=JSON.parseObject(userStr,User.class);

        System.out.println(JSON.toJSONString(user1));
        System.out.println(user1.getSex());
        System.out.println(user1.getNum());
    }

    /**
     * 判断JSON是否包含某个key
     * @param tag
     */
    public static void isContainskey(String tag) {
        String json="{\"name\":\"123456\",\"age\":\"sex\"}";
        JSONObject jsonObject= JSON.parseObject(json);
        if(json.contains("name")){
            System.out.println(jsonObject.getString("name"));
        }
        if(json.contains("sex")){
            System.out.println(jsonObject.getString("sex"));
        }else{
            System.out.println("不存在字段sex");
        }

        if (jsonObject.containsKey("sex")){
            System.out.println(jsonObject.getString("sex"));
        }else{
            System.out.println("不存在字段sex");
        }
    }
}
