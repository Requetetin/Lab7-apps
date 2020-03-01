package com.example.lab6

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.lab6.databinding.FragmentAddBinding
import com.example.lab6.databinding.FragmentQuestionBinding
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment() {
    private var q: Encuesta?=null


    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentAddBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add , container, false
        )
        q= ViewModelProviders.of(activity!!).get(Encuesta::class.java)

        binding.hintText="Ingrese nueva pregunta"


        setHasOptionsMenu(true)







        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        q?.addQuestion(updateText())
        view!!.findNavController().navigate(R.id.action_addFragment_to_startFragment)

        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
    }

    fun updateText():String {


        return editText.text.toString()


    }
}
