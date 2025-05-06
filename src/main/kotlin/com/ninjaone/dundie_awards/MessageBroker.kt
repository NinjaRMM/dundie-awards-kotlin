package com.ninjaone.dundie_awards

import com.ninjaone.dundie_awards.model.Activity
import org.springframework.stereotype.Component

@Component
class MessageBroker {

    private val messages: MutableList<Activity> = mutableListOf()

    fun sendMessage(message: Activity) {
        messages.add(message)
    }

    fun getMessages(): List<Activity> = messages
}
