package com.example.dailyrequeststateusing.screen

import com.example.dailyrequeststateusing.RequestState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository {
    val myData = listOf("Formula 1", "Turkey GP", "2026")

    fun fetchData(): Flow<RequestState<List<String>>> {
        return flow {
            emit(RequestState.Loading)
            delay(2000)
            // emit(RequestState.Error(message =  "Something went wrong."))
            emit(RequestState.Success(data = myData))
        }
    }
}