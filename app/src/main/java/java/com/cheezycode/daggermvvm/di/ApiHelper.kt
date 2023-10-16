package java.com.cheezycode.daggermvvm.di

import retrofit2.Response
import java.com.cheezycode.daggermvvm.models.BaseModel
import java.com.cheezycode.daggermvvm.models.LoginResponseModel
import javax.inject.Inject

interface ApiHelper {
    suspend fun getEmployees(): Response<BaseModel<LoginResponseModel>>
}