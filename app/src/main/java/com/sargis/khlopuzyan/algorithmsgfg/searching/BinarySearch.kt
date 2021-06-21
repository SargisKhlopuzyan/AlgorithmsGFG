package com.sargis.khlopuzyan.algorithmsgfg.searching

/**
 * Created by Sargis Khlopuzyan, on 6/21/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 *
 * https://www.geeksforgeeks.org/binary-search/
 */
fun main() {
    val array = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val result = binarySearch(array, x = 9)
    if (result == -1)
        println("Element is not present in array")
    else
        println("Element is present at index $result")
}

/**
 * The time complexity of the binary search algorithm is O(log n)
 * */
fun binarySearch(array: Array<Int>, left: Int = 0, right: Int = array.size - 1, x: Int): Int {

    if (left > right) return -1

    val mid = left + (right - left) / 2
    println("Inside binarySearch => mid : $mid")

    return when {
        x == array[mid] -> mid
        x < array[mid] -> binarySearch(array, left, mid - 1, x)
        x > array[mid] -> binarySearch(array, mid + 1, right, x)
        else -> -1
    }
}