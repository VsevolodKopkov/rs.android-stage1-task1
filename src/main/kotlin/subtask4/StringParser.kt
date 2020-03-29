package subtask4

class StringParser {

        private val squareBraces = '[' to ']'
        private val angleBraces = '<' to '>'
        private val roundBraces = '(' to ')'

        private val ignoreIndexes = arrayListOf<Int>()

        // TODO: Complete the following function
        fun getResult(inputString: String): Array<String> {

            val wordsInBraces = arrayListOf<String>()

            for (i in inputString.indices) {
                val c = inputString[i]

                if (ignoreIndexes.contains(i)) continue

                when (c) {
                    squareBraces.first -> {
                        val s = findCloseBrace(inputString.substring(i.plus(1)), squareBraces, i)
                        ignoreIndexes.add(i)
                        wordsInBraces.add(s)
                    }
                    angleBraces.first -> {
                        val s = findCloseBrace(inputString.substring(i.plus(1)), angleBraces, i)
                        ignoreIndexes.add(i)
                        wordsInBraces.add(s)
                    }
                    roundBraces.first -> {
                        val s = findCloseBrace(inputString.substring(i.plus(1)), roundBraces, i)
                        ignoreIndexes.add(i)
                        wordsInBraces.add(s)
                    }
                }
            }
            return wordsInBraces.toTypedArray()
        }

        private fun findCloseBrace(
            substring: String,
            bracesPair: Pair<Char, Char>,
            lengthBefore: Int
        ): String {
            var counter = 0
            var result = ""

            for (i in substring.indices) {
                val c = substring[i]

                if (ignoreIndexes.contains(i)) continue

                when (c) {
                    bracesPair.first -> counter++
                    bracesPair.second -> {
                        if (counter == 0) {
                            result = substring.substring(0, i)
                            ignoreIndexes.add(i.plus(lengthBefore))
                        } else counter--
                    }
                }
                if (result.isNotEmpty()) break
            }

            if (result.isEmpty()) throw IllegalArgumentException("inputString does not contain close brace")

            return result
        }
//        val list = ArrayList<String>()
//        var countOpen1 = 0
//        var countOpen2 = 0
//        var countOpen3 = 0
//        val indexList1 = ArrayList<Int>()
//        val indexClosedList1 = ArrayList<Int>()
//        val indexClosedList2 = ArrayList<Int>()
//        val indexClosedList3 = ArrayList<Int>()
//        for (i in inputString.indices) {
//            when {
//                inputString[i] == '(' -> {
//                    countOpen1 = countOpen1.plus(1)
//                    indexList1.add(i.plus(1))
//                }
//
//                inputString[i] == ')' -> {
//                    countOpen1 = countOpen1.minus(1)
//                    indexClosedList1.add(i)
//                    if (countOpen1 == 0) {
//                        for (e in 0 until indexList1.size) {
//                            if (indexClosedList1.size > 0) {
//                                list.add(
//                                    inputString.substring(
//                                        indexList1.first(),
//                                        indexClosedList1.last()
//                                    )
//                                )
//                                if (indexClosedList1.size != 0) {
//                                    indexList1.remove(indexList1.first())
//                                    indexClosedList1.removeAt(indexClosedList1.lastIndex)
//                                }
//                            }
//
//                            if (indexClosedList2.size > 0) {
//                                list.add(
//                                    inputString.substring(
//                                        indexList1.first(),
//                                        indexClosedList2.last()
//                                    )
//                                )
//                                if (indexClosedList2.size != 0) {
//                                    indexList1.remove(indexList1.first())
//                                    indexClosedList2.removeAt(indexClosedList2.lastIndex)
//                                }
//                            }
//
//                            if (indexClosedList3.size > 0) {
//                                list.add(
//                                    inputString.substring(
//                                        indexList1.first(),
//                                        indexClosedList3.last()
//                                    )
//                                )
//                                if (indexClosedList3.size != 0) {
//                                    indexList1.remove(indexList1.first())
//                                    indexClosedList3.removeAt(indexClosedList3.lastIndex)
//                                }
//                            }
//                        }
//                    }
//                }
//
//                inputString[i] == '<' -> {
//                    countOpen2 = countOpen2.plus(1)
//                    indexList1.add(i.plus(1))
//                }
//
//                inputString[i] == '>' -> {
//                    countOpen2 = countOpen2.minus(1)
//                    indexClosedList2.add(i)
//                    if (countOpen2 == 0) {
//                        for (e in 0 until indexList1.size) {
//                            if (indexClosedList1.size > 0) {
//                                list.add(
//                                    inputString.substring(
//                                        indexList1.first(),
//                                        indexClosedList1.last()
//                                    )
//                                )
//                                if (indexClosedList1.size != 0) {
//                                    indexList1.remove(indexList1.first())
//                                    indexClosedList1.removeAt(indexClosedList1.lastIndex)
//                                }
//                            }
//
//                            if (indexClosedList2.size > 0) {
//                                list.add(
//                                    inputString.substring(
//                                        indexList1.first(),
//                                        indexClosedList2.last()
//                                    )
//                                )
//                                if (indexClosedList2.size != 0) {
//                                    indexList1.remove(indexList1.first())
//                                    indexClosedList2.removeAt(indexClosedList2.lastIndex)
//                                }
//                            }
//
//                            if (indexClosedList3.size > 0) {
//                                list.add(
//                                    inputString.substring(
//                                        indexList1.first(),
//                                        indexClosedList3.last()
//                                    )
//                                )
//                                if (indexClosedList3.size != 0) {
//                                    indexList1.remove(indexList1.first())
//                                    indexClosedList3.removeAt(indexClosedList3.lastIndex)
//                                }
//                            }
//                        }
//                    }
//                }
//
//                inputString[i] == '[' -> {
//                    countOpen3 = countOpen3.plus(1)
//                    indexList1.add(i.plus(1))
//                }
//
//                inputString[i] == ']' -> {
//                    countOpen3 = countOpen3.minus(1)
//                    indexClosedList3.add(i)
//                    if (countOpen3 == 0) {
//                        for (e in 0 until indexList1.size) {
//                            if (indexClosedList1.size > 0) {
//                                list.add(
//                                    inputString.substring(
//                                        indexList1.first(),
//                                        indexClosedList1.last()
//                                    )
//                                )
//                                if (indexClosedList1.size != 0) {
//                                    indexList1.remove(indexList1.first())
//                                    indexClosedList1.removeAt(indexClosedList1.lastIndex)
//                                }
//                            }
//
//                            if (indexClosedList2.size > 0) {
//                                list.add(
//                                    inputString.substring(
//                                        indexList1.first(),
//                                        indexClosedList2.last()
//                                    )
//                                )
//                                if (indexClosedList2.size != 0) {
//                                    indexList1.remove(indexList1.first())
//                                    indexClosedList2.removeAt(indexClosedList2.lastIndex)
//                                }
//                            }
//
//                            if (indexClosedList3.size > 0) {
//                                list.add(
//                                    inputString.substring(
//                                        indexList1.first(),
//                                        indexClosedList3.last()
//                                    )
//                                )
//                                if (indexClosedList3.size != 0) {
//                                    indexList1.remove(indexList1.first())
//                                    indexClosedList3.removeAt(indexClosedList3.lastIndex)
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return list.toTypedArray()
//    }
}

