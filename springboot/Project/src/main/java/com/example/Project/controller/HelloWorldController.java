package com.example.Project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Project.utils.SiteRoles;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
/**
 * HelloWorldController
 */
public class HelloWorldController {
    @Secured({SiteRoles.APP_USER})
    @GetMapping(value = "/")
    public String helloWorld() {
        return "Hello World";
    }
    @Secured({SiteRoles.APP_USER})
    @GetMapping(value="/simplelist")
    public String[] helloWorldList  () {
        return new String[] {"Hello","World" };
    }

}