package com.yichen.apiinterface;


import com.yichen.chenapiclientsdk.client.ApiClient;
import com.yichen.chenapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {
    // 测试SDK工具类 生成的client
    @Resource
    private ApiClient apiClient;
    @Test
    void contextLoads() {
    }
    @Test
    void testApiClient() {
        String result1 = apiClient.GetNameByGet("zhoujielun1");
        String result2 = apiClient.GetNameByPost("zhoujielun2");

        User user = new User();
        user.setName("zhoujielun3");
        String result3 = apiClient.GetNameByPostBody(user);
    }
}
