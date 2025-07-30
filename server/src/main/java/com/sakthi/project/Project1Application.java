package com.sakthi.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.CommandLineRunner;

import javax.sql.DataSource;
import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@ComponentScan(basePackages = "com.sakthi.project")
public class Project1Application extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    // @Override
    // protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    //     return application.sources(Project1Application.class);
    // }

    @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
            return builder
                    .sources(Project1Application.class)
                    .properties("server.servlet.context-path=/");
        }


    public static void main(String[] args) {
        SpringApplication.run(Project1Application.class, args);
    }

    @Override
    public void run(String... args) {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("✅ Database connected successfully: " + conn.getMetaData().getURL() + "🎊🎊🎊🎊🎊🎊");
        } catch (Exception e) {
            System.out.println("❌ Failed to connect to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
