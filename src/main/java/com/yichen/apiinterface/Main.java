package com.yichen.apiinterface;

import com.yichen.apiinterface.client.ApiClient;
import com.yichen.apiinterface.model.User;

public class Main {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        String result1 = apiClient.GetNameByGet("周");
        String result2 = apiClient.GetNameByPost("王");
        User user = new User();
        user.setName("陶林");
        String result3 = apiClient.GetNameByPostBody(user);

    }
}
