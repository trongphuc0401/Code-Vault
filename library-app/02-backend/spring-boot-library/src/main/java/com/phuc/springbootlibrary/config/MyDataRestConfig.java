package com.phuc.springbootlibrary.config;

import com.nimbusds.oauth2.sdk.Message;
import com.phuc.springbootlibrary.entity.Book;
import com.phuc.springbootlibrary.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    private  String theAllowedOrigins = "http://localhost:3000";


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedAction = {
                HttpMethod.POST,
                HttpMethod.PATCH,
                HttpMethod.DELETE,
                HttpMethod.PUT};
        config.exposeIdsFor(Book.class);
        config.exposeIdsFor(Review.class);
        config.exposeIdsFor(Message.class);

        disableHttpMethods(Book.class,config,theUnsupportedAction);
        disableHttpMethods(Review.class,config,theUnsupportedAction);
        disableHttpMethods(Message.class,config,theUnsupportedAction);

        /*Configure*/
        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigins);
    }
    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedAction) {
        config.getExposureConfiguration().forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods
                        .disable(theUnsupportedAction))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods
                        .disable(theUnsupportedAction));
    }




    }


