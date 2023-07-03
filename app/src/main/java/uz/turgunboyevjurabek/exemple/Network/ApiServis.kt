package uz.turgunboyevjurabek.exemple.Network

import retrofit2.http.GET
import uz.turgunboyevjurabek.exemple.Madels.User

interface ApiServis {

    @GET("json/")
    suspend fun getItem():ArrayList<User>

}