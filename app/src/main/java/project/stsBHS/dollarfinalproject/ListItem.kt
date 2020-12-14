package project.stsBHS.dollarfinalproject

data class ListItem (val id: Long,
                     val date: String,
                     var description: String,
                     val amount: Double,
                     var checked: Boolean) {
}