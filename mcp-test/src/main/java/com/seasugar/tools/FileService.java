package com.seasugar.tools;

import com.seasugar.mcp.server.annotation.ToolService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;

@ToolService
public class FileService {
    // 写入文件内容
    @Tool(description = "将数据写入文件")
    public void writeFile(
            @ToolParam(description = "文件路径") String filePath,
            @ToolParam(description = "文件内容") String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            writer.flush();
        }
    }

    // 读取文件内容
    @Tool(description = "读取文件内容")
    public String readFile(
            @ToolParam(description = "文件路径") String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        }
        return content.toString();
    }
}