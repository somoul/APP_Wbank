import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector


data class ShipModel(
    val colorBackGround: Long,
    val nameShip: String = "",
    val nameShipExchange: String = "",
    val icons: ImageVector,
)

object ConstantsShip {

    val imageListShip = listOf(
        ShipModel(
            colorBackGround = 0xffCEC1FB,
            nameShip = "Top-up",
            nameShipExchange = "UAH",
            icons = Icons.Filled.AutoAwesome
        ),
        ShipModel(
            colorBackGround = 0xff7EF59F,
            nameShip = "Transfer",
            nameShipExchange = "EUR",
            icons = Icons.Filled.SyncAlt
        ),
        ShipModel(
            colorBackGround = 0xff7CD0FF,
            nameShip = "ExChange",
            nameShipExchange = "GBP",
            icons = Icons.Filled.Sync
        ),
        ShipModel(
            colorBackGround = 0xffFFC4A4,
            nameShip = "Statistic",
            nameShipExchange = "PLN",
            icons = Icons.Filled.SignalCellularAlt
        )


    )
}

object ConstantsShipDetail {

    val imageListShip = listOf(
        ShipModel(
            colorBackGround = 0xffCEC1FB,
            nameShip = "Top-up",
            icons = Icons.Filled.SyncAlt
        ),

        ShipModel(
            colorBackGround = 0xff7EF59F,
            nameShip = "Transfer",
            icons = Icons.Filled.ReceiptLong
        )


    )
}