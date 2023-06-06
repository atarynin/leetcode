package july

/*
    You are given an array coordinates, coordinates[i] = [x, y],
    where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
    see: https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
 */

//buzzwords: linear equality, Collinear points

fun main() {
    println(
        Solution1232().checkStraightLine(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(5, 6),
                intArrayOf(6, 7)
            )
        )
    )
    println(
        Solution1232().checkStraightLine(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(5, 6),
                intArrayOf(7, 7)
            )
        )
    )
}

class Solution1232 {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val x0 = coordinates[0][0]
        val x1 = coordinates[1][0]
        val y0 = coordinates[0][1]
        val y1 = coordinates[1][1]
        val dx = x1 - x0
        val dy = y1 - y0
        return coordinates.map {
            (it[0] - x0) * dy == (it[1] - y0) * dx
        }.all { it }
    }
}
