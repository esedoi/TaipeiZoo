package com.example.taipeizoo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class GetAnimalsResponse(
    val result: AnimalResult?
)

data class AnimalResult(
    val limit: Int?,
    val offset: Int?,
    val count: Int?,
    val sort: String?,
    val results: List<Animal>?
)

@Parcelize
data class Animal(
    @SerializedName("_id") val id: Int,
    @SerializedName("_importdate") val importDate: ImportDate?,
    @SerializedName("a_name_ch", alternate = ["A_Name_Ch"]) val nameCh: String?,
    @SerializedName("a_summary", alternate = ["A_Summary"]) val summary: String?,
    @SerializedName("a_keywords", alternate = ["A_Keywords"]) val keywords: String?,
    @SerializedName("a_alsoknown", alternate = ["A_AlsoKnown"]) val alsoKnown: String?,
    @SerializedName("a_geo", alternate = ["A_Geo"]) val geo: String?,
    @SerializedName("a_location", alternate = ["A_Location"]) val location: String?,
    @SerializedName("a_poigroup", alternate = ["A_POIGroup"]) val poiGroup: String?,
    @SerializedName("a_name_en", alternate = ["A_Name_En"]) val nameEn: String?,
    @SerializedName("a_name_latin", alternate = ["A_Name_Latin"]) val nameLatin: String?,
    @SerializedName("a_phylum", alternate = ["A_Phylum"]) val phylum: String?,
    @SerializedName("a_class", alternate = ["A_Class"]) val clazz: String?,
    @SerializedName("a_order", alternate = ["A_Order"]) val order: String?,
    @SerializedName("a_family", alternate = ["A_Family"]) val family: String?,
    @SerializedName("a_conservation", alternate = ["A_Conservation"]) val conservation: String?,
    @SerializedName("a_distribution", alternate = ["A_Distribution"]) val distribution: String?,
    @SerializedName("a_habitat", alternate = ["A_Habitat"]) val habitat: String?,
    @SerializedName("a_feature", alternate = ["A_Feature"]) val feature: String?,
    @SerializedName("a_behavior", alternate = ["A_Behavior"]) val behavior: String?,
    @SerializedName("a_diet", alternate = ["A_Diet"]) val diet: String?,
    @SerializedName("a_crisis", alternate = ["A_Crisis"]) val crisis: String?,
    @SerializedName("a_interpretation", alternate = ["A_Interpretation"]) val interpretation: String?,
    @SerializedName("a_theme_name", alternate = ["A_Theme_Name"]) val themeName: String?,
    @SerializedName("a_theme_url", alternate = ["A_Theme_URL"]) val themeUrl: String?,
    @SerializedName("a_adopt", alternate = ["A_Adopt"]) val adopt: String?,
    @SerializedName("a_code", alternate = ["A_Code"]) val code: String?,
    @SerializedName("a_pic01_alt", alternate = ["A_Pic01_ALT"]) val pic01Alt: String?,
    @SerializedName("a_pic01_url", alternate = ["A_Pic01_URL"]) val pic01Url: String?,
    @SerializedName("a_pic02_alt", alternate = ["A_Pic02_ALT"]) val pic02Alt: String?,
    @SerializedName("a_pic02_url", alternate = ["A_Pic02_URL"]) val pic02Url: String?,
    @SerializedName("a_pic03_alt", alternate = ["A_Pic03_ALT"]) val pic03Alt: String?,
    @SerializedName("a_pic03_url", alternate = ["A_Pic03_URL"]) val pic03Url: String?,
    @SerializedName("a_pic04_alt", alternate = ["A_Pic04_ALT"]) val pic04Alt: String?,
    @SerializedName("a_pic04_url", alternate = ["A_Pic04_URL"]) val pic04Url: String?,
    @SerializedName("a_pdf01_alt", alternate = ["A_pdf01_ALT"]) val pdf01Alt: String?,
    @SerializedName("a_pdf01_url", alternate = ["A_pdf01_URL"]) val pdf01Url: String?,
    @SerializedName("a_pdf02_alt", alternate = ["A_pdf02_ALT"]) val pdf02Alt: String?,
    @SerializedName("a_pdf02_url", alternate = ["A_pdf02_URL"]) val pdf02Url: String?,
    @SerializedName("a_voice01_alt", alternate = ["A_Voice01_ALT"]) val voice01Alt: String?,
    @SerializedName("a_voice01_url", alternate = ["A_Voice01_URL"]) val voice01Url: String?,
    @SerializedName("a_voice02_alt", alternate = ["A_Voice02_ALT"]) val voice02Alt: String?,
    @SerializedName("a_voice02_url", alternate = ["A_Voice02_URL"]) val voice02Url: String?,
    @SerializedName("a_voice03_alt", alternate = ["A_Voice03_ALT"]) val voice03Alt: String?,
    @SerializedName("a_voice03_url", alternate = ["A_Voice03_URL"]) val voice03Url: String?,
    @SerializedName("a_vedio_url", alternate = ["A_Vedio_URL"]) val videoUrl: String?,
    @SerializedName("a_update", alternate = ["A_Update"]) val update: String?,
    @SerializedName("a_cid") val cid: String?
) : Parcelable
