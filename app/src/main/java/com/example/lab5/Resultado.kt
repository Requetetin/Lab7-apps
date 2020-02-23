package com.example.lab5

class Resultado {
    private var rating = 0
    private var cantidad = 0
    private var respuestas = ""

    fun plusRating(a: Int){
        rating = rating + a
        cantidad ++
    }

    fun plusRespuestas(s: String){
        respuestas = respuestas + s +", "
    }

    fun getRespuestas(): String{
        return respuestas
    }

    fun getRating(): String{
        val s = rating/cantidad
        return s.toString()
    }

    fun getEncuestas(): String{
        return cantidad.toString()
    }

}