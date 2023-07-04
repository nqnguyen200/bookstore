package com.epam.genai.bookstore.example;

import com.epam.genai.bookstore.dto.ChatCompletionRequest;
import com.epam.genai.bookstore.dto.ChatCompletionResult;
import com.epam.genai.bookstore.dto.ChatMessage;
import com.epam.genai.bookstore.dto.ChatMessageRole;
import com.epam.genai.bookstore.service.OpenAiService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OpenAiApiExample {

    public static void main(String[] args) {
        OpenAiService service = new OpenAiService();

        // Prepare request body
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "You are a dog and will speak as such.");
        messages.add(systemMessage);

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .maxTokens(50)
                .stream(false)
                .build();

        // Call OpenAI API
        ChatCompletionResult result = service.createChatCompletion(chatCompletionRequest);
        log.info("Result after using Chat Completion API: {}", result.getChoices());
    }
}
