package uz.turgunboyevjurabek.exemple.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.turgunboyevjurabek.exemple.Madels.User
import uz.turgunboyevjurabek.exemple.databinding.ItemRvBinding

class RvAdapter (val list: List<User>) :
        RecyclerView.Adapter<RvAdapter.Vh>() {
        inner class Vh(val itemrv: ItemRvBinding) : RecyclerView.ViewHolder(itemrv.root) {
            fun onBind(user: User) {
                itemrv.tht1.text=user.ccyNmUZ
                itemrv.tht2.text=user.date
                val sotib_olish=user.diff.toString().toDouble()+user.rate.toString().toDouble()
                val sotish=user.rate.toString().toDouble() - user.diff.toString().toDouble()
                itemrv.tht4.text=sotish.toString()
                itemrv.tht6.text=sotib_olish.toString()
                itemrv.thtUsd.text=user.ccy
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
            return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: Vh, position: Int) {
            holder.onBind(list[position])
        }

    }
