package uz.turgunboyevjurabek.exemple.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClinet {
    const val BASE_URL="https://cbu.uz/uz/arkhiv-kursov-valyut/"
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofitServis():ApiServis{
        return getRetrofit().create(ApiServis::class.java)
    }
}