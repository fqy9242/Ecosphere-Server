package com.ecosphere.AI;

import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.ecosphere.AI.pojo.AiChatDto;
import com.ecosphere.common.annotation.Anonymous;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Anonymous
@RestController
@RequestMapping("/ai/deepseek")
public class DeepSeekController {

    private final DashScopeChatModel chatModel;

    public DeepSeekController(DashScopeChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @PostMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamChatReactive(@RequestBody AiChatDto aiChatDto) {
        return Flux.from(chatModel.stream(new Prompt(aiChatDto.getMessage())))
                .map(chunk -> {
                    if (chunk.getResult() != null
                            && chunk.getResult().getOutput() != null
                            && chunk.getResult().getOutput().getContent() != null) {
                        return chunk.getResult().getOutput().getContent();
                    }
                    return ""; // 过滤空数据
                })
                .filter(content -> !content.isEmpty())
                .onErrorResume(e -> Flux.just("Error: " + e.getMessage()))
                .doFinally(signal -> System.out.println("Stream completed"));
    }
}