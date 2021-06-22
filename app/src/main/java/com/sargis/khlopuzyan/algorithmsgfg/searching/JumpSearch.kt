package com.sargis.khlopuzyan.algorithmsgfg.searching

import kotlin.math.floor
import kotlin.math.min
import kotlin.math.sqrt

/**
 * Created by Sargis Khlopuzyan, on 6/21/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 *
 * https://www.geeksforgeeks.org/jump-search/
 */
fun main() {
    val array = arrayOf(0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 1010)
    val result = jumpSearch(array, x = 88)
    if (result == -1)
        println("Element is not present in array")
    else
        println("Element is present at index $result")
}

/**
 * The time complexity of the jump search algorithm is O(√n)
 * */
fun jumpSearch(array: Array<Int>, x: Int): Int {

    if (array.isEmpty()) return -1

    val n = array.size

    // Finding block size to be jumped
    var step: Int = floor(sqrt(n.toDouble())).toInt()

    // Finding the block where element is present (if it is present)
    var prev = 0

    while (array[min(step, n) - 1] < x) {
        println("Inside jumpSearch => while1 => step: $step || prev: $prev")
        prev = step
        step += floor(sqrt(n.toDouble())).toInt()

        if (prev >= n) return -1
    }

    // Doing a linear search for x in block beginning with prev.
    while (array[prev] < x) {
        println("Inside jumpSearch => while2 => step: $step || prev: $prev")
        prev++

        // If we reached next block or end of array, element is not present.
        if (prev == min(step, n)) return -1
    }

    // If element is found
    if (array[prev] == x) return prev

    return -1
}