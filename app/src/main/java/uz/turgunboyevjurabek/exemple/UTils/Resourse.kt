package uz.turgunboyevjurabek.exemple.UTils

import java.util.Date

data class Resourse<out T>(val status: Status,val date: T?,val massage:String?){
    companion object{
        fun <T>success(date: T):Resourse<T>{
            return Resourse(Status.SUCCESS,date,null)
        }
        fun <T>error(massage: String?):Resourse<T>{
            return Resourse(Status.ERROR,null,massage)
        }
        fun <T>loading(massage: String?):Resourse<T>{
            return Resourse(Status.LOADING,null,null)
        }
    }
}

