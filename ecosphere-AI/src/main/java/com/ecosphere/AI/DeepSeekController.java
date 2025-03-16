package com.ecosphere.AI;

import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.ecosphere.common.annotation.Anonymous;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.*;

/**
 * @author qht
 * @date 2025/3/16
 */
@Anonymous
@RestController
@RequestMapping("/ai/deepseek")
public class DeepSeekController {
    private final DashScopeChatModel chatModel;

    public DeepSeekController(DashScopeChatModel chatModel) {
        this.chatModel = chatModel;
    }
    @PostMapping("/chat")
    public Object chat(String message) {
        ChatResponse chatResponse = chatModel.call(new Prompt(message));
//        return chatResponse.getResult().getOutput().getContent();
        return chatResponse.getResult();
    }
}