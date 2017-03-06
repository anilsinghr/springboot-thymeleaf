/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author anilsingh.r
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class ThymeleafObjects {

    @ModelAttribute("messages")
    List<String> messages() {
        return Arrays.asList("Message 1", "Message 2", "Message 3");
    }

    @GetMapping("/model-attr")
    String modelAttributes(Model model) {
        return "th-objects";
    }

    @GetMapping("/query-params")
    String queryParams() {
        return "redirect:/model-attr?q=My Query";
    }

    @GetMapping("/session-attr")
    String sessionAttributes(HttpSession session) {
        session.setAttribute("mySessionAttribute", "Session Attr 1");
        return "th-objects";
    }

    @Configuration
    public class MyConfiguration {
        @Bean(name = "urlService")
        public UrlService urlService() {
            return () -> "domain.com/myapp";
        }
    }

    public interface UrlService {
        String getApplicationUrl();
    }
}
