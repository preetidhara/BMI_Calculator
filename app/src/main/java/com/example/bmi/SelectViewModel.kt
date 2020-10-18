package com.example.bmi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SelectViewModel:ViewModel() {

     var _Weight_edt=MutableLiveData<Int>()
    val Weight_edt:LiveData<Int>
    get() = _Weight_edt

    var _age_edt=MutableLiveData<Int>()
    val age_edt:LiveData<Int>
    get()=_age_edt




    init {
        _Weight_edt.value=40
        _age_edt.value=18
    }

  fun weight_add(){
      _Weight_edt.value=_Weight_edt.value?.plus(1)

  }
    fun weight_remove(){
        _Weight_edt.value=_Weight_edt.value?.minus(1)
    }

    fun age_add(){
        _age_edt.value=_age_edt.value?.plus(1)
    }

    fun age_remove(){
        _age_edt.value=_age_edt.value?.minus(1)
    }


}