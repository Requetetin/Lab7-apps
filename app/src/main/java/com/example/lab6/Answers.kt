package com.example.lab6

class Answers{
    var id : Int =0;
    var firstAnswer :String =""
    var ratingStar : Double = 0.0
    private var data: DataSource?=null

    constructor(firstAnswer:String, ratingStar: Double){
        this.firstAnswer = firstAnswer
        this.ratingStar = ratingStar
    }

    constructor(){

    }


}