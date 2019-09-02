package ru.eugene.java.learn;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.eugene.java.learn.rest.RestConfiguration;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RestConfiguration.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
