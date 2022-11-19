package com.example.demo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.models.Products
import com.example.demo.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {
    val productsLiveData: LiveData<Products>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}