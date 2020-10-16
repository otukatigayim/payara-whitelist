package com.otukatigayim.payara_whitelist;

import java.util.ServiceLoader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
    }

    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        final ServiceLoader<MyService> loaders = ServiceLoader.load(MyService.class);
        if (loaders.iterator().hasNext()) {
            loaders.iterator().next().doSomething();
        } else {
            throw new RuntimeException("MyServiceImpl failed to load.");
        }
    }

}
