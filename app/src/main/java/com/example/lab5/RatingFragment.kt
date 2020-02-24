package com.example.lab5

import android.content.Context
import android.media.Rating
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.lab5.databinding.FragmentQuestionBinding
import com.example.lab5.databinding.FragmentRatingBinding

class RatingFragment : Fragment() {


    private var r: Resultado?=null



    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentRatingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_rating , container, false
        )
        r= ViewModelProviders.of(activity!!).get(Resultado::class.java)
        binding.textIn="Que le parecio el servicio?"
        binding.butText="Siguiente"
        var rate: Float

        binding.button2.setOnClickListener {
            rate = binding.ratingBar.rating
            r!!.plusRating(rate)
            view!!.findNavController().navigate(R.id.action_ratingFragment_to_resultFragment)
        }








        return binding.root
    }

}