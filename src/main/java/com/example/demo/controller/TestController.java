package com.example.demo.controller;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;
import com.example.demo.entity.Request;
import com.example.demo.entity.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {

    @GetMapping("/test")
    public Response<String> test(@RequestBody(required = false) Request<String> request) {
        Response<String> response = new Response<>();
        response.setMsg("test");
        Optional.ofNullable(request)
                .flatMap(req -> Optional.ofNullable(req.getOperate()))
                .map(opt -> {
                            if (StrUtil.equalsAny(opt, "time", "date", "now")) {
                                response.setBody(LocalDateTimeUtil.now().toString());
                            } else {
                                response.setBody("unleash right opt");
                            }
                            return opt;
                        }
                )
                .orElseGet(() -> {
                    response.setCode(400);
                    response.setBody("wrong state");
                    return null;
                });
        return response;
    }
}
