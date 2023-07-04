package com.epam.genai.bookstore.service;

import com.epam.genai.bookstore.dto.ChatCompletionRequest;
import com.epam.genai.bookstore.dto.ChatCompletionResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class OpenAiService {

    private static final String BASE_URL = "https://api.openai.com/";

    private final static String TOKEN = System.getenv("OPENAI_TOKEN");

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    private WebClient webClient;

    public OpenAiService() {
        webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .defaultCookie("cookie-name", "cookie-value")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public ChatCompletionResult createChatCompletion(ChatCompletionRequest request) {
        return webClient.post()
                .uri("/v1/chat/completions")
                .headers(h -> h.setBearerAuth(TOKEN))
                .body(Mono.just(request), ChatCompletionRequest.class)
                .retrieve()
                .bodyToMono(ChatCompletionResult.class)
                .doOnError(e -> e.printStackTrace())
                .block(DEFAULT_TIMEOUT);
    }
}
