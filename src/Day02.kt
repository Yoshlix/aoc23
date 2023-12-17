fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        for (line in input) {
            val game = parseDataToGameObject(line)

            if (game.gameSets.none { it.redCubes > 12 || it.blueCubes > 14 || it.greenCubes > 13 }) {
                result += game.gameId
            }
        }

        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        for (line in input) {
            val game = parseDataToGameObject(line)
            val power = game.gameSets.maxOf { it.redCubes } * game.gameSets.maxOf { it.greenCubes } * game.gameSets.maxOf { it.blueCubes }
            result += power
        }

        return result
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun parseDataToGameObject(data: String): Game {
    val gameSets: (String) -> Collection<GameSet> = fun(line): Collection<GameSet> {
        var gameSetsList: Collection<GameSet> = emptyList()

        for (gameSets in line.split(':')[1].trim().split(';')) {
            val gameSetObject = GameSet(0, 0, 0)
            for (gameSet in gameSets.split(',')) {
                if (gameSet.contains("red")) {
                    if (gameSet.trimStart().split(' ')[0].toInt() != 0) {
                        gameSetObject.redCubes = gameSet.trimStart().split(' ')[0].toInt()
                    }
                }
                if (gameSet.contains("blue")) {
                    if (gameSet.trimStart().split(' ')[0].toInt() != 0) {
                        gameSetObject.blueCubes = gameSet.trimStart().split(' ')[0].toInt()
                    }
                }
                if (gameSet.contains("green")) {
                    if (gameSet.trimStart().split(' ')[0].toInt() != 0) {
                        gameSetObject.greenCubes = gameSet.trimStart().split(' ')[0].toInt()
                    }
                }
            }
            gameSetsList += gameSetObject
        }
        return gameSetsList
    }

    return Game(
        gameId = data.split(':')[0].trim().split(' ')[1].trim().toInt(), gameSets = gameSets.invoke(data)
    )
}

data class Game(val gameId: Int, val gameSets: Collection<GameSet>)

data class GameSet(var blueCubes: Int, var redCubes: Int, var greenCubes: Int)