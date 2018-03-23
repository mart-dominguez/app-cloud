/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.ams.app.logica;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jersey2.InstrumentedResourceMethodApplicationListener;
import com.mavha.ams.app.servlets.MyMetricsServletContextListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author marti
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

    private Set<Class<?>> classes = new HashSet<Class<?>>();
    private static final Logger logger = Logger.getLogger(ApplicationConfig.class.getName());


    /*  @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }*/
    public ApplicationConfig() {
        this.initializeApplication();
    }

    private void initializeApplication() {
        registerListeners(); // Register listeners
    }

    private void registerListeners() {
        //final MetricRegistry metricRegistry = new MetricRegistry();
        MetricRegistry reg = MyMetricsServletContextListener.METRIC_REGISTRY;
        register(new InstrumentedResourceMethodApplicationListener(reg));

        ConsoleReporter.forRegistry(reg)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build()
                .start(1, TimeUnit.MINUTES);
        logger.info("Console reporter is enabled successfully!");
        register(com.mavha.ams.app.logica.ProductoResource.class);

    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mavha.ams.app.logica.ProductoResource.class);
    }

}
