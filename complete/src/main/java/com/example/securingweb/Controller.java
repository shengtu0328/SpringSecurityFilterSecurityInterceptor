package com.example.securingweb;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/a")
    public String a(String email){
        return "email:"+email;
    }


    @RequestMapping("/b")
    public String b(){
        return "b";
    }

    @RequestMapping("/c")
    public String c(){
        return "c";
    }

    @RequestMapping("/d")
    public String d(){
        return "d";
    }

    @RequestMapping("/e")
    public String e(){
        return "e";
    }


    @RequestMapping("/f")
    public String f(){
        return "f";
    }

    @PreAuthorize("hasAuthority('authorityg')")
    @RequestMapping("/g")
    public String g(){
        return "g";
    }

    @PreAuthorize("hasAuthority('authorityg2')")
    @RequestMapping("/g2")
    public String g2(){
        return "g2";
    }

    @PreAuthorize("hasRole('ROLE_admin')")
    @RequestMapping("/h")
    public String h(){
        return "h";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping("/h1")
    public String h1(){
        return "h1";
    }

    @PreAuthorize("hasRole('ROLE_admin2')")
    @RequestMapping("/h2")
    public String h2(){
        return "h2";
    }


    @RequestMapping("/i")
    public String i(){
        return "i";
    }

}
