package com.yichen.apiinterface.controller;

import com.yichen.apiinterface.Utils.SignUtils;
import com.yichen.apiinterface.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 名称API
 *
 * @author zhangshan
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/get")
    public String GetNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("xiaozhang"));
        return "GET 你的名字是:"+name;
    }

    @PostMapping("/post1")
    public String GetNameByPost(@RequestParam String name) {
        return "POST1 你的名字是:"+name;
    }
    @PostMapping("/post2")
    public String GetNameByPostBody(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String body = request.getHeader("body");
        String sign = request.getHeader("sign");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
//        if (!accessKey.equals("kj") || !secretKey.equals("abcdefgh")) {
//            throw new RuntimeException("无权限");
//        }
        // todo 实际情况应该是去数据库中查 是否已经分配给用户
        // 使用dubbo进行调用数据库的操作
        if (!accessKey.equals("kj")) throw new RuntimeException("无权限");
        // todo 这里的随机数应该是去数据库里面查的（主要是防重放）服务端要保存用过的随机数 这个随机数是新的 就能用？？
        // todo 时间和当前时间不能超过5分钟

        // 拼sign getSign方法 公用
        String serverSign = SignUtils.getSign(body, "abcdefgh");
        if (!serverSign.equals(sign)) throw new RuntimeException("无权限 签名错误");
        String result = "POST2 your name:"+ user.getName();
        // 调用成功后 次数加1
        // 1. 之前没调用，创建 2.之前调用了，调用次数加1

        return result;
    }
}
