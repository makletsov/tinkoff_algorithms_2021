package lect_1

import scala.io.StdIn

object H_Steal extends App {
  StdIn.readInt()

  val array = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  val start = array.min
  val end = array.max

  var count = end - start - array.length + 1

  println(count)
}
