package com.luist23.parcial01v5

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detalles.view.*
import java.util.*


class DetallesFragment : Fragment() {
    private var fecha : Int? = null
    private var scoreA : Int? = null
    private var scoreB : Int? = null
    private var nameA : String? = null
    private var nameB : String? = null
    private var win : String? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalles, container, false).apply {
            var date = Date(fecha!!.toLong())
            det_año.text= date.year.toString()
            det_dia.text= date.day.toString()
            det_mes.text= date.month.toString()
            det_hora.text= date.hours.toString()
            det_minuto.text= date.minutes.toString()

            det_team_a.text=nameA
            det_team_b.text=nameB
            det_team_a_score.text=scoreA.toString()
            det_team_b_score.text=scoreB.toString()
            det_team_win.text=win

        }
    }








    companion object {

        @JvmStatic
        fun newInstance(nameA: String,nameB: String, scoreA : Int, scoreB : Int, fecha:Int,win:String) =
            DetallesFragment().apply {
                this.scoreA = scoreA
                this.scoreB = scoreB
                this.nameA = nameA
                this.nameB = nameB
                this.fecha =fecha
                this.win=win

            }
    }
}
