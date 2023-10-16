package java.com.cheezycode.daggermvvm.di

import com.cheezycode.daggermvvm.retrofit.NewFakerAPI
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NewNetworkModule {


    //https://apiv2.stage-hubengage.com/display/

    @Provides
    fun provideBaseUrl() = "https://apiv2.stage-hubengage.com/display/auth/"

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun providesRetrofit2(
        okHttpClient: OkHttpClient,BASE_URL:String
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(NewFakerAPI::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

    /*: Retrofit {
        return Retrofit.Builder().baseUrl("https://apiv2.stage-hubengage.com/display/auth/")
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
    }

    @Singleton
    @Provides
    fun providesAPI(retrofit: Retrofit): NewFakerAPI {
        return retrofit.create(NewFakerAPI::class.java)
    }*/

}