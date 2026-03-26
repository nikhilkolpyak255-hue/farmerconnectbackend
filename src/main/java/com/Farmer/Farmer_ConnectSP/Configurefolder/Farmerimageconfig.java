package com.Farmer.Farmer_ConnectSP.Configurefolder;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Farmerimageconfig implements WebMvcConfigurer {

    // ✅ Serve images from local project folder (relative path)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/Farmer-photo/**")
                .addResourceLocations("file:uploads/Farmer-photo/");

        registry.addResourceHandler("/Customer-images/**")
                .addResourceLocations("file:uploads/Customer-images/");

        registry.addResourceHandler("/Product-images/**")
                .addResourceLocations("file:uploads/Product-images/");

        registry.addResourceHandler("/Junction-images/**")
                .addResourceLocations("file:uploads/Junction-images/");
    }

    // ✅ Enable CORS for Angular (Netlify + Local)
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:4200",                     // local Angular
                        "https://your-site.netlify.app"              // 🔁 replace with your real Netlify URL
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(false);
    }
}