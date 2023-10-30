package com.abana.lockermachine.view.activities

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridLayout
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.MultiAutoCompleteTextView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.abana.lockermachine.databinding.ActivityMainBinding
import com.abana.lockermachine.model.pojo.Items
import com.abana.lockermachine.model.pojo.MachineLocker
import com.abana.lockermachine.view.adapters.GridViewAdapter
import com.abana.lockermachine.viewmodel.HomeViewModel
import com.google.gson.Gson
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONException


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val activity=this
    private val viewModel:HomeViewModel by viewModels()
    private val list:MutableList<Items> = mutableListOf()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
      viewModel.getJsonDataFromRepo(activity,"JSONdata.json")
      viewModel.jsonData.observe(this, Observer {
          if(it!=null)
          {
              list.addAll(it.items)
              val SPL1List:MutableList<Items> = mutableListOf()
              val SPLMainList:MutableList<Items> = mutableListOf()
              for(i in 0 until list.size)
              {
                  val machineLocker=list[i].machineLocker
                      if (machineLocker!!.modelName.equals("SPLMain")) {
                          SPLMainList.add(list[i])
                      } else {
                          SPL1List.add(list[i])
                      }

              }
//              list.addAll(it.items)
              SPL1List.sortBy { it.machineLocker!!.lockerSequenceNo }
              val chunkSize = 10
              val dividedLists = splitListIntoMultipleLists(SPL1List, chunkSize)
              binding.llMain.weightSum=3f

//              for ((index, chunk) in dividedLists.withIndex()) {
//                  println("Chunk $index: ${chunk.joinToString()}")
//                  setTable(firstArrayList!!)
//              }
//              for(i in 0 until SPLMainList.size)
//              {
//                  setMain(SPLMainList)
//              }

              for(i in 0 until dividedLists.size)
              {
                  setTable(dividedLists[i])
                  Log.d("list",Gson().toJson(dividedLists[i]))
              }

          }
      })

    }
    private fun setMain(splMainList: MutableList<Items>)
    {
        val linearLayout=LinearLayout(activity)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, // Width (can be WRAP_CONTENT, MATCH_PARENT, or specific value)
            LinearLayout.LayoutParams.WRAP_CONTENT, // Height (can be WRAP_CONTENT, MATCH_PARENT, or specific value)
            1.0f // Weight (this determines how the space is distributed among child views)
        )
        linearLayout.layoutParams=layoutParams
        linearLayout.orientation=LinearLayout.VERTICAL
        linearLayout.setBackgroundColor(resources.getColor(com.abana.lockermachine.R.color.green))

        for (i in 0 until splMainList.size)
        {
            val data=splMainList[i]
            val textView=TextView(activity)
            textView.text=data.machineLocker!!.lockerNo.toString()
            textView.layoutParams =
                LinearLayout.LayoutParams(100,100)
            linearLayout.addView(textView)
        }
        binding.llMain.addView(linearLayout)
    }

//    private fun setMain(splMainList: MutableList<Items>) {
//        val linearLayout=LinearLayout(activity)
//        val layoutParams = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.MATCH_PARENT, // Width (can be WRAP_CONTENT, MATCH_PARENT, or specific value)
//            LinearLayout.LayoutParams.WRAP_CONTENT, // Height (can be WRAP_CONTENT, MATCH_PARENT, or specific value)
//            1.0f // Weight (this determines how the space is distributed among child views)
//        )
//        linearLayout.layoutParams=layoutParams
//        linearLayout.orientation=LinearLayout.VERTICAL
//        for(i in 0 until splMainList.size)
//        {
////            if(splMainList[i].machineLocker!!.size==6)
////            {
////                val iv=ImageView(this)
////                iv.setImageDrawable(resources.getDrawable(com.abana.lockermachine.R.drawable.ic_launcher_background))
////                iv.layoutParams =
////                    LinearLayout.LayoutParams(100,100)
////                linearLayout.addView(iv)
////            }
////            else
////            {
//                val data=list[i]
//                val textView=TextView(activity)
//                textView.text=data.machineLocker!!.lockerNo.toString()
//                textView.layoutParams =
//                    LinearLayout.LayoutParams(100,100)
//                linearLayout.addView(textView)
////            }
//        }
//        binding.llMain.addView(linearLayout)
//
//
//
//    }

    fun splitListIntoMultipleLists(inputList: MutableList<Items>, chunkSize: Int): MutableList<MutableList<Items>> {
        val result = mutableListOf<MutableList<Items>>()

        for (i in 0 until inputList.size step chunkSize) {
            val chunk = inputList.subList(i, (i + chunkSize).coerceAtMost(inputList.size))
            result.add(chunk)
        }

        return result
    }

    private fun setTable(list: MutableList<Items>) {
        val linearLayout=LinearLayout(activity)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, // Width (can be WRAP_CONTENT, MATCH_PARENT, or specific value)
            LinearLayout.LayoutParams.WRAP_CONTENT, // Height (can be WRAP_CONTENT, MATCH_PARENT, or specific value)
            1.0f // Weight (this determines how the space is distributed among child views)
        )
        linearLayout.layoutParams=layoutParams
        linearLayout.orientation=LinearLayout.VERTICAL
        linearLayout.setBackgroundColor(resources.getColor(com.abana.lockermachine.R.color.green))

        for (i in 0 until list.size)
        {
            val data=list[i]
            val textView=TextView(activity)
            textView.text=data.machineLocker!!.lockerNo.toString()
            textView.layoutParams =
                LinearLayout.LayoutParams(100,100)
            linearLayout.addView(textView)
        }
        binding.llMain.addView(linearLayout)
    }
   fun sample()
    {
        for (i in 1..9) {
            val textView = TextView(this)
            textView.text = "Item $i"
            textView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
            binding.llMain.addView(textView)
        }
    }


}