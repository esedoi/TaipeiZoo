package com.example.taipeizoo.exhibitsDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taipeizoo.model.Animal
import com.example.taipeizoo.model.ZooRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExhibitDetailViewModel @Inject constructor(
    private val zooRepository: ZooRepository
) : ViewModel() {

    private val _data = MutableLiveData<List<Animal>>()
    val data: LiveData<List<Animal>> = _data

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    init {

        getAnimals()
    }

    private fun getAnimals() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = zooRepository.getAnimals()
                if (response.isSuccessful) {
                    _data.value = response.body()?.result?.results
                }
            } catch (e: Error) {

            } finally {
                _isLoading.value = false
            }

        }
    }
}