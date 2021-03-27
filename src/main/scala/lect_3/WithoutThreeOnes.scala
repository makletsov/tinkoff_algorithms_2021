package lect_3

import scala.io.StdIn

object WithoutThreeOnes extends App {
  def func(num: Int): Int = {
    val length = if (num < 2) 3 else num + 1

    val dp = new Array[Int](length)

    dp(0) = 1
    dp(1) = 2
    dp(2) = 4

    if (num > 2)
      for (i <- 3 to num)
        dp(i) = dp(i - 1) + dp(i - 2) + dp(i - 3)

    dp(num)
  }

  val input = StdIn.readInt()

  val answer = if (input < 0) 0 else func(input)

  println(answer)
}
