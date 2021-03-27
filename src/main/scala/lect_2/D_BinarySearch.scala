package lect_2

import scala.io.StdIn

object D_BinarySearch extends App {
  val count = StdIn.readLine()

  val array = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  val numbersToSearch = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  def binarySearch(arr: Array[Int], number: Int): Boolean = {
    var left = 0
    var right = arr.length

    while (left < right) {
      val mid = (right - left) / 2 + left

      if (arr(mid) == number)
        return true

      if (arr(mid) < number)
        left = mid + 1
      else
        right = mid
    }

    false
  }

  for (n <- numbersToSearch) {
    if (binarySearch(array, n))
      println("YES")
    else
      println("NO")
  }
}
