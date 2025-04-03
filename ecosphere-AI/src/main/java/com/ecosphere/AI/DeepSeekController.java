package com.ecosphere.AI;

import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.ecosphere.AI.pojo.AiChatDto;
import com.ecosphere.common.annotation.Anonymous;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * @author qht
 */
@Anonymous
@RestController
@RequestMapping("/ai/deepseek")
@RequiredArgsConstructor
public class DeepSeekController {
    private final ChatClient chatClient;
    @PostMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamChatReactive(@RequestBody AiChatDto aiChatDto) {
        return chatClient.prompt()
                .user(aiChatDto.getMessage())
//                .advisors()
                .stream()
                .content();
    }
}