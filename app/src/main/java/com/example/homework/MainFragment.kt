package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    var num1:Int = 0
    var num2:Int = 0
    var answer = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var score:Int = 0
        question()

        buttonSubmit.setOnClickListener {
            if(editAnswer.text.toString() == answer.toString()){
                score += 1
                editAnswer.text?.clear()
                question()
            }
            else{
                //Dapatkan action yg ingin dijalankan
                val action = MainFragmentDirections.actionResultFragment(score)
                //Jalankan action tsb
                Navigation.findNavController(it).navigate(action)
            }

        }
    }

    fun question(){
        num1 = (0..20).random()
        num2 = (0..20).random()

        textNum1.text = num1.toString()
        textNum2.text = num2.toString()

        answer = num1 + num2
    }
}