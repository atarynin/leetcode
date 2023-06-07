package july

fun main() {
    //3
    println(Solution1318().minFlips(2, 6, 5))
    //1
    println(Solution1318().minFlips(4, 2, 7))
    //0
    println(Solution1318().minFlips(1, 2, 3))
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
}
