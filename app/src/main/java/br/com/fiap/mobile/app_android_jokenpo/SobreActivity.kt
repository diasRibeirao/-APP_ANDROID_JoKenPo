package br.com.fiap.mobile.app_android_jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

class SobreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        val imageView: ImageView = findViewById(R.id.image_view)

        val url = "https://media.istockphoto.com/photos/childs-hands-making-sign-as-rock-paper-and-scissors-picture-id829562356?b=1&k=20&m=829562356&s=612x612&w=0&h=FHSDpqqMqQD-d_uBnebpUhVomrWjR4qdmImuGpIAgD8="
        Picasso.get().load(url).into(imageView);

    }
}