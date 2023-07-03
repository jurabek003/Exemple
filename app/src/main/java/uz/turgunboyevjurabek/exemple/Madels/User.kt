package uz.turgunboyevjurabek.exemple.Madels


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("Ccy")
    val ccy: String,
    @SerializedName("CcyNm_EN")
    val ccyNmEN: String,
    @SerializedName("CcyNm_RU")
    val ccyNmRU: String,
    @SerializedName("CcyNm_UZ")
    val ccyNmUZ: String,
    @SerializedName("CcyNm_UZC")
    val ccyNmUZC: String,
    @SerializedName("Code")
    val code: String,
    @SerializedName("Date")
    val date: String,
    @SerializedName("Diff")
    val diff: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("Nominal")
    val nominal: String,
    @SerializedName("Rate")
    val rate: String

) {
    override fun toString(): String {
        return "User(ccy='$ccy', ccyNmEN='$ccyNmEN', ccyNmRU='$ccyNmRU', ccyNmUZ='$ccyNmUZ', ccyNmUZC='$ccyNmUZC', code='$code', date='$date', diff='$diff', id=$id, nominal='$nominal', rate='$rate')"
    }
}