package br.com.leonardoteixeira.cinqchallenge.models

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("disclosableInfo") val disclosableInfo: String
)
