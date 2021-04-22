package net.marco27.api.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController implements ErrorController {
    static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Invalid request!";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}