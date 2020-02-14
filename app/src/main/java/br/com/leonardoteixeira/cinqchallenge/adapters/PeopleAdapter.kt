package br.com.leonardoteixeira.cinqchallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.leonardoteixeira.cinqchallenge.R
import br.com.leonardoteixeira.cinqchallenge.models.Person
import kotlinx.android.synthetic.main.row_people.view.*

class PeopleAdapter(val people: List<Person>, val context: Context): RecyclerView.Adapter<PeopleAdapter.PeopleHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeopleHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.row_people, parent, false)
        return PeopleHolder(v)
    }

    override fun onBindViewHolder(holder: PeopleHolder, position: Int) {
        val person = people[position]
        holder.bindView(person)
    }

    override fun getItemCount(): Int {
        return people.size
    }

    inner class PeopleHolder(v: View) : ViewHolder(v) {
        fun bindView(person: Person) {
            val name = itemView.tv_person_name
            val disclosableInfo = itemView.tv_person_disclosable_info

            name.text = person.name
            disclosableInfo.text = person.disclosableInfo
        }
    }
}
