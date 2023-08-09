package com.example.taipeizoo.exhibits

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
class ExhibitsViewModel @Inject constructor(
    private val zooRepository: ZooRepository
) : ViewModel() {

    private val _data = MutableLiveData<List<Exhibit>>()
    val data: LiveData<List<Exhibit>> = _data

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    init {

        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = zooRepository.getExhibits()
                if (response.isSuccessful) {
                    _data.value = response.body()?.result?.results
                }
            }catch (e:Error){

            } finally {
                _isLoading.value = false
            }
        }
    }
}