package july

/*
    Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b
    to make ( a OR b == c ). (bitwise OR operation).
    Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
    see: https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/
 */

//buzzwords: Bitwise operation https://kotlinlang.org/docs/numbers.html#bitwise-operations

fun main() {
    //3
    println(Solution1318().minFlips(2, 6, 5))
    //1
    println(Solution1318().minFlips(4, 2, 7))
    //0
    println(Solution1318().minFlips(1, 2, 3))
    //3
    println(Solution1318().minFlipsV2(2, 6, 5))
    //1
    println(Solution1318().minFlipsV2(4, 2, 7))
    //0
    println(Solution1318().minFlipsV2(1, 2, 3))
}

class Solution1318 {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        var result = 0
        val ab = a.or(b)
        val xor = ab.xor(c)
        for (i in 0 until 31) {
            val mask = 1 shl i
            if (xor.and(mask) > 0) {
                result += (if (a.and(mask) == b.and(mask) && c.and(mask) == 0) {
                    2
                } else {
                    1
                })
            }
        }
        return result
    }

    // another version, when we're going from left to the right
    fun minFlipsV2(a: Int, b: Int, c: Int): Int {
        var result = 0
        val ab = a.or(b)
        var xor = ab.xor(c)
        var localA = a
        var localB = b
        var localC = c
        while (localA > 0 || localB > 0 || localC > 0) {
            val minA = localA and 1
            val minB = localB and 1
            val minC = localC and 1

            if (xor and 1 == 1) {
                result += if (minA == minB && minC == 0) {
                    2
                } else {
                    1
                }
            }

            xor = xor shr 1
            localA = localA shr 1
            localB = localB shr 1
            localC = localC shr 1
        }
        return result
    }

}
