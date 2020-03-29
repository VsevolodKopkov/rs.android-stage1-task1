package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
        val inputList = input.toCollection(ArrayList())
        var maxSum = Integer.MIN_VALUE
        var minSum = Integer.MAX_VALUE
        for(i in 0 until inputList.size){
            var sum = 0
            inputList.forEachIndexed { index, e ->
                if (index != i){
                    sum = sum.plus(e)
                }
            }
            if (maxSum < sum) {
                maxSum = sum
            }
            if (minSum > sum) {
                minSum = sum
            }
        }
        return intArrayOf(minSum, maxSum)
    }
}
