package com.example.lab6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Resultado : ViewModel() {

    val message = MutableLiveData<Any>()

    private var rating = 0.0f
    private var cantidad = 0
    private var respuestas = ""
    private var respuestainmediata=""

    fun setMsgCommunicator(msg:String){
        message.setValue(msg)
    }

    fun setInmediata(rsp: String){
        respuestainmediata = rsp
    }

    fun getInmediata():String{
        return respuestainmediata
    }

    fun plusRating(a: Float){
        rating += a
        cantidad ++
    }

    fun plusRespuestas(s: String){
        respuestas = respuestas + s +", "
    }

    fun getRespuestas(): String{
        return respuestas
    }

    fun getRating(): Float{
        return rating / cantidad
    }

    fun getEncuestas(): Int{
        return cantidad
    }

}