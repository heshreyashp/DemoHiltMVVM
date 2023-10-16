package com.cheezycode.daggermvvm.retrofit
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.com.cheezycode.daggermvvm.models.BaseModel
import java.com.cheezycode.daggermvvm.models.LoginResponseModel

interface NewFakerAPI {


    @GET("validate/{token}")
    suspend fun validate(@Path("token") token: String?): Response<BaseModel<LoginResponseModel>>
}