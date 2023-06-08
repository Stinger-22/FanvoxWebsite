package com.fanvox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendRedirect {
    @RequestMapping(value = { "/news", "/catalog", "/anime/{id}", "/anime/**", "/dubbing", "/about"})
    public String redirect() {
        return "forward:/";
    }
}
