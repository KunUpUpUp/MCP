package com.seasugar.mcp.server;

import com.seasugar.mcp.server.tool.WeatherService;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpServerApp {
    public static void main(String[] args) {
        SpringApplication.run(McpServerApp.class, args);
    }

    @Bean
    public List<ToolCallback> mathTools(WeatherService weatherService) {
        return List.of(ToolCallbacks.from(weatherService));
    }

}
