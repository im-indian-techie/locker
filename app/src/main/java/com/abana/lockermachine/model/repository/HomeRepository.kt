package com.abana.lockermachine.model.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.abana.lockermachine.model.pojo.MachineLocker
import com.abana.lockermachine.model.pojo.Main
import com.abana.lockermachine.model.pojo.Result
import com.abana.lockermachine.utils.JsonReader
import com.google.gson.Gson

class HomeRepository {
   var jsonData:MutableLiveData<Result> = MutableLiveData()
   var progressData:MutableLiveData<Boolean> = MutableLiveData()

   fun fetchJsonData():MutableLiveData<Result>
   {
      return jsonData;
   }
   fun fetchProgressData():MutableLiveData<Boolean>
   {
      return progressData
   }

   fun getResult(context: Context,filename:String)
   {
      progressData.value=true

      val Main=Gson().fromJson(JsonReader().getJsonObjectFromAssets(context,filename).toString(),Main::class.java)
      jsonData.value=Main.result
   }
}