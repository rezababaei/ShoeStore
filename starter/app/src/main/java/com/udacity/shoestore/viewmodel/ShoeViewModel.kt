package com.udacity.shoestore.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _eventAddShoe = MutableLiveData<Boolean>()
    val eventAddShoe: LiveData<Boolean>
        get() = _eventAddShoe

    private val _eventCancelShoeDetail = MutableLiveData<Boolean>()
    val eventCancelShoeDetail: LiveData<Boolean>
        get() = _eventCancelShoeDetail

    private val _eventUserLogin = MutableLiveData<Boolean>()
    val eventUserLogin: LiveData<Boolean>
        get() = _eventUserLogin


    private val _eventShowOnBoarding = MutableLiveData<Boolean>()
    val eventShowOnBoarding: LiveData<Boolean>
        get() = _eventShowOnBoarding


    private val _user = MutableLiveData<String>()
    val user: MutableLiveData<String>
        get() = _user

    val shoeDetail = MutableLiveData<Shoe>()

    init {
        _user.value = null
        loadShoes()
        shoeDetail.value = Shoe("", 0.0, "", "")
    }

    fun loadShoes() {
        _shoeList.value = mutableListOf(
            Shoe(name = "Product 1",
                size = 32.0,
                company = "Adidas",
                description = "The best Shoes",
                listOf("image1", "Image2")),
            Shoe(name = "Product 2",
                size = 32.0,
                company = "Nike",
                description = "The best Shoes",
                listOf("image1", "Image2")),
            Shoe(name = "Product 3",
                size = 32.0,
                company = "Nike",
                description = "The best Shoes",
                listOf("image1", "Image2")),
            Shoe(name = "Product 4",
                size = 32.0,
                company = "Reebok",
                description = "The best Shoes",
                listOf("image1", "Image2")),
            Shoe(name = "Product 5",
                size = 32.0,
                company = "Adidas",
                description = "The best Shoes",
                listOf("image1", "Image2"))

        )
    }

    fun onUserLogin() {
        _eventUserLogin.value = false
    }

    fun userLogin() {
        _eventUserLogin.value = true
        _user.value = "emailAddress + password"
    }

    fun userNewLogin() {
        _eventUserLogin.value = true
        _user.value = "emailAddress + password"
    }

    fun userLogout() {
        _user.value = null
    }


    fun onShowOnBoarding() {
        _eventShowOnBoarding.value = false
    }


    fun onAddShoe() {
        _eventAddShoe.value = false
    }

    fun addShoe() {
        _eventAddShoe.value = true
    }

    fun onCancelShoeDetail() {
        _eventCancelShoeDetail.value = false
    }

    fun cancelShoeDetail() {
        _eventCancelShoeDetail.value = true
        clearData()
    }

    fun addShoeDetail(): Boolean? {
        val result = shoeDetail.value?.let { _shoeList.value?.add(it) }
        clearData()
        _eventAddShoe.value = false
        return result
    }

    private fun clearData() {
        shoeDetail.value = Shoe("", 0.0, "", "")
    }




}