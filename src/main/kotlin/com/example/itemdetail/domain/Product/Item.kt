package com.example.itemdetail.domain.model

data class Item(
        val id: String,
        val title: String,
        val description: String,
        val price: Double,
        val currency: String,
        val pictures: List<String>
)