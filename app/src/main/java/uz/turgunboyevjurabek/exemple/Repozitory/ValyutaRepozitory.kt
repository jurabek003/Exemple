package uz.turgunboyevjurabek.exemple.Repozitory

import uz.turgunboyevjurabek.exemple.Network.ApiServis

class ValyutaRepozitory(val apiServis: ApiServis) {
    suspend fun getAllItem()=apiServis.getItem()

}