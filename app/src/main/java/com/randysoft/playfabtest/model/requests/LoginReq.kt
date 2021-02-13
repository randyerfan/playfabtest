package com.randysoft.playfabtest.model.requests

import com.google.gson.annotations.SerializedName

data class LoginReq(@SerializedName( "Username" )val Username : String, @SerializedName("Password") val Password : String,@SerializedName("TitleId") val TitleId : String)
