package com.luist23.parcial01v5.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luist23.parcial01v5.DetallesFragment
import com.luist23.parcial01v5.R
import com.luist23.parcial01v5.database.entities.Partido
import com.luist23.parcial01v5.viewmodels.PartidoViewModel
import kotlinx.android.synthetic.main.activity_detalles.*

class DetallesActivity () : AppCompatActivity() {
    private lateinit var teamAFragment : DetallesFragment
    private lateinit var partido : Partido

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        val v = PartidoViewModel.partido.value!!

        teamAFragment = DetallesFragment.newInstance(
            v.equipoA,v.equipoB,v.puntosA,
            v.puntosB,v.fecha,v.ganador)
        supportFragmentManager.beginTransaction().replace(R.id.detalle_fragment_reserved,teamAFragment).commit()

        ok_detalles.setOnClickListener {
            finish()
        }


    }
}
