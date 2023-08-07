package com.example.taipeizoo.zoo_area

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taipeizoo.model.Exhibit
import com.example.taipeizoo.model.ZooRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ZooAreaViewModel @Inject constructor(
    private val zooRepository: ZooRepository
) : ViewModel() {

    private val _data = MutableLiveData<List<Exhibit>>()
    val data: LiveData<List<Exhibit>> = _data

    init {

        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val response = zooRepository.getData()
                if (response.isSuccessful) {
                    _data.value = response.body()?.result?.results
                }
            }catch (e:Error){

            }


        }
    }
}