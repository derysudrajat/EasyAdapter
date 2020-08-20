package id.derysudrajat.easyadapter

object Data {
    data class Items(
        val name: String? = null,
        val id : String? =null
    )
    val example = mutableListOf(
        Items("Suherman","123"),
        Items("Maman","123454"),
        Items("Bejo","2345425"),
        Items("Lukman","657"),
        Items("Doni","987987"),
        Items("Juki","5475667"),
    )
}
