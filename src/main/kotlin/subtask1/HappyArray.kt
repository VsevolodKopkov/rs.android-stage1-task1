package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        val sedList = sadArray.toCollection(ArrayList())
        var b = true
        while (b) {
            b = false
            for (i in 1 until sedList.size.minus(1)) {
                val sum = sedList[i - 1] + sedList[i + 1]
                if (sedList[i] > sum) {
                    sedList.removeAt(i)
                    b = true
                    break
                }
            }
        }
        return sedList.toIntArray()
    }

}
