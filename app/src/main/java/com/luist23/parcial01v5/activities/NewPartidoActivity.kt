package com.luist23.parcial01v5.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.luist23.parcial01v5.R
import com.luist23.parcial01v5.database.entities.Partido
import com.luist23.parcial01v5.viewmodels.PartidoViewModel
import kotlinx.android.synthetic.main.activity_new_partido.*
import java.util.*

class NewPartidoActivity : AppCompatActivity() {
    lateinit var viewModel: PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_partido)

        viewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        bt_iniciar_partido.setOnClickListener {
            if(et_equipo_A.text.isEmpty() or et_equipo_B.text.isEmpty() or et_fecha_año.text.isEmpty() or et_fecha_dia.text.isEmpty() or et_fecha_hora.text.isEmpty() or et_fecha_mes.text.isEmpty() or et_fecha_minutos.text.isEmpty()){
                Toast.makeText(this,"no se completaron todos los campos",Toast.LENGTH_LONG).show()
            }
            else{
                viewModel.insert(Partido()
            }
        }

    }


}
