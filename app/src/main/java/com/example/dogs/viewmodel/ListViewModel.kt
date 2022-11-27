package com.example.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogs.model.DogBreed

class ListViewModel : ViewModel() {
    val dogs= MutableLiveData<List<DogBreed>>()
    val dogLoadError= MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        val dog1= DogBreed("1","Abc","20 years", "xyz", "bredFor", "Temprament","")
        val dog2= DogBreed("2","jhgj","10 years", "iyi", "bredFor", "Temprament","")
        val dog3= DogBreed("3","hjjhn","30 years", "kpi", "bredFor", "Temprament","")
        val dogList= arrayListOf(dog1,dog2,dog3)
        dogs.value= dogList
        dogLoadError.value=false
        loading.value=false
    }
}