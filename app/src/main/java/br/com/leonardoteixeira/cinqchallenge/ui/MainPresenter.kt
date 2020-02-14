package br.com.leonardoteixeira.cinqchallenge.ui

import android.content.Context
import br.com.leonardoteixeira.cinqchallenge.R
import br.com.leonardoteixeira.cinqchallenge.models.Person
import br.com.leonardoteixeira.cinqchallenge.network.NetworkClient
import br.com.leonardoteixeira.cinqchallenge.network.NetworkInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


class MainPresenter(val context: Context, val mvi: MainViewInterface): MainPresenterInterface {

    override fun getPeople() {
        getObservable().subscribeWith(getObserver())
    }

    fun getObservable(): Observable<List<Person>> {
        return NetworkClient.getRetrofit()!!.create(NetworkInterface::class.java)
            .getPeople()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getObserver(): DisposableObserver<List<Person>?>? {
        return object : DisposableObserver<List<Person>?>() {
            override fun onNext(people: List<Person>) {
                mvi.displayPeople(people)
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
                mvi.displayError(context.getString(R.string.people_fetch_error))
            }

            override fun onComplete() {
            }
        }
    }
}
