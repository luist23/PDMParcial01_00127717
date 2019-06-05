package com.luist23.parcial01v5

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luist23.parcial01v5.viewmodels.PartidoViewModel
import kotlinx.android.synthetic.main.fragment_equipo_a.*
import kotlinx.android.synthetic.main.fragment_equipo_a.bt_team_a_2_p
import kotlinx.android.synthetic.main.fragment_equipo_a.bt_team_a_3_p
import kotlinx.android.synthetic.main.fragment_equipo_a.bt_team_a_free_throw
import kotlinx.android.synthetic.main.fragment_equipo_a.tv_score_team_a
import kotlinx.android.synthetic.main.fragment_equipo_a.tv_teamA_name
import kotlinx.android.synthetic.main.fragment_equipo_a.view.*
import kotlinx.android.synthetic.main.partido_cardview.view.*


class EquipoAFragment() : Fragment() {
    var score: Int? = null
    private var name: String? = null
    //private var listener: DetallesFragment.OnFragmentInteractionListener? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =  inflater.inflate(R.layout.fragment_equipo_a, container, false).apply {
        tv_teamA_name.text = name
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
