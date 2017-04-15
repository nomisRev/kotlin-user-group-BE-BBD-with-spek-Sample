package com.github.nomisRev

fun fibonacci(n: Int): Int {
    tailrec fun loop(n: Int, previous: Int, current: Int): Int =
            if (n == 0) previous else loop(n - 1, current, previous + current)

    return loop(n, 0, 1)
}