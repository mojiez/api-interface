package com.yichen.apiinterface;

import com.yichen.apiinterface.client.ApiClient;
import com.yichen.apiinterface.model.User;

import javax.servlet.http.HttpServletRequest;

public class Main {
    public static void main(String[] args) {
        String accessKey = "kj";
        String secretKey = "abcdefgh";
        ApiClient apiClient = new ApiClient(accessKey, secretKey);
        String result1 = apiClient.GetNameByGet("周");
        String result2 = apiClient.GetNameByPost("王");
        User user = new User();
        user.setName("陶林");
        String result3 = apiClient.GetNameByPostBody(user);

    }
}
