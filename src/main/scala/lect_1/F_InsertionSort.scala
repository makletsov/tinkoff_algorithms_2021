package lect_1

import scala.io.StdIn

object F_InsertionSort extends App {
  def swap(array: Array[Int], left: Int, right: Int): Unit = {
    val temp = array(right)
    array(right) = array(left)
    array(left) = temp
  }

  val count = StdIn.readInt()

  val array = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  for (i <- array.indices.tail) {
    var index = i

    while (index > 0 && array(index - 1) > array(index)) {
      swap(array, index - 1, index)
      index -= 1
    }
  }

  println(array.mkString(" "))
}
