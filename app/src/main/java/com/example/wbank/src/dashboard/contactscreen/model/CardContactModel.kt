package com.example.wbank.src.dashboard.contactscreen.model

data class CardContactModel(
    val title: String? = "",
    val description: String? = "",
    val isClickIcon: Boolean,
)

object ConstantContact {

    val cardContactList = listOf(
        CardContactModel(
            title = "Card details",
            description = "card replenishment detail",
            isClickIcon = false
        ),

        CardContactModel(
            title = "Card details",
            description = "card replenishment detail",
            isClickIcon = false
        ),
        CardContactModel(
            title = "ATM withdraw",
            description = "Enable withdraw via a ATM",
            isClickIcon = true
        ),
        CardContactModel(
            title = "Online payment ",
            description = "Enable withdraw via a ATM",
            isClickIcon = true
        ),
        CardContactModel(
            title = "Use as min card",
            description = "Enable withdraw via a ATM",
            isClickIcon = true
        ),
        CardContactModel(
            title = "Online payment ",
            description = "Enable withdraw via a ATM",
            isClickIcon = true
        ),
        CardContactModel(
            title = "Use as min card",
            description = "Enable withdraw via a ATM",
            isClickIcon = true
        ),

        )
}
