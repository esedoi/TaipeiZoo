package com.example.taipeizoo.model

sealed class ExhibitDetailItem {

    data class ExhibitDetail(val exhibit: Exhibit):ExhibitDetailItem()

    data class AnimalItem(val animal: Animal):ExhibitDetailItem()
}