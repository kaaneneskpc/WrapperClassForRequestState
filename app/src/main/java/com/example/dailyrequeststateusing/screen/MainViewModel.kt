package com.example.dailyrequeststateusing.screen

import androidx.lifecycle.ViewModel

class MainViewModel(
    private val repository: MainRepository = MainRepository()
): ViewModel() {
   val data = repository.fetchData()
}