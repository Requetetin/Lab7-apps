package com.example.lab6

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "AnswerDB"
val TABLE_NAME = "Answers"
val COL_TEXT_ANS = "TextAns"
val COL_RATING = "Rating"
val COL_ID = "id"

class DataBaseHandler(var context: Context?): SQLiteOpenHelper(context, DATABASE_NAME, null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME+" ("+
                COL_ID +" INTEGER  PRIMARY KEY AUTOINCREMENT,"+
                COL_TEXT_ANS + " VARCHAR(256),"+
                COL_RATING + " INTEGER)";

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertData(answers: Answers){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_TEXT_ANS, answers.firstAnswer)
        cv.put(COL_RATING, answers.ratingStar)
        db.insert(TABLE_NAME, null, cv)

    }

    fun readData(): MutableList<Answers>{
        var list: MutableList<Answers> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from "+ TABLE_NAME
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()){
            do{
                var answers = Answers()
                answers.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                answers.firstAnswer = result.getString(result.getColumnIndex(COL_TEXT_ANS))
                answers.ratingStar = result.getString(result.getColumnIndex(COL_RATING)).toDouble()
                list.add(answers)
            }while(result.moveToNext())
        }


        result.close()
        db.close()

        return list
    }

    fun deleteData(){
        val db = this.writableDatabase

        db.delete(TABLE_NAME, null, null)

        db.close()
    }

}