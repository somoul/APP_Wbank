package com.example.wbank.src.dashboard.homescreen.model

data class CartModel(
    val tiTile: String = "",
    val nameCart: String = "",
    val money: String = "",
    val codeCart: String = "",
    val number: String = "",
    val startColor: Long = 0,
    val centralColor: Long,
    val endColor: Long,
    var isNameCart: Boolean = false

)

object Constants {

    val imageList = listOf(
        CartModel(
            tiTile = "Balance",
            nameCart = "VISA",
            money = "$134 555.56",
            codeCart = "9999",
            startColor = 0xFFFCB67C,
            centralColor = 0xFFFBA987,
            endColor = 0xFFFC949A,
            isNameCart = false,
            number = "12/24"

        ),
        CartModel(
            tiTile = "Wbank",
            nameCart = "VISA",
            money = "$034 999.56",
            codeCart = "0000 0000 0000 0000",
            startColor = 0xFFA555E5,
            centralColor = 0xFF954BEB,
            endColor = 0xFF7E3DF2,
            isNameCart = true,
            number = "15/24"

        ),
        CartModel(
            tiTile = "Balance",
            nameCart = "VISA",
            money = "$111 656.56",
            codeCart = "8888",
            startColor = 0xffCEC1FB,
            centralColor = 0xffCEC1FB,
            endColor = 0xffCEC1FB,
            isNameCart = false,
            number = "21/24"

        ),
        CartModel(
            tiTile = "Wbank",
            nameCart = "VISA",
            money = "$555 656.56",
            codeCart = "0000 0000 0000 0000",
            startColor = 0xFFACE6FF,
            centralColor = 0xFFACE6FF,
            endColor = 0xFFACE6FF,
            isNameCart = true,
            number = "12/24"

        ),
        CartModel(
            tiTile = "Balance",
            nameCart = "VISA",
            money = "$111 656.56",
            codeCart = "1111",
            startColor = 0xff3BB4CF,
            centralColor = 0xff3BB4CF,
            endColor = 0xff3BB4CF,
            isNameCart = false,
            number = "21/24"

        ),
        CartModel(
            tiTile = "Wbank",
            nameCart = "VISA",
            money = "$555 656.56",
            codeCart = "0000 0000 0000 0000",
            startColor = 0xFFCEC1FB,
            centralColor = 0xFFCEC1FB,
            endColor = 0xFFCEC1FB,
            isNameCart = true,
            number = "12/24"

        ),


        )
}