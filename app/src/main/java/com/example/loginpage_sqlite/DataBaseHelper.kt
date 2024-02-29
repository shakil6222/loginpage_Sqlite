package com.example.loginpage_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context ):
SQLiteOpenHelper(context,DATABASE_NAME,null, DATABASE_VERSION){

    companion object{
        private const val DATABASE_VERSION = 1
        private const val  DATABASE_NAME = "edugaon"
        private const val TABLE_NAME = "users"
        private const val  column_id = "id"
        private const val  column_name = "name"
        private const val  column_email = "email"
        private const val  column_password = "password"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME" +
                        "($column_id text," +
                        "$column_name text," +
                        "$column_email text," +
                        "$column_password text)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addUser(name: String, email: String, password: String):Long {
        val db = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(column_id, name[0].toString())
        contentValue.put(column_name,name)
        contentValue.put(column_email,email)
        contentValue.put(column_password,password)
        val result = db.insert(TABLE_NAME,null,contentValue)
        db.close()
        return result

    }

    fun cheakUser(emai: String, password: String):Boolean{
        val db = this.readableDatabase
        val query = " SELECT * FROM $TABLE_NAME WHERE $column_email=? AND $column_password=?"
        val curser = db.rawQuery(query, arrayOf(emai , password))
        val count = curser.count
        curser.close()
        return count > 0
    }
}