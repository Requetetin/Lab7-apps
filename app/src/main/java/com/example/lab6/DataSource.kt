package com.example.lab6

class DataSource {


    companion object{
        val list = ArrayList<Results>()
        fun addData(encuesta: String, respuesta:String, rating:Double):ArrayList<Results>{
            list.add(
                Results(
                    encuesta, respuesta, rating
                )
            )
            return  list
        }
    }
}