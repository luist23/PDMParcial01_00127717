package com.luist23.parcial01v5.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luist23.parcial01v5.DetallesFragment
import com.luist23.parcial01v5.R
import com.luist23.parcial01v5.database.entities.Partido
import com.luist23.parcial01v5.viewmodels.PartidoViewModel

class DetallesActivity (partido : Partido) : AppCompatActivity() {
    private lateinit var teamAFragment : DetallesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        val v = PartidoViewModel
        teamAFragment = DetallesFragment.newInstance(v.teamA.value.toString(),v.teamB.value.toString(),v.scoreA.value.toString().toInt(),
            v.scoreB.value.toString().toInt(),v.fecha.value.toString().toInt(),v.win.value.toString())
        supportFragmentManager.beginTransaction().replace(R.id.fragment_team_a,teamAFragment).commit()


    }
}
