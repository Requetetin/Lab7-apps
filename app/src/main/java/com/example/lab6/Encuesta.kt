package com.example.lab6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Encuesta : ViewModel() {

    val message = MutableLiveData<Any>()

    private var count = 0
    private val questions: MutableList<String> = mutableListOf<String>("Tiene duda o pregunta?")

    fun setMsgCommunicator(msg:String){
        message.setValue(msg)
    }

    fun getFirst(): String {
        count ++
        return questions.get(0)
    }

    fun getNext(): String {
        val s = questions.get(count)
        count ++
        return s
    }

    fun addQuestion(s: String){
        questions.add(s)
    }
}