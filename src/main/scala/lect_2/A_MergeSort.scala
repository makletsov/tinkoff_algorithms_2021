package lect_2

import scala.annotation.tailrec
import scala.io.StdIn

object A_MergeSort extends App {
  val count = StdIn.readInt()

  val list = StdIn.readLine()
    .split(" ")
    .map(_.toInt)
    .toVector

  def divide(list: Vector[Int]): Vector[Int] =
    if (list.length > 1) {
      val (left, right) = list.splitAt(list.length / 2)

      merge(divide(left), divide(right))
    } else
      list


  def merge(list1: Vector[Int], list2: Vector[Int]): Vector[Int] = {
    @tailrec
    def helper(list1: Vector[Int], list2: Vector[Int], acc: Vector[Int]): Vector[Int] =
      (list1, list2, acc) match {
        case (xs, ys, _) if xs.isEmpty || ys.isEmpty => acc ++ xs ++ ys
        case (xs, ys, _) if xs.head < ys.head => helper(xs.tail, ys, acc :+ xs.head)
        case (xs, ys, _) => helper(xs, ys.tail, acc :+ ys.head)
      }

    helper(list1, list2, Vector.empty)
  }

  println(divide(list).mkString(" "))
}