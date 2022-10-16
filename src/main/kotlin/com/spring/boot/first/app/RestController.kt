package com.spring.boot.first.app

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*

data class HelloRequest(val name: String)
data class HelloResponse(val message: String)

/**
 * フィールドインジェクション、セッターインジェクションも存在するが、基本的にはSpringFramework側の推奨している
 * コンストラクタインジェクションを使う
 * @Qualifier("クラス名")：同一のinterfaceを実装しているクラスが2つ以上存在する場合に、Injectするクラスを指定できる。
 */
@RestController
@RequestMapping("greeter")
class GreeterController(
    @Qualifier("EnglishGreeter")
    private val englishGreeter: Greeter,
    @Qualifier("JapaneseGreeter")
    private val japaneseGreeter: Greeter
) {
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

    @GetMapping("/hello/english/{name}")
    fun sayHelloInEnglish(@PathVariable("name") name: String): HelloResponse {
        return HelloResponse(englishGreeter.sayHello(name))
    }

    @GetMapping("/hello/japanese/{name}")
    fun sayHelloInJapanese(@PathVariable("name") name: String): HelloResponse {
        return HelloResponse(japaneseGreeter.sayHello(name))
    }
}
