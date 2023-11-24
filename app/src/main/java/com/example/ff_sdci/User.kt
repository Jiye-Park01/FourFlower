package com.example.ff_sdci

import java.time.LocalDateTime
import java.util.Date

data class User(
    var user_id: Long,
    var user_name: String,
    var user_login_id: String,
    var user_pw: String,
    var user_phone: Long?,
    var user_nickname: String?,
    var user_join_date: Date,
    var login_type: String?,
    var family_token: Long?,
    var disturb_id: Long?
)

