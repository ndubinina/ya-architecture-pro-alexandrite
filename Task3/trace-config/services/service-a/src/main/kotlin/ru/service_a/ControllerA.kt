package ru.service_a

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class ControllerA(
    @Qualifier("webClient")
    private val webClient: WebClient,
) {
    @GetMapping("/test")
    @ResponseBody
    fun test(): ResponseEntity<String> {
        val result = webClient.get()
            .uri("/test")
            .retrieve()
            .bodyToMono(String::class.java)
            .block()!!
        return ResponseEntity.ok("AAAA_" + result)
    }
}