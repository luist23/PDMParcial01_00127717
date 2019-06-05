package com.luist23.parcial01v5.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luist23.parcial01v5.EquipoAFragment
import com.luist23.parcial01v5.R
import kotlinx.android.synthetic.main.activity_partido.*

class PartidoActivity : AppCompatActivity() {

    private lateinit var teamAFragment : EquipoAFragment
    private lateinit var teamBFragment : EquipoAFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partido)

        teamAFragment = EquipoAFragment.newInstance(intent.getStringExtra("name"),0)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_team_a,teamAFragment).commit()

        teamBFragment = EquipoAFragment.newInstance(intent.getStringExtra("name"),0)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_team_b,teamBFragment).commit()

        intent.putExtra("scoreA",teamAFragment.score)
        intent.putExtra("scoreB",teamAFragment.score)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
