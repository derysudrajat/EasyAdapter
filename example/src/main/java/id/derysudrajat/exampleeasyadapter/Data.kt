package id.derysudrajat.exampleeasyadapter

object Dummy {
    val example = mutableListOf(
        Data("Mio", "1"),
        Data("Hera", "2"),
        Data("Law", "3"),
        Data("Kid", "4"),
        Data("Bonney", "5"),
        Data("Buggy", "6"),
    )

    val anotherExample = mutableListOf(
        Data("Nana", "7"),
        Data("Lola", "8"),
        Data("Jeje", "9"),
        Data("Edo", "10"),
        Data("Dina", "11"),
        Data("Boni", "12"),
    )
}

data class Data(
    val name: String? = null,
    val id: String? = null
)
