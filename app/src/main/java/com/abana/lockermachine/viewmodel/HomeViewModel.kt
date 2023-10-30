package com.abana.lockermachine.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abana.lockermachine.model.pojo.MachineLocker
import com.abana.lockermachine.model.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepo:HomeRepository):ViewModel() {
  var jsonData= homeRepo.fetchJsonData()
  var progressData=homeRepo.fetchProgressData()

  fun getJsonDataFromRepo(context: Context,fileName:String)
  {
     homeRepo.getResult(context,fileName)
  }


}