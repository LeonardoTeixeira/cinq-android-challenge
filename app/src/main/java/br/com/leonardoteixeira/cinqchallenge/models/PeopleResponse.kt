package br.com.leonardoteixeira.cinqchallenge.models

import com.google.gson.annotations.SerializedName

class PeopleResponse(
    @SerializedName
    val people: List<Person>
)
