package id.derysudrajat.easyadapter

object Dummy {
    val example = mutableListOf(
        Data("Suherman", "123"),
        Data("Maman", "123454"),
        Data("Bejo", "2345425"),
        Data("Lukman", "657"),
        Data("Doni", "987987"),
        Data("Juki", "5475667"),
    )
}

data class Data(
    val name: String? = null,
    val id: String? = null
)
