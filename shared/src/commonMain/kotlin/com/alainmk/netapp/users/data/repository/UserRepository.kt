package com.alainmk.netapp.users.data.repository

import com.alainmk.netapp.users.data.mapper.toUser
import com.alainmk.netapp.users.data.remote.UserApiService
import com.alainmk.netapp.users.data.remote.dto.UserDto
import com.alainmk.netapp.users.domain.user.User
import com.alainmk.translator_kmm.core.domain.util.Resource

class UserRepository(private  val service: UserApiService) {

    suspend fun getAllFollowers(): Resource<List<User>> {
        return try {
            val usersResponse: List<UserDto> = service.getAllFollowers()
            Resource.Success(usersResponse.map { it.toUser() })
        } catch (apiError: Exception) {
            Resource.Error(apiError)
        }
    }

    suspend fun getAllFollowing(): Resource<List<User>> {
        return try {
            val usersResponse: List<UserDto> = service.getAllFollowing()
            Resource.Success(usersResponse.map { it.toUser() })
        } catch (apiError: Exception) {
            Resource.Error(apiError)
        }
    }
}