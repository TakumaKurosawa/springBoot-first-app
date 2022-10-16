package com.spring.boot.first.app

import org.springframework.web.bind.annotation.*

data class HelloRequest(val name: String)
data class HelloResponse(val message: String)

@RestController
@RequestMapping("greeter")
class GreeterController {
    @RequestMapping("/hello")
    fun hello(@RequestParam("name") name: String): HelloResponse {
        return HelloResponse("Hello, $name!")
    }

    @RequestMapping("/hello/{name}")
    fun helloPathValue(@PathVariable("name") name: String): HelloResponse {
        return HelloResponse("Hello, $name!")
    }

    @PostMapping("/hello")
    fun helloByPost(@RequestBody req: HelloRequest): HelloResponse {
        return HelloResponse("Hello, ${req.name}!")
    }
}
