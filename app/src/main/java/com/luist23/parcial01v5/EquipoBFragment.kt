package com.luist23.parcial01v5

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luist23.parcial01v5.viewmodels.PartidoViewModel
import kotlinx.android.synthetic.main.fragment_equipo_b.*
import kotlinx.android.synthetic.main.fragment_equipo_b.tv_score_team_b
import kotlinx.android.synthetic.main.fragment_equipo_b.tv_team_name_b
import kotlinx.android.synthetic.main.fragment_equipo_b.view.*


class EquipoBFragment : Fragment() {
    var score: Int? = null
    private var name: String? = null
    //private var listener: DetallesFragment.OnFragmentInteractionListener? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =  inflater.inflate(R.layout.fragment_equipo_b, container, false).apply {

        tv_team_name_b.text= name
        tv_score_team_b.text = PartidoViewModel.scoreB.value.toString()
    }


    companion object {
        //var score = 0


        fun newInstance(name: String, newscore: Int) =
            EquipoBFragment().apply {
                this.name = name
                this.score = newscore

            }
    }
}
