package com.captainyun7.ch2codeyourself._01_basic_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class BasicController {

    @GetMapping("/basic/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping("/basic/users/{userId}")
    @ResponseBody
    public String users(@PathVariable String userId) {
        return userId;
    }

    @ResponseBody
    @GetMapping("/basic/params")
    public String params(@RequestParam String name, @RequestParam Integer age) {
        return "Name: " + name + ", Age: " + age;
    }

    @ResponseBody
    @GetMapping("/basic/filter")
    public String filter(@RequestParam Map<String, String> params) {
        return "전체 파라미터: " + params.toString();
    }

    @PostMapping("basic/users")
    @ResponseBody
    public String post() {
        return "사용자 생성 완료!!!";
    }

    @PutMapping("basic/users")
    @ResponseBody
    public String put() {
        return "사용자 생성 완료!!!";
    }

}
