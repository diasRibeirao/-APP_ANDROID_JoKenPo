package br.com.fiap.mobile.app_android_jokenpo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun abrirJogar(view: View?) {
        val proximaTela = Intent(this, JogarActivity::class.java)
        startActivity(proximaTela)
        finish()
    }

    fun abrirRanking(view: View?) {
        val proximaTela = Intent(this, RankingActivity::class.java)
        startActivity(proximaTela)
        finish()
    }

    fun abrirSobre(view: View?) {
        val proximaTela = Intent(this, SobreActivity::class.java)
        startActivity(proximaTela)
        finish()
    }

    fun sairApp(view: View?) {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }


}