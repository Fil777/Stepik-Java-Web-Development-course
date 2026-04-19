package ru.ksergey.contactApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ksergey.contactApp.common.util.ServerResponseHelper;
import ru.ksergey.contactApp.model.ServerResponse;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/foo1")
    public ResponseEntity<ServerResponse<String>> foo1() {
        return ServerResponseHelper.ok("foo1");
    }

    @GetMapping("/foo2")
    public ResponseEntity<ServerResponse<String>> foo2() {
        return ServerResponseHelper.notFound("NOT_FOUND");
    }
}
