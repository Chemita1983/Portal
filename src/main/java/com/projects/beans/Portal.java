package com.projects.beans;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.projects.config.PortalConfig;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
public class Portal {
    private final HttpClient httpClient;

    public Portal(PortalConfig config) {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(Long.parseLong(config.getTimeout())))
                .version(HttpClient.Version.valueOf(config.getHttp_version()))
                .priority(Integer.parseInt(config.getPriority()))
                .followRedirects(HttpClient.Redirect.valueOf(config.getRedirect()))
                .build();
    }

    public String get(URI uri, String[] headers) throws IOException, InterruptedException {

        HttpRequest requestBuilder = HttpRequest.newBuilder()
                .uri(uri)
                .headers(headers)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(requestBuilder, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String post(URI uri, String[] headers, String body) throws IOException, InterruptedException {

        HttpRequest requestBuilder = HttpRequest.newBuilder()
                .uri(uri)
                .headers(headers)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = httpClient.send(requestBuilder, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String post(URI uri, String[] headers, ObjectNode body) throws IOException, InterruptedException {

        HttpRequest requestBuilder = HttpRequest.newBuilder()
                .uri(uri)
                .headers(headers)
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(body)))
                .build();

        HttpResponse<String> response = httpClient.send(requestBuilder, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
