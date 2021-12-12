package com.example.stocktest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class StockInfoController {
    @ResponseBody
    @GetMapping("/hello")
    public String getStockInfo(String name) {
        log.info(">>>>> hello name: {}", name);

        return "Hello world " + name;
    }

    @GetMapping("/helloPage")
    public String getStockHelloPage(Model model, String name) {
        log.info(">>>>> helloPage name: {}", name);

        model.addAttribute("name", name);

        return "Hello";
    }
}

