package com.example.lab5

class Encuesta {

    private var count = 0
    private val questions: MutableList<String> = mutableListOf<String>("Tiene duda o pregunta?")



    fun getFirst(): String {
        count ++
        return questions.get(0)
    }

    fun getNext(): String {
        count ++
        return questions.get(count)
    }

    fun addQuestion(s: String){
        questions.add(s)
    }
}