package com.example.deployexample2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@RestController
public class DeployExample2Application {

    private final Repo repo;

    public DeployExample2Application(Repo repo) {
        this.repo = repo;
    }

    @GetMapping("/product")
    public String message(Model model){
        List<Product> lista=repo.findAll();
        model.addAttribute("listaProdukti", lista);
        return "ivana";
    }

    public static void main(String[] args) {
        SpringApplication.run(DeployExample2Application.class, args);
    }

}
