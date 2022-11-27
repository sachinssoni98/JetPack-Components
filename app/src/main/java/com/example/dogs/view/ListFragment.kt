package com.example.dogs.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.R
import com.example.dogs.viewmodel.ListViewModel

class ListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val dogsListAdapter = DogsListAdapter(arrayListOf())
    private lateinit var recyclerView: RecyclerView
    private lateinit var error_msg: TextView
    private lateinit var loading: Spinner
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = view.findViewById(R.id.dogs_list)
        error_msg = view.findViewById(R.id.error_msg)
        loading = view.findViewById(R.id.loading)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this)[ListViewModel::class.java]
        viewModel.refresh()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogsListAdapter
        }
        observeViewModel()


    }

    private fun observeViewModel() {
        viewModel.dogs.observe(viewLifecycleOwner) { dogs ->
            dogs?.let {
                recyclerView.visibility = View.VISIBLE
                dogsListAdapter.updateDogList(dogs)
            }
        }
        viewModel.dogLoadError.observe(viewLifecycleOwner) { isError ->
            isError?.let {
                error_msg.visibility = if (it) View.VISIBLE else View.GONE
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            isLoading?.let {
                loading.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    error_msg.visibility = View.GONE
                    recyclerView.visibility = View.GONE
                }
            }
        }
    }
}