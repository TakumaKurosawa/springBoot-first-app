package com.spring.boot.first.app

import org.springframework.stereotype.Component

interface Greeter {
    fun sayHello(name: String): String
}

@Component("EnglishGreeter")
class EnglishGreeter : Greeter {
    override fun sayHello(name: String): String {
        return "Hello, $name!"
    }
}

@Component("JapaneseGreeter")
class JapaneseGreeter : Greeter {
    override fun sayHello(name: String): String {
        return "こんにちは、$name!"
    }
}
