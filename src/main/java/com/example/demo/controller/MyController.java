package com.example.demo.controller;

import com.example.demo.service.MyService;
import io.github.superfive666.duosdk.params.DuoAuthenticationMode;
import io.github.superfive666.duosdk.params.request.Auth;
import io.github.superfive666.duosdk.params.request.DuoPush;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@RequiredArgsConstructor
public class MyController {
    private static final Auth auth = new Auth();
    private static final String VALUE = "Working";
    private final MyService myService;
    static {
        auth.setUsername("username");
        auth.setFactor(DuoAuthenticationMode.PUSH);
        DuoPush duoPush = new DuoPush();
        duoPush.setDevice("auto");
        duoPush.setType("Default title screen");
        LinkedHashMap<String, String> pushinfo = new LinkedHashMap<>();
        pushinfo.put("haha", "laugh is good");
        pushinfo.put("Hahaha", "笑什么");
        pushinfo.put("Hahahaha", "再笑就喝掉你");
        duoPush.setPushinfo(pushinfo);
        auth.setAdditionalParam(duoPush);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(int type) {
        if (type == 1) {
            myService.testAutoWired(auth, VALUE);
        } else if (type == 2) {
            myService.testAnnotation(auth, VALUE);
        } else {
            myService.testAnnotation2(auth, VALUE);
        }

        return ResponseEntity.ok("Success");
    }
}
