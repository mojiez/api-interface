package com.yichen.apiinterface.client;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.yichen.apiinterface.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

public class ApiClient {
    public String GetNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result1= HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result1);
        return result1;
    }

    public String GetNameByPost(@RequestParam String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result1= HttpUtil.post("http://localhost:8123/api/name/post1/", paramMap);
        System.out.println(result1);
        return result1;
    }

    public String GetNameByPostBody(@RequestBody User user) {
        String userJson = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/post2/")
                .body(userJson)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
}
