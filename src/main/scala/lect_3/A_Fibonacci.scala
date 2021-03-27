package lect_3

/***
 * f1=f2=1 , fn+1=fn+fn−1 при n>2.

 * Входные данные
 * В единственной строке входных данных записано натуральное число n (1≤n≤45).

 * Выходные данные
 * Выведите число fn.

 * Примеры
 * входные данные
 * 2
 * выходные данные
 * 1
 * входные данные
 * 5
 * выходные данные
 * 5
 */

import scala.io.StdIn

object A_Fibonacci extends App {
  val input = StdIn.readInt()

  val dp = new Array[Int](input + 1)

  for (i <- 0 to 1)
    dp(i) = i

  for (i <- 2 to input)
    dp(i) = dp(i - 1) + dp(i - 2)

  println(dp(input))
}
