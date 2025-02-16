package com.example.todojuntofunciona

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainCommons : AppCompatActivity() {

    private var isRotating = false
    private var imageAnimator: ObjectAnimator? = null
    private val itemList = mutableListOf("Elemento 1", "Elemento 2", "Elemento 3") // Lista inicial
    private lateinit var adapter: SimpleAdapterCommons // Adaptador de RecyclerView
    private var isFirstFragment = true // Para alternar entre fragmentos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_commons)

        // Ajustar el padding para System Bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainCommons)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Vincular vistas
        val button = findViewById<Button>(R.id.btnAction)
        val switchCompat = findViewById<SwitchCompat>(R.id.switchToggle)
        val imageView = findViewById<ImageView>(R.id.ivImage)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val titleTextView = findViewById<View>(R.id.tvTitle)
        val editText = findViewById<EditText>(R.id.etNewItem)
        val addButton = findViewById<Button>(R.id.btnAddItem)
        val fragmentButton = findViewById<Button>(R.id.btnToggleFragment)
        val btnReturn = findViewById<Button>(R.id.btnReturnCommons)

        // Inicialmente ocultar todos los elementos excepto el Switch
        //  button.visibility = View.GONE
        // imageView.visibility = View.GONE
        recyclerView.visibility = View.GONE
        //  titleTextView.visibility = View.GONE
        editText.visibility = View.GONE
        addButton.visibility = View.GONE
        //  fragmentButton.visibility = View.GONE

        // Configurar el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SimpleAdapterCommons(itemList)
        recyclerView.adapter = adapter

        // Configuración del SwitchCompat
        switchCompat.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // titleTextView.visibility = View.VISIBLE
                // button.visibility = View.VISIBLE
                //  imageView.visibility = View.VISIBLE
                recyclerView.visibility = View.VISIBLE
                editText.visibility = View.VISIBLE
                addButton.visibility = View.VISIBLE
                // fragmentButton.visibility = View.VISIBLE

                Toast.makeText(this, "Opciones habilitadas", Toast.LENGTH_SHORT).show()
            } else {
                // titleTextView.visibility = View.GONE
                // button.visibility = View.GONE
                // imageView.visibility = View.GONE
                recyclerView.visibility = View.GONE
                editText.visibility = View.GONE
                addButton.visibility = View.GONE
                // fragmentButton.visibility = View.GONE

                Toast.makeText(this, "Opciones deshabilitadas", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar el botón para controlar la rotación
        button.setOnClickListener {
            if (isRotating) {
                imageAnimator?.cancel()
                isRotating = false
                Toast.makeText(this, "Rotación detenida", Toast.LENGTH_SHORT).show()
            } else {
                imageAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f).apply {
                    duration = 1000
                    repeatCount = ObjectAnimator.INFINITE
                    repeatMode = ObjectAnimator.RESTART
                    start()
                }
                isRotating = true
                Toast.makeText(this, "Rotación iniciada", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar el botón para agregar texto a la lista
        addButton.setOnClickListener {
            val newItem = editText.text.toString().trim()
            if (newItem.isNotEmpty()) {
                itemList.add(newItem) // Agregar el texto a la lista
                adapter.notifyItemInserted(itemList.size - 1) // Actualizar la RecyclerView
                editText.text.clear() // Limpiar el campo de texto
                Toast.makeText(this, "Elemento agregado: $newItem", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Escribe algo antes de agregar", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar el botón para alternar fragmentos
        fragmentButton.setOnClickListener {
            val fragment: Fragment = if (isFirstFragment) {
                isFirstFragment = false
                FirstFragmentCommons()
            } else {
                isFirstFragment = true
                SecondFragmentCommons()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }

        btnReturn.setOnClickListener(View.OnClickListener {
            val intent = Intent(
                this@MainCommons,
                MainMenu::class.java
            )
            startActivity(intent)
            finish() // Cierra esta Activity
        })
    }
}