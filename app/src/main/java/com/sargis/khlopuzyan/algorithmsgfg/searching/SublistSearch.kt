package com.sargis.khlopuzyan.algorithmsgfg.searching

/**
 * Created by Sargis Khlopuzyan, on 7/14/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {

    /**
     * Let us create two linked lists to test the above functions. Created lists shall be
     * a: 1->2->3->4
     * b: 1->2->1->2->3->4
     */

    val a: Node = newNode(1)
    a.next = newNode(2)
    a.next?.next = newNode(3)
    a.next?.next?.next = newNode(4)

    val b: Node = newNode(1)
    b.next = newNode(2)
    b.next?.next = newNode(1)
    b.next?.next?.next = newNode(2)
    b.next?.next?.next?.next = newNode(3)
    b.next?.next?.next?.next?.next = newNode(4)

    if (findList(a, b))
        println("List Found")
    else
        println("List Not Found")
}

class Node(var data: Int? = null, var next: Node? = null)

fun newNode(key: Int) = Node(data = key)

/**
 * Returns true if first list is present in second list
 */
fun findList(first: Node?, _second: Node?): Boolean {

    // If both linked lists are empty, return true
    if (first == null && _second == null)
        return false

    // Else If one is empty and other is not, return false
    if (first == null || (_second == null))
        return false

    var second = _second
    var ptr1 = first
    var ptr2: Node?

    // Traverse the second list by picking nodes one by one
    while (second != null) {

        // Initialize ptr2 with current node of second
        ptr2 = second

        // Start matching first list with second list
        while (ptr1 != null) {

            // If second list becomes empty and first not then return false
            if (ptr2 == null) {
                return false
            }
            // If data part is same, go to next of both lists
            else if (ptr1.data == ptr2.data) {
                ptr1 = ptr1.next
                ptr2 = ptr2.next
            }
            // If not equal then break the loop
            else {
                break
            }
        }

        // Return true if first list gets traversed completely that means it is matched.
        if (ptr1 == null) {
            return true
        }

        // Initialize ptr1 with first again
        ptr1 = first

        // And go to next node of second list
        second = second.next
    }

    return false
}