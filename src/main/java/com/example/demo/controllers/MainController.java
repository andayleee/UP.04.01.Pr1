package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String calculate(){
        return ("calculate");
    }
    @GetMapping("/main/")
    public String homeG (Model model,
                        @RequestParam(name = "fNum", defaultValue = "1", required = false) int fNum,
                        @RequestParam(name = "sNum", defaultValue = "1", required = false) int sNum,
                        @RequestParam(name = "operation") String operation
    ) {
        model.addAttribute("res", calc(fNum,sNum,operation));
        return "home";
    }
    @PostMapping("/main/")
    public String homeP (Model model,
                        @RequestParam(name = "fNum", defaultValue = "1", required = false) int fNum,
                        @RequestParam(name = "sNum", defaultValue = "1", required = false) int sNum,
                        @RequestParam(name = "operation") String operation
    ) {
        model.addAttribute("res", calc(fNum,sNum,operation));
        return "home";
    }
    private int calc(int fNum, int sNum, String operation){
        int res;
        switch (operation){
            case  "+" -> res = fNum + sNum;
            case "-" -> res = fNum - sNum;
            case "*" -> res = fNum * sNum;
            default -> res = fNum / sNum;
        }
        return res;
    }
}
