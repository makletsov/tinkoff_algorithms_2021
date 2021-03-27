package lect_1

import scala.io.StdIn

object BubbleSort extends App {
  def swap(array: Array[Int], left: Int, right: Int): Unit = {
    val temp = array(right)
    array(right) = array(left)
    array(left) = temp
  }

  val count = StdIn.readInt()

  val array = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  for (i <- array.indices.reverse) {
    for (j <- 1 to i)
      if (array(j - 1) > array(j))
        swap(array, j - 1, j)
  }

  println(array.mkString(" "))
}
