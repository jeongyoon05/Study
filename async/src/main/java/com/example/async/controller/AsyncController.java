package com.example.async.controller;

import com.example.async.service.AsyncService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AsyncController {

    Logger logger = LoggerFactory.getLogger(AsyncController.class);

    private final AsyncService asyncService;

    @GetMapping("/async")
    public String goAsync() {
        asyncService.onAsync();
        String str = "Hello Spring Boot Async";
        logger.info(str);
        logger.info("===================================");
        return str;
    }

    @GetMapping("/sync")
    public String goSync() {
        asyncService.onSync();
        String str = "Hello Spring Boot Sync";
        logger.info(str);
        logger.info("==================================");
        return str;
    }
}
