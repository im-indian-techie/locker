package com.abana.lockermachine.model.pojo

import com.google.gson.annotations.SerializedName

data class Main (

    @SerializedName("result"              ) var result              : Result?  = Result(),
    @SerializedName("targetUrl"           ) var targetUrl           : String?  = null,
    @SerializedName("success"             ) var success             : Boolean? = null,
    @SerializedName("error"               ) var error               : String?  = null,
    @SerializedName("unAuthorizedRequest" ) var unAuthorizedRequest : Boolean? = null,
    @SerializedName("__abp"               ) var _abp                : Boolean? = null

)
