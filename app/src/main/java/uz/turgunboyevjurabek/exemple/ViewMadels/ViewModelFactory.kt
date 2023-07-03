package uz.turgunboyevjurabek.exemple.ViewMadels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import uz.turgunboyevjurabek.exemple.Repozitory.ValyutaRepozitory
import java.lang.IllegalArgumentException

class ViewModelFactory(val repozitory: ValyutaRepozitory):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if(modelClass.isAssignableFrom(ViewMadel::class.java)){
            return ViewMadel(repozitory) as T
        }
        throw IllegalArgumentException("error")
    }
}