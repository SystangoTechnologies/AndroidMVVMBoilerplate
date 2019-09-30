package com.systango.sociallogin

data class SocialAuthResult(
    val token: String,
    val userId: String = "",
    val userName: String = "",
    val email: String = ""
)
