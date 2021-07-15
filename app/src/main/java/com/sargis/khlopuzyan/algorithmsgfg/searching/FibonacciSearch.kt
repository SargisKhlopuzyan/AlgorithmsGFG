package com.sargis.khlopuzyan.algorithmsgfg.searching

/**
 * Created by Sargis Khlopuzyan, on 7/15/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    val array = arrayOf(0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 1010)
    val result = fibMonaccianSearch(array, x = 99)
    if (result == -1)
        println("Element is not present in array")
    else
        println("Element is present at index $result")
}

/**
 * The worst-case will occur when we have our target in the larger (2/3) fraction of the array, as we proceed to find it.
 * In other words, we are eliminating the smaller (1/3) fraction of the array every time.
 * We call once for n, then for(2/3) n, then for (4/9) n, and henceforth.
 *
 * for n~c*1.62e(n') we make O(n') comparisons. We, thus, need 0(log n) comparisons.
 * */
fun fibMonaccianSearch(array: Array<Int>, x: Int): Int {

    if (array.isEmpty()) return -1

    /** Initialize fibonacci numbers */
    var fibMMm2 = 0 // (m-2)'th Fibonacci No.

    var fibMMm1 = 1 // (m-1)'th Fibonacci No.

    var fibM = fibMMm2 + fibMMm1 // m'th Fibonacci

    /**
     * fibM is going to store the smallest Fibonacci Number greater than or equal to n
     * */
    while (fibM < array.size) {
        fibMMm2 = fibMMm1
        fibMMm1 = fibM
        fibM = fibMMm2 + fibMMm1
    }

    // Marks the eliminated range from front
    var offset = -1

    /**
     * While there are elements to be inspected.
     * Note that we compare arr[fibMm2] with x.
     * When fibM becomes 1, fibMm2 becomes 0
     * */
    while (fibM > 1) {

        // Check if fibMm2 is a valid location
        val i = min(offset + fibMMm2, array.size - 1)

        when {
            /**
             * If x is greater than the value at
             * index fibMm2, cut the subarray array
             * from offset to i
             * */
            array[i] < x -> {
                fibM = fibMMm1
                fibMMm1 = fibMMm2
                fibMMm2 = fibM - fibMMm1
                offset = i
            }
            /**
             * If x is less than the value at index fibMm2,
             * cut the subarray after i+1
             * */
            array[i] > x -> {
                fibM = fibMMm2
                fibMMm1 -= fibMMm2
                fibMMm2 = fibM - fibMMm1
            }
            /**
             * element found. return index
             * */
            else -> {
                return i
            }
        }

    }

    /**
     * Comparing the last element with x
     * */
    if (fibMMm1 == 1 && array[array.size - 1] == x) {
        return array.size - 1
    }

    /**
     * Element not found. return -1
     * */
    return -1

}

// Utility function to find minimum of two elements
fun min(x: Int, y: Int): Int {
    return if (x <= y) x else y
}