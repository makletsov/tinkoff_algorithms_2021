package lect_2

import scala.io.StdIn

case class Laptop(cost: Int, quality: Int)

object Laptops extends App {
  val count = StdIn.readInt()

  val array: Array[Laptop] = new Array[Laptop](count)

  for (i <- Range(0, count)) {
    val digits = StdIn.readLine()
      .split(" ")
      .map(_.toInt)

    array(i) = Laptop(digits(0), digits(1))
  }

  if (array.sortBy(l => (l.cost, l.quality)) sameElements array.sortBy(l => (l.quality, l.cost)))
    println("Poor Alex")
  else
    println("Happy Alex")
}

