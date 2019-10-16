package com.example.companylist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CompaniesRecyclerViewAdapter(private val companies: List<Company>) :
        RecyclerView.Adapter<CompaniesRecyclerViewAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_company, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(companies[position])
    }

    override fun getItemCount(): Int = companies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvDescription: TextView = itemView.findViewById(R.id.tv_description)
        private val ivPhoto: ImageView = itemView.findViewById(R.id.iv_photo)

        fun bind(company: Company) {
            tvName.text = company.name
            ivPhoto.setImageResource(company.imgRes)
            tvDescription.text = company.description

            itemView.setOnClickListener {
                Intent(context, DetailActivity::class.java).also {
                    it.putExtra("company", company)
                    context.startActivity(it)
                }
            }
        }
    }
}