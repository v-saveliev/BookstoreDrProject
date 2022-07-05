package org.bookstore;

import org.apache.log4j.Logger;
import org.bookstore.web.config.WebContextConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletContext;

public class WebAppInitializer implements WebApplicationInitializer {

    Logger logger = Logger.getLogger(WebAppInitializer.class);

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        logger.info("loading app config");
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        container.addListener(new ContextLoaderListener(rootContext));

        logger.info("loading web config");
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebContextConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        logger.info("dispatcher ready");

    }
}
