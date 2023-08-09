package com.example.taipeizoo.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class GetExhibitsResponse(
    val result: Result?
)


data class Result(
    val limit: Int?,
    val offset: Int?,
    val count: Int?,
    val sort: String?,
    val results: List<Exhibit>?
)

@Parcelize
data class Exhibit(
    @SerializedName("_id") val id: Int?,
    @SerializedName("_importdate") val importDate: ImportDate?,
    @SerializedName(value = "e_no", alternate = ["E_no"]) val eNo: String?,
    @SerializedName(value = "e_category", alternate = ["E_Category"]) val eCategory: String?,
    @SerializedName(value = "e_name", alternate = ["E_Name"]) val eName: String?,
    @SerializedName(value = "e_pic_url", alternate = ["E_Pic_URL"]) val ePicUrl: String?,
    @SerializedName(value = "e_info", alternate = ["E_Info"]) val eInfo: String?,
    @SerializedName(value = "e_memo", alternate = ["E_Memo"]) val eMemo: String?,
    @SerializedName(value = "e_geo", alternate = ["E_Geo"]) val eGeo: String?,
    @SerializedName(value = "e_url", alternate = ["E_URL"]) val eUrl: String?
) : Parcelable

@Parcelize
data class ImportDate(
    @SerializedName("date") val date: String?,
    @SerializedName("timezone_type") val timezoneType: Int?,
    @SerializedName("timezone") val timezone: String?
) : Parcelable
