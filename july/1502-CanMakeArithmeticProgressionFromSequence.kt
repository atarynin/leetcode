package july

/*
    A sequence of numbers is called an arithmetic progression
    if the difference between any two consecutive elements is the same.
    Given an array of numbers arr, return true if the array can be rearranged
    to form an arithmetic progression. Otherwise, return false.
    see: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/description/
 */

//buzzwords: Arithmetic Progression

fun main() {
    println(
        Solution1502().canMakeArithmeticProgression(
            intArrayOf(3, 5, 1)
        )
    )
    println(
        Solution1502().canMakeArithmeticProgression(
            intArrayOf(1, 2, 4)
        )
    )
}

class Solution1502 {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        val sortedArray = arr.apply {
            sort()
        }
        val diff = sortedArray[1] - sortedArray[0]
        for (i in 2 until arr.size) {
            if ((sortedArray[i] - sortedArray[i - 1]) != diff) {
                return false
            }
        }
        return true
    }
}

//other interesting solutions
/*
    Idea is putting every element in hash and then checking if the expected element is present.
    This allows us to get rid of sorting incoming array to reduce complexity a little bit.
 */
/*
class Solution1502 {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        val values = hashSetOf<Int>()
        var max = arr[0]
        var min = arr[0]
        for (i in arr.indices) {
            val element = arr[i]
            if (max < element) max = element
            if (min > element) min = element
            values.add(element)
        }
        if (max == min) return true
        if (values.size != arr.size) return false
        val step = (max - min) / (arr.size - 1)
        for (i in arr.indices) {
            if (!values.contains(min + step * i)) {
                return false
            }
        }
        return true
    }
}
*/
