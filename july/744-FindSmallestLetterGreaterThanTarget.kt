package july

/*
    You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
    There are at least two different characters in letters.
    Return the smallest character in letters that is lexicographically greater than target.
    If such a character does not exist, return the first character in letters.
    see: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */

//buzzwords: binary search

fun main() {
    //'c'
    println(
        Solution744().nextGreatestLetter(
            charArrayOf('c', 'f', 'j'),
            'a'
        )
    )
    //'f'
    println(
        Solution744().nextGreatestLetter(
            charArrayOf('c', 'f', 'j'),
            'c'
        )
    )
    //'x'
    println(
        Solution744().nextGreatestLetter(
            charArrayOf('x', 'x', 'y', 'y'),
            'z'
        )
    )

}

class Solution744 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        if (letters.last() <= target) {
            return letters.first()
        }

        return letters[binarySearchInternal(letters, target, 0, letters.lastIndex)]
    }

    private fun binarySearchInternal(letters: CharArray, target: Char, start: Int, end: Int): Int {
        var startLocal = start
        var endLocal = end
        while (startLocal < endLocal) {
            val mid = (startLocal / 2) + (endLocal / 2)
            if (letters[mid] <= target) {
                startLocal = mid + 1
            } else {
                endLocal = mid
            }
        }
        return endLocal
    }
}
