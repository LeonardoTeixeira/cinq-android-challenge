package br.com.leonardoteixeira.cinqchallenge.ui

import br.com.leonardoteixeira.cinqchallenge.models.Person

interface MainViewInterface {
    fun showToast(s: String)
    fun displayProgressBar()
    fun displayPeople(people: List<Person>)
    fun displayNoPeople()
    fun displayError(error: String)
}
