package com.riskpace.demo.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiResponse<T> {

    @Expose
    @SerializedName(value = "result", alternate = ["RESULT"])
    var result: String = "0"

    @Expose
    @SerializedName(value = "message", alternate = ["MSG", "MESSAGE"])
    var message: String = ""

    @Expose
    @SerializedName(value = "data", alternate = ["DATA"])
    var data: T? = null

}