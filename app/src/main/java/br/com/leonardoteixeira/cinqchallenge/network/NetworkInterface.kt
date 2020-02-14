package br.com.leonardoteixeira.cinqchallenge.network

import br.com.leonardoteixeira.cinqchallenge.models.Person
import io.reactivex.Observable
import retrofit2.http.GET

interface NetworkInterface {
    @GET("people")
    fun getPeople(): Observable<List<Person>>
}
