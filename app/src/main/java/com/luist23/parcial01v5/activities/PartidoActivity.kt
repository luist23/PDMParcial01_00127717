package com.luist23.parcial01v5.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.luist23.parcial01v5.EquipoAFragment
import com.luist23.parcial01v5.EquipoBFragment
import com.luist23.parcial01v5.R
import com.luist23.parcial01v5.viewmodels.PartidoViewModel
import kotlinx.android.synthetic.main.activity_partido.*
import kotlinx.android.synthetic.main.fragment_equipo_a.*
import kotlinx.android.synthetic.main.fragment_equipo_b.*

class PartidoActivity : AppCompatActivity() {



    private lateinit var teamAFragment : EquipoAFragment
    private lateinit var teamBFragment : EquipoBFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partido)

        teamAFragment = EquipoAFragment.newInstance(PartidoViewModel.teamA.value.toString(),0)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_team_a,teamAFragment).commit()


        teamBFragment = EquipoBFragment.newInstance(PartidoViewModel.teamB.value.toString(),0)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_team_b,teamBFragment).commit()

                //tv_team_name_b.text=PartidoViewModel.teamB.value.toString()




        //configurar Boton
        bt_save_partido.setOnClickListener {
            setResult(
                Activity.RESULT_OK,
                Intent())
            finish()
        }
        //intent.putExtra("scoreA",teamAFragment.score)
        //intent.putExtra("scoreB",teambFragment.score)


    }

    fun free_throw(v : View){
        PartidoViewModel.scoreA.value = PartidoViewModel.scoreA.value?.plus(1)
        tv_score_team_a.text= PartidoViewModel.scoreA.value.toString()

    }
    fun twoA(v : View){
        PartidoViewModel.scoreA.value = PartidoViewModel.scoreA.value?.plus(2)
        tv_score_team_a.text= PartidoViewModel.scoreA.value.toString()

    }
    fun threeA(v : View){
        PartidoViewModel.scoreA.value = PartidoViewModel.scoreA.value?.plus(3)
        tv_score_team_a.text= PartidoViewModel.scoreA.value.toString()

    }

    fun free_throwB(v : View){
        PartidoViewModel.scoreB.value = PartidoViewModel.scoreB.value?.plus(1)
        tv_score_team_b.text= PartidoViewModel.scoreB.value.toString()

    }
    fun twoB(v : View){
        PartidoViewModel.scoreB.value = PartidoViewModel.scoreB.value?.plus(2)
        tv_score_team_b.text= PartidoViewModel.scoreB.value.toString()

    }
    fun threeB(v : View){
        PartidoViewModel.scoreB.value = PartidoViewModel.scoreB.value?.plus(3)
        tv_score_team_b.text= PartidoViewModel.scoreB.value.toString()

    }

    /*override fun onFragmentInteraction() {

        bt_team_a_free_throw.setOnClickListener {
            PartidoViewModel.scoreA.value = PartidoViewModel.scoreA.value?.plus(1)
            tv_score_team_a.text= PartidoViewModel.scoreA.value.toString()
        }
        bt_team_a_2_p.setOnClickListener {
            PartidoViewModel.scoreA.value = PartidoViewModel.scoreA.value?.plus(2)
            tv_score_team_a.text= PartidoViewModel.scoreA.value.toString()
        }
        bt_team_a_3_p.setOnClickListener {
            PartidoViewModel.scoreA.value = PartidoViewModel.scoreA.value?.plus(3)
            tv_score_team_a.text= PartidoViewModel.scoreA.value.toString()
        }
    }*/
}
