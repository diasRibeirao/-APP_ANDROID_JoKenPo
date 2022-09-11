package br.com.fiap.mobile.app_android_jokenpo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.mobile.app_android_jokenpo.databinding.ActivityJogoFimBinding
import br.com.fiap.mobile.app_android_jokenpo.firestore.Ranking
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore

class JogoFimActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJogoFimBinding

    private val database = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityJogoFimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contPlacarUsuario = intent.getIntExtra("contPlacarUsuario",0)
        val contPlacarCPU = intent.getIntExtra("contPlacarCPU",0)

        binding.txtUsuarioResultado.text = contPlacarUsuario.toString()
        binding.txtCPUResultado.text = contPlacarCPU.toString()

        binding.btnJogarNovamente.setOnClickListener {
            val nomeUsuario = binding.txtNomeJogador.text.toString().trim()
            if (nomeUsuario.isEmpty()) {
                binding.txtMsg.text = "Informe o seu nome!"
            } else {
                this.salvaRanking(nomeUsuario, contPlacarUsuario)
                startActivity(Intent(this, JogarActivity::class.java))
                finish()
            }
        }

        binding.btnTelaPrincipal.setOnClickListener {
            val nomeUsuario = binding.txtNomeJogador.text.toString().trim()
            this.salvaRanking(nomeUsuario, contPlacarUsuario)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun salvaRanking(nomeUsuario: String, contPlacarUsuario: Int) {
        var ranking = Ranking(nomeUsuario, contPlacarUsuario)
        database.collection("ranking") .add(ranking)
    }
}