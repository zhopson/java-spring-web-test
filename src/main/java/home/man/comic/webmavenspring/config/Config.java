/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.man.comic.webmavenspring.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author andrey-man
 */
@Configuration
public class Config implements WebMvcConfigurer {

//  @Bean
//  public ViewResolver viewResolver() {
//    MustacheViewResolver mustacheViewResolver
//        = new MustacheViewResolver();
//    mustacheViewResolver.setPrefix("/src/main/resources/templates/");
//    mustacheViewResolver.setSuffix(".html");
//    mustacheViewResolver.setCache(false);
//    return mustacheViewResolver;
//  }
}