package com.example.todojuntofunciona

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView

class FirstFragmentCommons : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.activity_first_fragment_commons, container, false)
        val textView = view.findViewById<TextView>(R.id.tvFragment)
        textView.text = "Soy el Primer Fragmento"
        return view
    }
}