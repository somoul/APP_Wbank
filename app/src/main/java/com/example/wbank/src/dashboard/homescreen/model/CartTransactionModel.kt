package com.example.wbank.src.dashboard.homescreen.model

data class CartTransactionModel(
    val image: String = "",
    val title: String = "",
    val description: String = "",
    val price: String = "",
    val date: String = "",
    val isPrice: Boolean,
    val code: String = "",
    val amount: String = "",
    val balance: String = "",
    val dateMoney: String = "",
    val nameCard: String = "",
    val moneyRal: String = "",

)


object ConstantsTransactionModel {
    val imageListTransactionModel = listOf(

        CartTransactionModel(
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHDRlp-KGr_M94k_oor4Odjn2UzbAS7n1YoA&usqp=CAU",
            title = "Salary",
            description = "Top-up",
            price = "+30 103.002$",
            date = "30 Apr 07:10",
            isPrice = true,
            code = " 4565",
            amount = "99 234.90",
            balance = "10 234.90",
            dateMoney = "04/11",
            nameCard = "Debit VISA",
            moneyRal="4100"
        ),
        CartTransactionModel(
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwL1CoGAdxzkHzXerFGNIf8lASXVRycr07gQ&usqp=CAU",
            title = "Basket",
            description = "Top-up",
            price = "-30.56",
            date = "30 Apr 09:10",
            isPrice = false,
            code = " 2534",
            amount = "52 234.90",
            balance = "31 224.90",
            dateMoney = "11/21",
            nameCard = "Credit VISA",
            moneyRal="4100"
        ),

        CartTransactionModel(
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHDRlp-KGr_M94k_oor4Odjn2UzbAS7n1YoA&usqp=CAU",
            title = "Salary",
            description = "Top-up",
            price = "+30 103.002$",
            date = "30 Apr 07:10",
            isPrice = true,
            code = " 7655",
            amount = "78 234.90",
            balance = "45 234.90",
            dateMoney = "08/21",
            nameCard = "Main card",
            moneyRal="4100"
        ),
        CartTransactionModel(
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwL1CoGAdxzkHzXerFGNIf8lASXVRycr07gQ&usqp=CAU",
            title = "Basket",
            description = "Top-up",
            price = "-30.56",
            date = "30 Apr 09:10",
            isPrice = false,
            code = " 9866",
            amount = "10 234.90",
            balance = "8 234.90",
            dateMoney = "04/26",
            moneyRal="4100"
        ),
        CartTransactionModel(
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHDRlp-KGr_M94k_oor4Odjn2UzbAS7n1YoA&usqp=CAU",
            title = "Salary",
            description = "Top-up",
            price = "+30 103.002$",
            date = "30 Apr 07:10",
            isPrice = true,
            code = " 4575",
            amount = "65 234.90",
            balance = "44 234.90",
            dateMoney = "02/05",
            moneyRal="4100"
        ),
        CartTransactionModel(
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwL1CoGAdxzkHzXerFGNIf8lASXVRycr07gQ&usqp=CAU",
            title = "Basket",
            description = "Top-up",
            price = "-30.56",
            date = "30 Apr 09:10",
            isPrice = false,
            code = " 2344",
            amount = "86 234.90",
            balance = "22 234.90",
            dateMoney = "07/21",
            moneyRal="4100"
        ),


        )
}