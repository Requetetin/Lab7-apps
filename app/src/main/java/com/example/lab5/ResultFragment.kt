package com.example.lab5

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lab5.databinding.FragmentQuestionBinding
import com.example.lab5.databinding.FragmentResultBinding
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ResultFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {


    val r = Resultado()


    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentResultBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_result , container, false
        )
        val s:String = "Rating: " + r.getRating()
        val t:String = "Encuestas: " + r.getEncuestas()
        binding.rating = s
        binding.encuestas = t



        binding.button3.setOnClickListener(){
            view!!.findNavController().navigate(R.id.action_resultFragment_to_questionFragment)
        }

        binding.button4.setOnClickListener(){
            Toast.makeText(activity, r.getRespuestas(), Toast.LENGTH_LONG).show()
        }


        return binding.root
    }

}