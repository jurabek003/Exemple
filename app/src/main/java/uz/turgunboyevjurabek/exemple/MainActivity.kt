package uz.turgunboyevjurabek.exemple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import uz.turgunboyevjurabek.exemple.Adapter.RvAdapter
import uz.turgunboyevjurabek.exemple.Network.ApiClinet
import uz.turgunboyevjurabek.exemple.Repozitory.ValyutaRepozitory
import uz.turgunboyevjurabek.exemple.UTils.Status
import uz.turgunboyevjurabek.exemple.ViewMadels.ViewMadel
import uz.turgunboyevjurabek.exemple.ViewMadels.ViewModelFactory
import uz.turgunboyevjurabek.exemple.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val allambalo by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var viewMadel: ViewMadel
    private lateinit var rvAdapter: RvAdapter
    private lateinit var repozitory: ValyutaRepozitory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(allambalo.root)
        shows()
        swipe()

    }

    private fun swipe() {
        allambalo.swipeLayout.setColorSchemeResources(R.color.sariq,R.color.qizil,R.color.kok,R.color.kok2,R.color.black,R.color.white,)
        allambalo.swipeLayout.setOnRefreshListener {
            shows()
            Handler(Looper.getMainLooper()).postDelayed({
                allambalo.swipeLayout.isRefreshing=false
            },4000)



        }
    }

    private fun shows() {
        repozitory= ValyutaRepozitory(ApiClinet.getRetrofitServis())
        viewMadel=ViewModelProvider(this, ViewModelFactory(repozitory)).get(ViewMadel::class.java)

        viewMadel.getAllData().observe(this){
            when(it.status){
                Status.LOADING->{
                    Toast.makeText(this, " Loading...", Toast.LENGTH_SHORT).show()
                }
                Status.ERROR->{
                    Toast.makeText(this,  "XATO->  ${it.massage}", Toast.LENGTH_LONG).show()
                }
                Status.SUCCESS->{
                    rvAdapter=RvAdapter(it.date!!)
                    allambalo.rv.adapter=rvAdapter
                    rvAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}