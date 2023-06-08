package july

/*
    Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
     return the number of negative numbers in grid.
    see: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 */

//buzzwords: Matrix

fun main() {
    println(
        //8
        Solution1351().countNegatives(
            arrayOf(
                intArrayOf(4, 3, 2, -1),
                intArrayOf(3, 2, 1, -1),
                intArrayOf(1, 1, -1, -2),
                intArrayOf(-1, -1, -2, -3)
            )
        )
    )
    println(
        //0
        Solution1351().countNegatives(
            arrayOf(
                intArrayOf(3, 2),
                intArrayOf(1, 0)
            )
        )
    )
}

class Solution1351 {
    fun countNegatives(grid: Array<IntArray>): Int {
        var result = 0
        var column = grid[0].lastIndex
        var row = 0
        if (grid[grid.lastIndex][grid[0].lastIndex] > 0) {
            return result
        }
        while (column >= 0 && row <= grid.lastIndex) {
            if (grid[row][column] < 0) {
                result += grid.size - row

                column -= 1
            } else {
                if (grid[grid.lastIndex][column] > 0) {
                    column -= 1
                }
                row += 1
            }
        }
        return result
    }
}
