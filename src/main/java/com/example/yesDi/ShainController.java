package com.example.yesDi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

public class ShainController {

    @RequestMapping("/input")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/output")
    public String result(@Validated ShainForm shainForm,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index.html";
        }

        // String name = "コントローラー太郎";
        // サービス層から社員を検索
        ShainService shainService = new ShainServiceImpl();
        String name = shainService.findByNo(shainForm.getNumber());

        model.addAttribute("number", shainForm.getNumber());
        model.addAttribute("name", name);
        return "output.html";
    }

}
