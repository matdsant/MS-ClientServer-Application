package com.application.MsClient.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients/")
public class ClientsController {

    @GetMapping
    public String status(){
        return "ok";
    }
}
