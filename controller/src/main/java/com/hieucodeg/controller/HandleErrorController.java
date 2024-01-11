package com.hieucodeg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class HandleErrorController {
    @RequestMapping("/400")
    public String badRequest() {
        return "error/400";
    }

    @RequestMapping("/401")
    public String unauthorized() {
        return "error/401";
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "error/403";
    }

    @RequestMapping("/404")
    public String resourceNotFound() {
        return "error/404";
    }

    @RequestMapping("/405")
    public String methodNotAllowed() {
        return "error/405";
    }

    @RequestMapping("/409")
    public String dataConflict() {
        return "error/409";
    }

    @RequestMapping("/500")
    public String internalServerError() {
        return "error/500";
    }
}
