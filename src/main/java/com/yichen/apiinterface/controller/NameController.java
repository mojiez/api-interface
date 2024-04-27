package com.yichen.apiinterface.controller;

import com.yichen.apiinterface.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * 名称API
 *
 * @author zhangshan
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/")
    public String GetNameByGet(String name) {
        return "GET 你的名字是:"+name;
    }

    @PostMapping("/post1")
    public String GetNameByPost(@RequestParam String name) {
        return "POST1 你的名字是:"+name;
    }
    @PostMapping("/post2")
    public String GetNameByPostBody(@RequestBody User user) {
        return "POST2 你的名字是:"+ user.getName();
    }
}
