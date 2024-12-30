package com.thefluyter.cameldemo.collector;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class RestCollector extends RouteBuilder {

    @Override
    public void configure() {

        rest("/api")
            .post("/collector").description("Collect API calls")
            .type(String.class)
            .consumes(APPLICATION_JSON_VALUE)
            .routeId("my.first.rest.collector.api")
            .responseMessage().code(OK.value()).message("OK").endResponseMessage()
            .to("direct:yo");

        from("direct:yo")
            .routeId("my.first.rest.collector")
            .log("Received the following body ${body}");

    }
}
