package com.yichen.apiinterface.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.yichen.apiinterface.Utils.SignUtils;
import com.yichen.apiinterface.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public class ApiClient {
    private String accessKey;
    private String secretKey;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

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

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey",accessKey);

//        这个东西一定不能发给后端!!
//        hashMap.put("secretKey",secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body",body);
        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        // 生成签名算法
        hashMap.put("sign", SignUtils.getSign(body, secretKey));
        return hashMap;
    }

    public String GetNameByPostBody(@RequestBody User user) {
        String userJson = JSONUtil.toJsonStr(user);

        // 发请求的时候，要把参数放到请求头里
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/post2/")
                .body(userJson)
                .addHeaders(getHeaderMap("bodylala"))
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
}
