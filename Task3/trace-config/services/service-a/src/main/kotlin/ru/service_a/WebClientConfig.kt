package ru.service_a

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig(
    private val webClientProperties: WebClientProperties,
) {
    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl(webClientProperties.url)
            .build()
    }
}

@Component
@ConfigurationProperties(prefix = "webclient.config")
class WebClientProperties {
    lateinit var url: String
    var timeout: Long = 5000
}