package com.example.yesDi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.ShainForm;

public class ShainController {
    private final ShainService shainService;

    // ShainServiceのDI
    public ShainController(ShainService shainService) {
        this.shainService = shainService;
    }

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

        String name = shainService.findByNo(shainForm.getNumber());

        model.addAttribute("number", shainForm.getNumber());
        model.addAttribute("name", name);
        return "output.html";
    }

}
