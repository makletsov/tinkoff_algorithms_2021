package lect_2

import scala.io.StdIn

object E_ApproximateBinarySearch extends App {
  val count = StdIn.readLine()

  val array = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  val numbersToSearch = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  def binarySearch(arr: Array[Int], number: Int): Int = {
    var left = 0
    var right = arr.length - 1

    while (left < right) {
      val mid = (right - left) / 2 + left

      if (arr(mid) == number)
        return arr(mid)

      if (arr(mid) < number)
        left = mid + 1
      else
        right = mid
    }

    if (left > 0 && math.abs(arr(left) - number) >= math.abs(number - arr(left - 1)))
      arr(left - 1)
    else
      arr(left)
  }

  for (n <- numbersToSearch) {
    println(binarySearch(array, n))
  }
}
