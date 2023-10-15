package com.alainmk.netapp.users.data.mapper

import com.alainmk.netapp.users.data.remote.dto.UserDto
import com.alainmk.netapp.users.domain.user.User

fun UserDto.toUser(): User {
    return User(
        username, image, url
    )
}