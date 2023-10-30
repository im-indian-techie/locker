package com.abana.lockermachine.model.pojo

import com.google.gson.annotations.SerializedName

data class Items (

    @SerializedName("machineLocker" ) var machineLocker : MachineLocker? = MachineLocker()

)