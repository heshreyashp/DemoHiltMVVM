package java.com.cheezycode.daggermvvm.di

import com.cheezycode.daggermvvm.retrofit.NewFakerAPI
import retrofit2.Response
import java.com.cheezycode.daggermvvm.models.BaseModel
import java.com.cheezycode.daggermvvm.models.LoginResponseModel
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: NewFakerAPI
) : ApiHelper {
    override suspend fun getEmployees(): Response<BaseModel<LoginResponseModel>> =
        apiService.validate("123456789")
}