package com.thefluyter.cameldemo.collector;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileCollector extends RouteBuilder {

    @Override
    public void configure() {

        from("file:collector-map-in").routeId("my.first.file.collector")
            .log("Processing file: ${file:name}")
            .to("file:distributor-map-out");

    }
}
