fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        for (line in input) {
            var lineNumbers = ""
            for (char in line) {
                if (char.isDigit())
                    lineNumbers += char
            }
            val number: String = lineNumbers.first().toString() + lineNumbers.last().toString()
            result += number.toInt()
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        val numbers = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        for (line in input) {
            var firstNumber = line.findAnyOf(numbers.toList())?.second
            var lastNumber = line.findLastAnyOf(numbers.toList())?.second
            when (firstNumber) {
                "one" -> firstNumber = "1"
                "two" -> firstNumber = "2"
                "three" -> firstNumber = "3"
                "four" -> firstNumber = "4"
                "five" -> firstNumber = "5"
                "six" -> firstNumber = "6"
                "seven" -> firstNumber = "7"
                "eight" -> firstNumber = "8"
                "nine" -> firstNumber = "9"
            }
            when (lastNumber) {
                "one" -> lastNumber = "1"
                "two" -> lastNumber = "2"
                "three" -> lastNumber = "3"
                "four" -> lastNumber = "4"
                "five" -> lastNumber = "5"
                "six" -> lastNumber = "6"
                "seven" -> lastNumber = "7"
                "eight" -> lastNumber = "8"
                "nine" -> lastNumber = "9"
            }
            val lineNumber: String = firstNumber + lastNumber
            result += lineNumber.toInt()
        }
        return result
    }



    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
