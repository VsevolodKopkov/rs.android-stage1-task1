package subtask4

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val list = ArrayList<String>()
        var countOpen = 0
        val indexClosedList1 = ArrayList<Int>()
        val indexClosedList2 = ArrayList<Int>()
        val indexClosedList3 = ArrayList<Int>()
        for (i in inputString.indices) {
            when {
                inputString[i] == '(' -> {
                    countOpen = countOpen.plus(1)
                    indexClosedList1.add(i.plus(1))
                }

                inputString[i] == ')' -> {
                    countOpen = countOpen.minus(1)
                    indexClosedList1.add(i)
                }

                inputString[i] == '<' -> {
                    countOpen = countOpen.plus(1)
                    indexClosedList2.add(i.plus(1))
                }

                inputString[i] == '>' -> {
                    countOpen = countOpen.minus(1)
                    indexClosedList2.add(i)
                }

                inputString[i] == '[' -> {
                    countOpen = countOpen.plus(1)
                    indexClosedList3.add(i.plus(1))

                }

                inputString[i] == ']' -> {
                    countOpen = countOpen.minus(1)
                    indexClosedList3.add(i)
                }

                countOpen == 0 -> {

                    if (indexClosedList1.size > 0) {
                        for (e in 0 until indexClosedList1.size) {
                            if (indexClosedList1.size != 0) {
                                list.add(
                                    inputString.substring(
                                        indexClosedList1.first(),
                                        indexClosedList1.last()
                                    )
                                )
                                indexClosedList1.remove(indexClosedList1.first())
                                indexClosedList1.removeAt(indexClosedList1.lastIndex)
                            }
                        }
                    }

                    if (indexClosedList2.size > 0) {
                        for (e in 0 until indexClosedList2.size) {
                            if (indexClosedList2.size != 0) {
                                list.add(
                                    inputString.substring(
                                        indexClosedList2.first(),
                                        indexClosedList2.last()
                                    )
                                )
                                indexClosedList2.remove(indexClosedList2.first())
                                indexClosedList2.removeAt(indexClosedList2.lastIndex)
                            }
                        }
                    }

                    if (indexClosedList3.size > 0) {
                        for (e in 0 until indexClosedList3.size) {
                            if (indexClosedList3.size != 0) {
                                list.add(
                                    inputString.substring(
                                        indexClosedList3.first(),
                                        indexClosedList3.last()
                                    )
                                )
                                indexClosedList3.remove(indexClosedList3.first())
                                indexClosedList3.removeAt(indexClosedList3.lastIndex)
                            }
                        }
                    }
                }
            }
        }
        if (countOpen == 0) {

            if (indexClosedList1.size > 0) {
                for (e in 0 until indexClosedList1.size) {
                    if (indexClosedList1.size != 0) {
                        list.add(
                            inputString.substring(
                                indexClosedList1.first(),
                                indexClosedList1.last()
                            )
                        )
                        indexClosedList1.remove(indexClosedList1.first())
                        indexClosedList1.removeAt(indexClosedList1.lastIndex)
                    }
                }
            }

            if (indexClosedList2.size > 0) {
                for (e in 0 until indexClosedList2.size) {
                    if (indexClosedList2.size != 0) {
                        list.add(
                            inputString.substring(
                                indexClosedList2.first(),
                                indexClosedList2.last()
                            )
                        )
                        indexClosedList2.remove(indexClosedList2.first())
                        indexClosedList2.removeAt(indexClosedList2.lastIndex)
                    }
                }
            }

            if (indexClosedList3.size > 0) {
                for (e in 0 until indexClosedList3.size) {
                    if (indexClosedList3.size != 0) {
                        list.add(
                            inputString.substring(
                                indexClosedList3.first(),
                                indexClosedList3.last()
                            )
                        )
                        indexClosedList3.remove(indexClosedList3.first())
                        indexClosedList3.removeAt(indexClosedList3.lastIndex)
                    }
                }
            }
        }
        return list.toTypedArray()
    }
}