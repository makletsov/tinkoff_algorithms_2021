package lect_1

import scala.io.StdIn

object SelectionSort extends App {
  val count = StdIn.readInt()

  val array = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  for (i <- array.indices) {
    var index = i

    for (j <- Range(i, array.length))
      if (array(index) > array(j))
        index = j

    val temp = array(i)
    array(i) = array(index)
    array(index) = temp
  }

  println(array.mkString(" "))
}