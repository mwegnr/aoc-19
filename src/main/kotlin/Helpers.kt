import java.io.File

fun getInput(day: String): ArrayList<String> {
    val fileName = "src/main/resources/input/$day.in"
    val inputStream = File(fileName).inputStream()
    val inputLines = ArrayList<String>()
    inputStream.bufferedReader().useLines { lines -> lines.forEach { inputLines.add(it) } }
    return inputLines
}

fun getInputLine(day: String, lineNo: Int): String {
    return getInput(day)[lineNo]
}