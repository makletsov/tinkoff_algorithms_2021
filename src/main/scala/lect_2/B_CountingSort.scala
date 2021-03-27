package lect_2

import scala.io.StdIn

object B_CountingSort extends App {
  val count = StdIn.readInt()

  val array = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  val countingArray = new Array[Int](20001)

  for (i <- array) {
    countingArray(i + 10000) += 1
  }

  val builder = new StringBuilder

  for (i <- countingArray.indices) {
    for (_ <- Range(0, countingArray(i))) {
      builder.append(i - 10000).append(" ")
    }
  }

  val str = builder.toString().trim

  println(str)
}
