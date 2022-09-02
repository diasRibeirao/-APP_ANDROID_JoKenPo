package br.com.fiap.mobile.app_android_jokenpo

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class JogarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogar)
    }

    fun selecionarPedra(view: View?) {
        this.opcaoSelecionada("Pedra")
    }

    fun selecionarPapel(view: View?) {
        this.opcaoSelecionada("Papel")
    }

    fun selecionarTesoura(view: View?) {
        this.opcaoSelecionada("Tesoura")
    }

    fun opcaoSelecionada(escolhaUsuario: String) {
        val textoResultado = findViewById<TextView>(R.id.textResultado)
        val placarUsuario = findViewById<TextView>(R.id.placarUsuario)
        val placarCPU = findViewById<TextView>(R.id.placarCPU)
        textoResultado.text = "Escolha uma opção abaixo"
        var contPlacarUsuario = Integer.valueOf(placarUsuario.text.toString())
        var contPlacarCPU = Integer.valueOf(placarCPU.text.toString())
        val imageEscolhaCPU = findViewById<ImageView>(R.id.imageEscolhaCPU)
        val imageResultadoJogador = findViewById<ImageView>(R.id.imageEscolhaJogador)
        val jogadas = arrayOf("Pedra", "Papel", "Tesoura")
        val indice = Random().nextInt(3)
        val escolhaApp = jogadas[indice]
        when (escolhaApp) {
            "Pedra" -> imageEscolhaCPU.setImageResource(R.drawable.rock)
            "Papel" -> imageEscolhaCPU.setImageResource(R.drawable.paper)
            "Tesoura" -> imageEscolhaCPU.setImageResource(R.drawable.scissor)
        }

        when (escolhaUsuario) {
            "Pedra" -> imageResultadoJogador.setImageResource(R.drawable.rock)
            "Papel" -> imageResultadoJogador.setImageResource(R.drawable.paper)
            "Tesoura" -> imageResultadoJogador.setImageResource(R.drawable.scissor)
        }

        //VITORIAS DO USUARIO
        if (escolhaUsuario == "Papel" && escolhaApp == "Pedra" || escolhaUsuario == "Pedra" && escolhaApp == "Tesoura" || escolhaUsuario == "Tesoura" && escolhaApp == "Papel") {
            contPlacarUsuario = contPlacarUsuario + 1
            placarUsuario.text = contPlacarUsuario.toString()
            if (contPlacarUsuario == 9) {
                textoResultado.text = "Parabens Você venceu !"
                placarUsuario.text = "0"
                placarCPU.text = "0"
            }
        } else if (escolhaApp == escolhaUsuario) {
            textoResultado.text = "Empate !"
        } else {
            contPlacarCPU = contPlacarCPU + 1
            placarCPU.text = contPlacarCPU.toString()
            if (contPlacarCPU == 9) {
                textoResultado.text = "Você perdeu ! ,Tente novamente"
                placarCPU.text = "0"
                placarUsuario.text = "0"
            }
        }
    }
}