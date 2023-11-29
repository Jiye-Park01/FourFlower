package com.example.ff_sdci.Chat

data class Message(
    val message: String?,
    var sendId: String?
){
    constructor():this("","")
}

