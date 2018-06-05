package com.example.seetha.seasonalclone.models

import com.google.gson.annotations.SerializedName

data class ProduceItem(
        @SerializedName("ID") val id: String,
        @SerializedName("Name") val name: String,
        @SerializedName("Type") val type: String,
        @SerializedName("Description") val description: String,
        @SerializedName("imgURL") val imgURL: String,
        @SerializedName("Display") val display: Boolean

)

data class ProduceByState(
        @SerializedName("ID") val id: String,
        @SerializedName("months") val months: ProduceMonth
)

data class ProduceMonth(
        @SerializedName("January") val january: Boolean,
        @SerializedName("February") val february: Boolean,
        @SerializedName("March") val march: Boolean,
        @SerializedName("April") val april: Boolean,
        @SerializedName("May") val may: Boolean,
        @SerializedName("June") val june: Boolean,
        @SerializedName("July") val july: Boolean,
        @SerializedName("August") val august: Boolean,
        @SerializedName("September") val september: Boolean,
        @SerializedName("October") val october: Boolean,
        @SerializedName("November") val november: Boolean,
        @SerializedName("December") val december: Boolean
)