import java.io.File

fun getInput(day: String): ArrayList<String> {
    val fileName = "input/$day.in"
    val inputStream = File(fileName).inputStream()
    val inputLines = ArrayList<String>()
    inputStream.bufferedReader().useLines { lines -> lines.forEach { inputLines.add(it) }}
    return inputLines
}