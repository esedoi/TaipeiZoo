package com.example.taipeizoo.data

sealed class ExhibitDetailItem {

    data class ExhibitDetail(val exhibit: Exhibit) : ExhibitDetailItem()

    data class AnimalItem(val animal: Animal) : ExhibitDetailItem()
}