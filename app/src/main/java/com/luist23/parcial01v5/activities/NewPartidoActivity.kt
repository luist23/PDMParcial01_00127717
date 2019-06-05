package com.luist23.parcial01v5.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.luist23.parcial01v5.R
import com.luist23.parcial01v5.adapters.PartidoAdapter
import com.luist23.parcial01v5.database.entities.Partido
import com.luist23.parcial01v5.viewmodels.PartidoViewModel
import kotlinx.android.synthetic.main.activity_new_partido.*
import java.util.*

class NewPartidoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_partido)

        bt_iniciar_partido.setOnClickListener {




            if(et_equipo_A.text.isEmpty() or et_equipo_B.text.isEmpty() or et_fecha_año.text.isEmpty() or et_fecha_dia.text.isEmpty() or et_fecha_hora.text.isEmpty() or et_fecha_mes.text.isEmpty() or et_fecha_minutos.text.isEmpty()){
                Toast.makeText(this,"no se completaron todos los campos",Toast.LENGTH_LONG).show()
            }
            else{
                //val intent = Intent(this@NewPartidoActivity,PartidoActivity::class.java)

                PartidoViewModel.teamA.value = et_equipo_A.text.toString()
                PartidoViewModel.teamB.value = et_equipo_B.text.toString()
                PartidoViewModel.fecha.value = Date(et_fecha_año.text.toString().toInt(),et_fecha_mes.text.toString().toInt()
                    ,et_fecha_dia.text.toString().toInt(),et_fecha_hora.text.toString().toInt(),et_fecha_minutos.text.toString().toInt()).time.toInt()

                PartidoViewModel.scoreA.value = 0
                PartidoViewModel.scoreB.value = 0


                //setResult(Activity.RESULT_OK, Intent())


                //finish()
                var intent = Intent(this@NewPartidoActivity,PartidoActivity::class.java
                )

                startActivityForResult(intent, MainActivity.newPartidoActivityRequestCode)



            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        setResult(Activity.RESULT_OK, Intent())

        finish()
    }


}
