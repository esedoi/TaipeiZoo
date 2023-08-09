package com.example.taipeizoo.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class GetExhibitsResponse(
    val result: Result
)


data class Result(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<Exhibit>
)

@Parcelize
data class Exhibit(
    @SerializedName("_id") val id: Int,
    @SerializedName("_importdate") val importDate: ImportDate,
    @SerializedName("e_no") val eNo: String,
    @SerializedName("e_category") val eCategory: String,
    @SerializedName("e_name") val eName: String,
    @SerializedName("e_pic_url") val ePicUrl: String,
    @SerializedName("e_info") val eInfo: String,
    @SerializedName("e_memo") val eMemo: String,
    @SerializedName("e_geo") val eGeo: String,
    @SerializedName("e_url") val eUrl: String
) : Parcelable

@Parcelize
data class ImportDate(
    @SerializedName("date") val date: String,
    @SerializedName("timezone_type") val timezoneType: Int,
    @SerializedName("timezone") val timezone: String
) : Parcelable
