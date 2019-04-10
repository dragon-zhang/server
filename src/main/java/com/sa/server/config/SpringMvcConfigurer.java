package com.sa.server.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author SuccessZhang
 */
@Configuration
@ControllerAdvice
@RequiredArgsConstructor
public class SpringMvcConfigurer implements WebMvcConfigurer {

    /**
     * 将@RequestParam中的""全部转化为null
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
