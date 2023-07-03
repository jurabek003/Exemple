package uz.turgunboyevjurabek.exemple.ViewMadels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.exemple.Madels.User
import uz.turgunboyevjurabek.exemple.Repozitory.ValyutaRepozitory
import uz.turgunboyevjurabek.exemple.UTils.Resourse
import java.lang.Exception

class ViewMadel(val repozitory: ValyutaRepozitory ):ViewModel() {

    private val liveData=MutableLiveData<Resourse<List<User>>>()

    fun getAllData():MutableLiveData<Resourse<List<User>>>{
        viewModelScope.launch{
            liveData.postValue(Resourse.loading("loading..."))
            try {

                coroutineScope {
                    val respons=async {
                        repozitory.getAllItem()
                    }.await()
                    liveData.postValue(Resourse.success(respons))
                }


            }catch (e:Exception){
                liveData.postValue(Resourse.error(e.message))
            }
        }

        return liveData
    }

}