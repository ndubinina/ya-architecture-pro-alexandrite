package ru.service_a

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class ControllerB {
    @GetMapping("/test")
    @ResponseBody
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok("BBBB")
    }
}