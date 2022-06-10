package com.example.anisound

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.anisound.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var song: MediaPlayer
    private lateinit var listAnimals: Map<ImageButton, Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Inflamos la vista
        setContentView(binding.root) // Seteamos el layout
        createSounds() //Crea el mapa [ImageButton -> Canción]
        pressButton()  // Reproducir en base al ImageButton Presionado
        song = MediaPlayer() // Inicialización de SONG
    }

    // Crea el mapa [ImageButton -> Canción]
    private fun createSounds() = with(binding) {
        listAnimals = mapOf(
            imgCaballo to R.raw.caballo,
            imgElefante to R.raw.elefante,
            imgGallo to R.raw.gallo,
            imgGato to R.raw.gato,
            imgMono to R.raw.mono,
            imgPato to R.raw.pato,
            imgPerro to R.raw.perro,
            imgRana to R.raw.rana,
            imgVaca to R.raw.vaca
        )
    }

    // Obtiene el valor de la canción
    private fun getValue(key: ImageButton): Int = listAnimals.getValue(key)

    // En base al ImageButton presionado se reproduce la canción
    private fun pressButton() = with(binding) {
        imgCaballo.setOnClickListener { playSound(imgCaballo) } // Reproduce la canción del caballo
        imgElefante.setOnClickListener { playSound(imgElefante) } // Reproduce la canción del elefante
        imgGallo.setOnClickListener { playSound(imgGallo) } // Reproduce la canción del gallo
        imgGato.setOnClickListener { playSound(imgGato) } // Reproduce la canción del gato
        imgMono.setOnClickListener { playSound(imgMono) } // Reproduce la canción del mono
        imgPato.setOnClickListener { playSound(imgPato) } // Reproduce la canción del pato
        imgPerro.setOnClickListener { playSound(imgPerro) } // Reproduce la canción del perro
        imgRana.setOnClickListener { playSound(imgRana) } // Reproduce la canción de la rana
        imgVaca.setOnClickListener { playSound(imgVaca) } // Reproduce la canción de la vaca
    }

    // Reproduce la canción seleccionada en base al ImageButton presionado
    private fun playSound(imageButton: ImageButton) {
        if (this::song.isInitialized && song.isPlaying) song.pause(); song.seekTo(0) // Pausa la canción actual
        song = MediaPlayer.create(this, getValue(imageButton)) // Crea la canción
        song.start() // Reproduce la canción
    }
}