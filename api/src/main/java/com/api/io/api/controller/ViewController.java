package com.api.io.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * ViewController
 */
@RestController
@RequestMapping("/local")
public class ViewController {

    @GetMapping()
    public String getVS() {
        return "String VSCODE";
    }
    
    
}