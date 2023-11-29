package com.example.ff_sdci.DB

import java.time.LocalDateTime
import java.util.Date

data class User(
    var name: String,
    var email: String,
    var uId: String
){
    constructor(): this("","","")
}

