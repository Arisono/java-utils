package http;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class OkhttpMain {

    private static StringBuilder cookieStr;

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        RequestBody formBody = new FormBody.Builder()
                .add("userName", "784602719@qq.com")
                .add("passWord", "jie.13266699268")
                .build();
        final Request login = new Request.Builder()
                .url("http://label.vpssw.com/user/login")
                .method("POST",formBody)
                .build();
        client.newCall(login).enqueue(new Callback() {
           @Override
           public void onFailure(@NotNull Call call, @NotNull IOException e) {

           }

           @Override
           public void onResponse(@NotNull Call call, @NotNull Response response)  {
               Headers headers = response.headers();
               HttpUrl loginUrl = login.url();
               List<Cookie> cookies = Cookie.parseAll(loginUrl, headers);
               cookieStr = new StringBuilder();
               for (Cookie cookie : cookies) {
                   cookieStr.append(cookie.name()).append("=").append(cookie.value() + ";");
               }
               System.out.println("cookie="+String.valueOf(cookieStr));
               try {
                   final String result = response.body().string();
                   System.out.println("result="+result);
               } catch (IOException e) {
                   e.printStackTrace();
               }

           }
       });


        try {
            //延时，为了先登录，拿到cookie再请求
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Request request = new Request.Builder()
                .url("http://label.vpssw.com/standard_json/47/0")
                .method("GET", null)
                .addHeader("Cookie", String.valueOf(cookieStr))
               // .addHeader("Content-Type", "application/json;charset=UTF-8")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println("response:"+response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //http://label.vpssw.com/favorites/getFavorites/0
        RequestBody body =RequestBody.create(null,"1");
        Request request1 = new Request.Builder()
                .url("http://label.vpssw.com/favorites/getFavorites/0")
                .method("POST", body)
                .addHeader("Cookie", String.valueOf(cookieStr))
                .build();
        try {
            Response response1 = client.newCall(request1).execute();
            System.out.println("response:"+response1.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
