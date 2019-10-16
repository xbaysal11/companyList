package com.example.companylist


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = CompaniesRecyclerViewAdapter(getCompaies().apply {})
    }

    private fun getCompaies() = arrayListOf(
            Company("Google", "Google Company", R.drawable.google),
            Company("Mozilla", "Mozilla Company", R.drawable.mozilla)
    )
}