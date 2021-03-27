package lect_1

import scala.io.StdIn

object APlusB extends App {
  val sum = StdIn.readLine().split(' ').map(_.toInt).sum

  println(sum)
}
