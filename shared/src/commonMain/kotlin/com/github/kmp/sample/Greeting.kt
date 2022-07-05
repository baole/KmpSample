package com.github.kmp.sample

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}