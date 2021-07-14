package com.sargis.khlopuzyan.algorithmsgfg.searching

/**
 * Created by Sargis Khlopuzyan, on 6/21/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 *
 * https://www.geeksforgeeks.org/interpolation-search/
 */
fun main() {
    val array = arrayOf(0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 1010)
    val result = interpolationSearch(array, x = 99)
    if (result == -1)
        println("Element is not present in array")
    else
        println("Element is present at index $result")
}

/**
 * The time complexity of the interpolation search algorithm is O(log2(log2 n)) for the average case,
 * and O(n) for the worst case (when items are distributed exponentially)
 * */
fun interpolationSearch(array: Array<Int>, low: Int = 0, high: Int = array.size - 1, x: Int): Int {

    if (array.isEmpty()) return -1

    val pos: Int

    if (low <= high && x >= array[low] && x <= array[high]) {

        // Probing the position with keeping uniform distribution in mind.
        pos = low + (x - array[low]) * (high - low) / (array[high] - array[low])

        println("Inside interpolationSearch => pos: $pos")

        // Condition of target found
        if (array[pos] == x) return pos

        // If x is larger, x is in right sub array
        if (array[pos] < x) return interpolationSearch(array, pos + 1, high, x)

        // If x is smaller, x is in left sub array
        if (array[pos] > x) return interpolationSearch(array, low, pos - 1, x)
    }

    return -1
}