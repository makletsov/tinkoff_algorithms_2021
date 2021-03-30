package lect_3

/**
 * Определите количество последовательностей из нулей и единиц длины n, в которых никакие три единицы не стоят рядом.

 * Входные данные
 * Вводится натуральное число n, не превосходящее 40.

 * Выходные данные
 * Выведите количество искомых последовательностей. Гарантируется, что ответ не превосходит 231−1.

 * Пример
 * входные данныеСкопировать
 * 3
 * выходные данныеСкопировать
 * 7
 * */

import scala.io.StdIn

object B_WithoutThreeOnes extends App {
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
