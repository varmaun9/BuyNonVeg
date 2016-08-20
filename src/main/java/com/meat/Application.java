package com.meat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.support.GenericConversionService;

/**
 * Class to register the beans to the application context and to enable auto configuration
 *
 * @author rbuddepu
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

    public final static String CONVERSION_SERVICE_BEANNAME = "conversionService";
    private static Class<Application> applicationClass = Application.class;

    //private static Class<SolrApplication> applicationClass1 = SolrApplication.class;

    public static void main(final String[] args) {
        SpringApplication.run(applicationClass, args);

    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    /**
     * Creating the Spring Conversion service bean
     */
    @Bean(name = CONVERSION_SERVICE_BEANNAME)
    @Primary
    public GenericConversionService conversionService() {
        return new GenericConversionService();
    }

    /*  public void destroy() {
          String prefix = getClass().getSimpleName() + " destroy() ";
          // ServletContext ctx = getServletContext();
          try {
              Enumeration<Driver> drivers = DriverManager.getDrivers();
              while (drivers.hasMoreElements()) {
                  DriverManager.deregisterDriver(drivers.nextElement());
              }
          }
          catch (Exception e) {
              //ctx.log(prefix + "Exception caught while deregistering JDBC drivers", e);
              e.printStackTrace();
          }
          //ctx.log(prefix + "complete");
      }
     */
    /**
     * create the Mapper for Jackson
     */
    @Bean
    @Primary
    public ObjectMapper jacksonObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    /**
     * create the Mapper for siren
     */
    @Bean
    public ObjectMapper sirenObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }
}
