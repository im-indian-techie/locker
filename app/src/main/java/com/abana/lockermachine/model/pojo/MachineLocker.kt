package com.abana.lockermachine.model.pojo

import com.google.gson.annotations.SerializedName

data class MachineLocker (

    @SerializedName("machineID"        ) var machineID        : Int?     = null,
    @SerializedName("machineName"      ) var machineName      : String?  = null,
    @SerializedName("lockerNo"         ) var lockerNo         : Int?     = null,
    @SerializedName("active"           ) var active           : Boolean? = null,
    @SerializedName("lockerSequenceNo" ) var lockerSequenceNo : Int?     = null,
    @SerializedName("columnSequence"   ) var columnSequence   : Int?     = null,
    @SerializedName("size"             ) var size             : Int?     = null,
    @SerializedName("modelName"        ) var modelName        : String?  = null,
    @SerializedName("id"               ) var id               : Int?     = null

)