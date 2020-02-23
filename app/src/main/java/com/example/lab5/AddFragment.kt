package com.example.lab5

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lab5.databinding.FragmentAddBinding
import com.example.lab5.databinding.FragmentQuestionBinding


class AddFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentAddBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add , container, false
        )
        binding.hintText="Ingrese nueva pregunta"





        return binding.root
    }
}
