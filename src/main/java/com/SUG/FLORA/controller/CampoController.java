package com.SUG.FLORA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SUG.FLORA.services.CampoService;

@Controller
@RequestMapping("campos")
public class CampoController {

    @Autowired
    CampoService campoService;

    @GetMapping("novo")
    public String getPage() {

        return "users/add-campo-users";
    }

}
