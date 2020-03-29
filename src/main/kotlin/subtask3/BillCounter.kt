package subtask3

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val billList = bill.toCollection(ArrayList())
        var sumB = 0
        var sumN = 0
        var sb = 0
        var sn = 0

            billList.forEachIndexed { index, e ->
                sumN = sumN.plus(e)
                if (index == k){
                    sumB = sumB.plus(e)
                }
            }

        sn = (sumN - sumB)/2
        sb = b - sn
        return if (sn == b){
            "Bon Appetit"
        } else sb.toString()
    }
}
