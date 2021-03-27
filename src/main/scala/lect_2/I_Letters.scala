package lect_2

import scala.io.StdIn

object I_Letters extends App {
  StdIn.readLine()

  val rooms = StdIn.readLine()
    .split(" ")
    .map(_.toLong)

  val letters = StdIn.readLine()
    .split(" ")
    .map(_.toLong)

  val thresholds = new Array[Long](rooms.length + 1)

  for (i <- thresholds.indices.tail)
    thresholds(i) = thresholds(i - 1) + rooms(i - 1)

  def binarySearch(arr: Array[Long], number: Long): (Int, Long) = {
    var left = 0
    var right = arr.length - 1

    while (right - left > 1) {
      val mid = (right - left) / 2 + left

      if (arr(mid) == number)
        return (mid, rooms(mid - 1))

      if (arr(mid) < number)
        left = mid
      else
        right = mid
    }

    (left + 1, number - arr(left))
  }

  for (j <- letters) {
    val answer = binarySearch(thresholds, j)

    println(answer._1 + " " + answer._2)
  }
}
