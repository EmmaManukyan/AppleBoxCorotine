package com.example.appleboxcorotine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {
    lateinit var edtMin: EditText
    lateinit var edtMax: EditText
    lateinit var btnNext: Button
    val bundle = Bundle()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        edtMin = view.findViewById(R.id.edt_min)
        edtMax = view.findViewById(R.id.edt_max)
        btnNext = view.findViewById(R.id.btn_next)
        btnNext.setOnClickListener {
            if(edtMin.text.toString().toInt()<edtMax.text.toString().toInt()){
                bundle.putString("Min",edtMin.text.toString())
                bundle.putString("Max",edtMax.text.toString())
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment,bundle)
            }else{
                Toast.makeText(activity, "Minimum must be higher than maximum", Toast.LENGTH_SHORT).show()
            }
        }
    }
}