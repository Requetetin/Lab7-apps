package com.example.lab6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.lab6.databinding.FragmentQuestionBinding
import com.example.lab6.databinding.FragmentStartBinding
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [QuestionFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {

    private var r: Resultado?=null
    private var q: Encuesta?=null



    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentQuestionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_question , container, false
        )
        r= ViewModelProviders.of(activity!!).get(Resultado::class.java)
        q= ViewModelProviders.of(activity!!).get(Encuesta::class.java)
        binding.hinted="Ingrese su respuesta"
        binding.text="Next"

        binding.question= q!!.getFirst()

        binding.button.setOnClickListener(){
            r!!.plusRespuestas(binding.editText2.text.toString())
            r!!.setInmediata(binding.editText2.text.toString())
            try{
                binding.question= q!!.getNext()
            }catch (e: Exception){
                view!!.findNavController().navigate(R.id.action_questionFragment_to_ratingFragment)
            }

        }





        return binding.root
    }

}
