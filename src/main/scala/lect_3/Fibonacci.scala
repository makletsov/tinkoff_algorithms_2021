package lect_3

import scala.io.StdIn

object Fibonacci extends App {
  val input = StdIn.readInt()

  val dp = new Array[Int](input + 1)

  for (i <- 0 to 1)
    dp(i) = i

  for (i <- 2 to input)
    dp(i) = dp(i - 1) + dp(i - 2)

  println(dp(input))
}
