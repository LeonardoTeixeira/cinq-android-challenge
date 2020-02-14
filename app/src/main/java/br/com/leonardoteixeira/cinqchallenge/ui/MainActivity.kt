package br.com.leonardoteixeira.cinqchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.leonardoteixeira.cinqchallenge.R
import br.com.leonardoteixeira.cinqchallenge.adapters.PeopleAdapter
import br.com.leonardoteixeira.cinqchallenge.models.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainViewInterface {

    lateinit var adapter: PeopleAdapter
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupMVP()
        setupViews()
        getPeopleList()
    }

    private fun setupMVP() {
        mainPresenter = MainPresenter(this, this)
    }

    private fun setupViews() {
        rv_people.layoutManager = LinearLayoutManager(this)
    }

    private fun getPeopleList() {
        displayProgressBar()
        mainPresenter.getPeople()
    }

    override fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    override fun displayProgressBar() {
        pb_people.visibility = View.VISIBLE
        tv_no_people.visibility = View.GONE
        rv_people.visibility = View.GONE
    }

    override fun displayPeople(people: List<Person>) {
        pb_people.visibility = View.GONE
        tv_no_people.visibility = View.GONE
        rv_people.visibility = View.VISIBLE

        adapter = PeopleAdapter(people, this)
        rv_people.adapter = adapter
    }

    override fun displayNoPeople() {
        pb_people.visibility = View.GONE
        tv_no_people.visibility = View.VISIBLE
        rv_people.visibility = View.GONE
    }

    override fun displayError(error: String) {
        showToast(error)
    }
}
