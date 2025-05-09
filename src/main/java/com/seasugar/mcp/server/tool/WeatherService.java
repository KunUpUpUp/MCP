package com.seasugar.mcp.server.tool;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class WeatherService {
    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    @Value("${API-KEY}")
    private String apiKey;

    @Tool(description = "根据经纬度获取天气预报")
    public String getWeatherForecastByLocation(
            double longitude,
            double latitude) {
        double[] location = new double[2];
        location[0] = longitude;
        location[1] = latitude;
        log.info("根据经纬度获取天气预报");
//        OkHttpClient client = new OkHttpClient();
//        String apiUrl = "https://api.open.geovisearth.com/v2/cn/area/basic?token="
//                + apiKey + "&location=" + Arrays.toString(location);
//
//        Request request = new Request.Builder()
//                .url(apiUrl)
//                .get()
//                .build();

//        try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful()) {
//                throw new IOException("请求失败: " + response);
//            }
//            String result = response.body().string();
//            log.info("天气API返回结果: {}", result);
//            return result;
//        } catch (Exception e) {
//            return "获取天气信息失败：" + e.getMessage();
//        }

        return "天气信息为晴，26度";
    }

    @Tool(description = "根据经纬度获取空气质量信息")
    public String getAirQuality(
            String latitude,
            String longitude) {
        log.info("根据经纬度获取空气质量信息");
        // 模拟数据，实际应用中应调用真实API
        return "当前位置（纬度：" + latitude + "，经度：" + longitude + "）的空气质量：\n" +
                "- PM2.5: 15 μg/m³ (优)\n" +
                "- PM10: 28 μg/m³ (良)\n" +
                "- 空气质量指数(AQI): 42 (优)\n" +
                "- 主要污染物: 无";
    }

}

