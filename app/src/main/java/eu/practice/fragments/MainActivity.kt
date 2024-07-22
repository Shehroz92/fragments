package eu.practice.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private var toolbar : Toolbar? = null
    private var btnFragA: Button? = null
    private var btnFragB: Button? = null
    private var btnFragC: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.fragmentToolbar)
        btnFragA = findViewById(R.id.btnFragA)
        btnFragB = findViewById(R.id.btnFragB)
        btnFragC= findViewById(R.id.btnFragC)
        setSupportActionBar(toolbar)

        loadFun(AFragment(),0)

        btnFragA?.setOnClickListener {
            loadFun(AFragment(),1)
        }

        btnFragB?.setOnClickListener {
          loadFun(BFragment(),1)
        }

        btnFragC?.setOnClickListener {
         loadFun(CFragment(),1)
        }

    }

    private fun loadFun(fragment : Fragment , flag :Int){

        val fm :FragmentManager = supportFragmentManager
        val ft :FragmentTransaction = fm.beginTransaction()
        if (flag == 0){
            ft.add(R.id.container , fragment)
        } else {
           ft.replace(R.id.container ,fragment)
        }

        ft.commit()
    }
}