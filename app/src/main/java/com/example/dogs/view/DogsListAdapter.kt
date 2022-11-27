package com.example.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.R
import com.example.dogs.model.DogBreed

class DogsListAdapter(val dogList: ArrayList<DogBreed>) : RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {

    fun updateDogList(newDogList: List<DogBreed>){
        dogList.clear()
        dogList.addAll(newDogList)
        notifyDataSetChanged()
    }
     class DogViewHolder(var view: View): RecyclerView.ViewHolder(view){

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view= inflater.inflate(R.layout.dog_item, parent,false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: DogViewHolder, position: Int) {
        viewHolder.view.findViewById<TextView>(R.id.name).text= dogList[position].dogBreed
        viewHolder.view.findViewById<TextView>(R.id.life).text= dogList[position].lifespan
    }

    override fun getItemCount()= dogList.size
}