package com.alainmk.netapp.users.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto (
    @SerialName("login") val username: String,
    @SerialName("avatar_url") val image: String,
    @SerialName("html_url") val url: String,
)