package com.alainmk.netapp.users.data.remote

import com.alainmk.netapp.users.data.remote.dto.UserDto
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserApiService : KtorApi() {
    companion object {
        const val FOLLOWERS = "/users/Byvak/followers"
        const val FOLLOWING = "/users/Byvak/following"
    }

    suspend fun getAllFollowers(): List<UserDto> {
        return client.get(BASE_URL + FOLLOWERS).body()
    }

    suspend fun getAllFollowing(): List<UserDto> {
        return client.get(BASE_URL + FOLLOWING).body()
    }
}