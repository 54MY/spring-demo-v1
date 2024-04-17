package com.example.demo.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.http.HealthMessage;
import com.example.demo.util.config.PropertyCache;

/**
 * GeneralResource
 *
 * @author Samuel Veizaga
 * @since 1.0
 */
@RestController
@RequestMapping("/v1/demo/bo")
public class GeneralResource {

    private static final Logger logger = LoggerFactory.getLogger(GeneralResource.class);

    @Autowired
    PropertyCache propertyCache;

    @GetMapping("/status")
    public ResponseEntity<Object> healthRequest(HttpServletRequest request) throws Exception {

        HealthMessage object;
        HttpHeaders responseHeaders = new HttpHeaders();
        requestLog(request);

        object = new HealthMessage(propertyCache.test_api_properties);

        responseHeaders.set("Custom-Message", "HTTP/1.1 200 OK");
        return new ResponseEntity<>(object, responseHeaders, HttpStatus.OK);
    }

    private synchronized void requestLog(HttpServletRequest request) {
        logger.info(" <= " + request.getRemoteHost() + " {method:" + request.getMethod()
                        + ", URI:" + request.getRequestURI() + ", query:" + request.getQueryString() + " PROBANDOOOOOO !!!!"+"}");
    }

}
