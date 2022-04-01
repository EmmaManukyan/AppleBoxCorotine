package com.example.appleboxcorotine

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*

class SecondFragment : Fragment() {
    lateinit var textCount: TextView
    lateinit var btnAdd: Button
    lateinit var btnRemove: Button
    lateinit var btnReset: Button
    private var a = 0
    private var min = 0
    private var max = 0
    var isTrue = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textCount = view.findViewById(R.id.tv_count)
        btnAdd = view.findViewById(R.id.btn_add)
        btnRemove = view.findViewById(R.id.btn_remove)
        btnReset = view.findViewById(R.id.btn_reset)
        textCount.text = arguments?.getString("Min")
        a = textCount.text.toString().toInt()
        min = a.toInt()
        max =  arguments?.getString("Max").toString().toInt()
        GlobalScope.launch(Dispatchers.Default) {
            myThread()
        }

    }



    suspend fun myThread(){
        withContext(Dispatchers.Main){
            btnAdd.setOnClickListener {
                if (a>=max){
                    btnReset.visibility = View.VISIBLE

                }else{
                    Thread.sleep(3000)
                    a++
                    textCount.text = a.toString()
                }
            }
            btnRemove.setOnClickListener {
                if (a<=min){
                    btnReset.visibility = View.VISIBLE
                }else{
                    Thread.sleep(3000)
                    a--
                    textCount.text = a.toString()
                }
            }
            btnReset.setOnClickListener {
                a = min
                btnReset.visibility = View.GONE
            }
        }
    }
}