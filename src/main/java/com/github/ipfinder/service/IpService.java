package com.github.ipfinder.service;

import com.github.ipfinder.model.dto.IpDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class IpService {
    public IpDto getInfo(String ip) {
        try {
            return getInfoIp(new InetSocketAddress(ip, 0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//
    private IpDto getInfoIp(InetSocketAddress ip) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://ip-api.com/json/" + ip.getHostName()))
                .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        IpDto ipDto = objectMapper.readValue(response.body(), IpDto.class);
        return ipDto;
    }
}