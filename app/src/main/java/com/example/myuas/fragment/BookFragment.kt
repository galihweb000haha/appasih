package com.example.myuas.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myuas.R
import com.example.myuas.api.BooksClient.instance
import com.example.myuas.model.BooksResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookFragment:Fragment() {
    private lateinit var titleView: TextView
    private lateinit var categoryView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBooks()

        titleView = view.findViewById(R.id.tv_title)
        categoryView = view.findViewById(R.id.tv_category)

    }

    private fun showBooks() {
        // Dipanggil RetrofitClient
        instance.getBooks().enqueue(object :
            Callback<ArrayList<BooksResponse>>{

            override fun onResponse(
                call: Call<ArrayList<BooksResponse>>,
                response: Response<ArrayList<BooksResponse>>
            ) {
                val bookRes: BooksResponse? = response.body()?.get(0)
                val title = bookRes?.title
                val category = bookRes?.category

                titleView.text = title
                categoryView.text = category

            }

            override fun onFailure(call: Call<ArrayList<BooksResponse>>, t: Throwable) {
                Toast.makeText(requireActivity(),"${t.message}",  Toast.LENGTH_SHORT).show()
            }

        })
    }

}