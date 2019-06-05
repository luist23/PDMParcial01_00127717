package com.luist23.parcial01v5.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luist23.parcial01v5.R
import com.luist23.parcial01v5.activities.MainActivity
import com.luist23.parcial01v5.activities.NewPartidoActivity
import com.luist23.parcial01v5.database.entities.Partido
import kotlinx.android.synthetic.main.partido_cardview.view.*



class PartidoAdapter (var partidos:List<Partido>,val clickListener:(Partido)->Unit) : RecyclerView.Adapter<PartidoAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return partidos.size
    }

    fun updateList(newPartidos:List<Partido>){
        this.partidos = newPartidos
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(partidos[position],clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.partido_cardview,parent,false)
        return  ViewHolder(view)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(partido :Partido, clickListener:(Partido)->Unit) = with(itemView){
            textView_teamA.text = partido.equipoA
            textView_teamB.text = partido.equipoB
            setOnClickListener {
                clickListener(partido)
            }
        }

    }


}