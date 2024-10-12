package com.arash.altafi.myapplication1.data.model

data class ResponseUsers(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String,
    val company: Company
)

data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)