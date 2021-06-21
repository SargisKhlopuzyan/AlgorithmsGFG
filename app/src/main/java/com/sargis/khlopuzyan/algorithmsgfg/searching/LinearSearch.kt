package com.sargis.khlopuzyan.algorithmsgfg.searching

/**
 * Created by Sargis Khlopuzyan, on 6/21/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 *
 * https://www.geeksforgeeks.org/linear-search/
 */
fun main() {
    val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = linearSearch2(array, 5)
//    val result = linearSearch1(array, 7)
    if (result == -1)
        println("Element is not present in array")
    else
        println("Element is present at index $result")
}

/**
 * Improve Linear Search Worst-Case Complexity
 * 1) if element Found at last  O(n) to O(1)
 * 2) if element Not found O(n) to O(n/2)
 * */
fun linearSearch2(array: Array<Int>, x: Int): Int {
    var left = 0
    var right = array.size - 1

    while (left <= right) {
        println("left: $left")
        when (x) {
            array[left] -> return left
            array[right] -> return right
            else -> {
                left++
                right--
            }
        }
    }
    return -1
}

/**
 * The time complexity of the linear search algorithm is O(n)
 * */
fun linearSearch1(array: Array<Int>, x: Int): Int {
    for (i in 0..array.size) {
        if (x == array[i]) {
            return i
        }
    }
    return -1
}