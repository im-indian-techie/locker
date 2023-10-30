package com.abana.lockermachine.model.pojo

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("totalCount" ) var totalCount : Int?             = null,
    @SerializedName("items"      ) var items      : MutableList<Items> = mutableListOf()
)