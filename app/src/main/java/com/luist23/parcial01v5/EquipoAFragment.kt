package com.luist23.parcial01v5

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_equipo_a.*


class EquipoAFragment : Fragment() {
    var score: Int? = null
    private var name: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bt_team_a_free_throw.setOnClickListener {
            score?.plus(1)
            tv_score_team_a.text= score.toString()
        }
        bt_team_a_2_p.setOnClickListener {
            score?.plus(2)
            tv_score_team_a.text= score.toString()
        }
        bt_team_a_3_p.setOnClickListener {
            score?.plus(3)
            tv_score_team_a.text= score.toString()
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_equipo_a, container, false)
    }


    companion object {
        //var score = 0

        @JvmStatic
        fun newInstance(name: String, newscore: Int) =
            EquipoAFragment().apply {
                this.name = name
                this.score = newscore

            }
    }
}
