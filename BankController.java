package com.bank.controller;

import com.bank.model.Account;
import com.bank.service.BankService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BankController {

    @Autowired
    BankService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/add")
    public String addPage() {
        return "add";
    }

    @PostMapping("/add")
    public String addAccount(@RequestParam String name,
                             @RequestParam double balance) {
        service.addAccount(new Account(name, balance));
        return "redirect:/view";
    }

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("accounts", service.getAccounts());
        return "view";
    }
}
