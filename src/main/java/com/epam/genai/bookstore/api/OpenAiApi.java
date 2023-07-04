package com.epam.genai.bookstore.api;

import com.epam.genai.bookstore.dto.ChatCompletionRequest;
import com.epam.genai.bookstore.dto.ChatCompletionResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface OpenAiApi {

    @PostMapping("/v1/chat/completions")
    ChatCompletionResult createChatCompletion(@RequestBody ChatCompletionRequest request);

}
