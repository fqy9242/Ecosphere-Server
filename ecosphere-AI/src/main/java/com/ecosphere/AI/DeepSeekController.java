package com.ecosphere.AI;
import com.ecosphere.AI.pojo.AiChatDto;
import com.ecosphere.common.annotation.Anonymous;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;
/**
 * @author qht
 */
@Anonymous
@Tag(name = "ai-deepSeek模块")
@RestController
@RequestMapping("/ai/deepseek")
@RequiredArgsConstructor
public class DeepSeekController {
    private final ChatClient chatClient;
    @Operation(summary = "对话")
    @PostMapping(value = "/chat", produces = "html/text;charset-utf-8")
    public Flux<String> streamChatReactive(@RequestBody AiChatDto aiChatDto) {
        return chatClient.prompt()
                .user(aiChatDto.getMessage())
                .advisors(advisorSpec -> advisorSpec.param(CHAT_MEMORY_CONVERSATION_ID_KEY, aiChatDto.getChatId()))
                .stream()
                .content();
    }
}