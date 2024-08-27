package com.example.micro2.controller;

import io.micrometer.tracing.TraceContext;
import io.micrometer.tracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/your-endpoint")
public class TraceController {

    Logger logger = LoggerFactory.getLogger(TraceController.class);

    @Autowired
    private Tracer tracer;

    @GetMapping("/{id}")
public NewDto trace(@PathVariable String id) {
        TraceContext context = tracer.currentSpan().context();
        logger.info("Tracing endpoint hit!"+ context.traceId() + " ::" + context.spanId());
        logger.info("Logging info "+ id);
        return new NewDto("Tracing endpoint hit! "+ id);
    }
}


 class NewDto{
    public String traceId;

     public NewDto(String traceId) {
         this.traceId = traceId;
     }
 }