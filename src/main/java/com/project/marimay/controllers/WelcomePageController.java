package com.project.marimay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomePageController {

    @RequestMapping("/welcomePage")
    public String welcomePage(){
        return "welcomePage";
    }
}
