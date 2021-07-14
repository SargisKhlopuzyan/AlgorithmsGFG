package com.sargis.khlopuzyan.algorithmsgfg.searching

import java.util.*
import kotlin.math.min

/**
 * Created by Sargis Khlopuzyan, on 7/14/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 *
 * https://www.geeksforgeeks.org/exponential-search/
 */
fun main() {
    val array = arrayOf(0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 1010)
    val result = exponentialSearch(array, x = 9999)
    if (result < -1)
        println("Element is not present in array")
    else
        println("Element is present at index $result")
}

/**
 * The time complexity of the exponential search algorithm is O(log n)
 * */
fun exponentialSearch(array: Array<Int>, x: Int): Int {

    if (array.isEmpty()) return -1

    // If x is present at first location itself
    if (array[0] == x) {
        return 0
    }

    // Find range for binary search by repeated doubling
    var i = 1
    while (i < array.size && array[i] < x) {
        i *= 2
    }

    return Arrays.binarySearch(array, i / 2, min(i, array.size - 1), x)
}