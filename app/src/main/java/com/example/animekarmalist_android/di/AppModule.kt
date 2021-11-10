package com.example.animekarmalist_android.di

import com.example.animekarmalist_android.data.remote.AnimeKarmaListApi
import com.example.animekarmalist_android.repository.ProdRepository
import com.example.animekarmalist_android.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAnimeKarmaListRepository(
        api: AnimeKarmaListApi
    ) = ProdRepository(api)

    @Singleton
    @Provides
    fun providePokeApi(): AnimeKarmaListApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(AnimeKarmaListApi::class.java)
    }
}