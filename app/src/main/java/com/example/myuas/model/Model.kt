package com.example.myuas.model

class Model (
    val book : List<Data>
) {
    data class Data (
        val author:String?,
        val title:String?,
        val category:String?
        )
}