package com.example.lab5

import android.content.Context
import android.media.Rating
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lab5.databinding.FragmentQuestionBinding
import com.example.lab5.databinding.FragmentRatingBinding

class RatingFragment : Fragment() {

    val r = Resultado()


    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentRatingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_rating , container, false
        )
        binding.textIn="Que le parecio el servicio?"
        binding.butText="Siguiente"

        binding.button2.setOnClickListener(){
            r.plusRating(binding.ratingBar.numStars)
            view!!.findNavController().navigate(R.id.action_ratingFragment_to_resultFragment)
        }








        return binding.root
    }

}