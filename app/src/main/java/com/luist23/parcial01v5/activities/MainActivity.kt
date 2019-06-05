package com.luist23.parcial01v5.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.luist23.parcial01v5.R
import com.luist23.parcial01v5.adapters.PartidoAdapter
import com.luist23.parcial01v5.database.entities.Partido
import com.luist23.parcial01v5.viewmodels.PartidoViewModel
import kotlinx.android.synthetic.main.content_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, LifecycleOwner {

    lateinit var adapter: PartidoAdapter
    lateinit var viewModel:PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            //adapter.updateList()
            val intent = Intent(this@MainActivity, NewPartidoActivity::class.java)
            startActivityForResult(intent, newPartidoActivityRequestCode)
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        bind()

    }

    companion object{
        const val newPartidoActivityRequestCode = 1
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun bind(){
        adapter= PartidoAdapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        rv_repo.apply {
            adapter=this@MainActivity.adapter
            layoutManager= LinearLayoutManager(this@MainActivity)
        }
        viewModel.nuke()
        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })

        /*btn_add.setOnClickListener {
            viewModel.insert(GithubRepo((et_repo.text.toString())))
        }*/
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == newPartidoActivityRequestCode && resultCode == Activity.RESULT_OK){
            data?.let {
                var fecha = Date(intent.getStringExtra("año").toInt(),
                    intent.getStringExtra("mes").toInt(),intent.getStringExtra("dia").toInt(),
                    intent.getStringExtra("hora").toInt(),intent.getStringExtra("minutos").toInt())
                var ganador = if (intent.getStringExtra("scoreA").toInt() > intent.getStringExtra("scoreB").toInt()){
                    intent.getStringExtra("equipoA")
                }else{
                    intent.getStringExtra("equipoB")
                }
                var partido = Partido(adapter.itemCount,intent.getStringExtra("equipoA"),
                    intent.getStringExtra("equipoB"),intent.getStringExtra("scoreA").toInt(),
                    intent.getStringExtra("scoreB").toInt(),
                    fecha.time.toInt(),ganador)
                //partido.equipoA=
                viewModel.insert(partido)
            }
        }
    }
}


