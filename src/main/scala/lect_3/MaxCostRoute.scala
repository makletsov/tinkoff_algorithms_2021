package lect_3

import scala.Array.ofDim
import scala.annotation.tailrec
import scala.io.StdIn

object MaxCostRoute extends App {
  def getInput(height: Int, width: Int): Array[Array[Int]] = {
    val matrix = ofDim[Int](height, width)

    for (i <- 0 until height) {
      val row = StdIn.readLine()
        .split(" ")
        .map(_.toInt)

      for (j <- row.indices)
        matrix(i)(j) = row(j)
    }

    matrix
  }

  def getSums(input: Array[Array[Int]]): Array[Array[Int]] = {
    val matrix = ofDim[Int](height, width)

    matrix(0)(0) = input(0)(0)

    for (i <- 1 until width)
      matrix(0)(i) = matrix(0)(i - 1) + input(0)(i)

    for (i <- 1 until height)
      matrix(i)(0) = matrix(i - 1)(0) + input(i)(0)

    for (i <- 1 until height)
      for (j <- 1 until width)
        matrix(i)(j) = math.max(matrix(i - 1)(j), matrix(i)(j - 1)) + input(i)(j)

    matrix
  }

  @tailrec
  def getTrace(arr: Array[Array[Int]], row: Int, column: Int, trace: List[String]): List[String] =
    (row, column) match {
      case (0, 0) => trace
      case (0, _) => List.fill(column)("R") ::: trace
      case (_, 0) => List.fill(row)("D") ::: trace
      case (_, _) if arr(row - 1)(column) > arr(row)(column - 1) => getTrace(arr, row - 1, column, "D" :: trace)
      case _      => getTrace(arr, row, column - 1, "R" :: trace)
    }

  val dimensions = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  val height = dimensions(0)
  val width = dimensions(1)
  val input = getInput(height, width)
  val sums = getSums(input)

  println(sums.last.last)

  var row = height - 1
  var column = width - 1

  println(getTrace(sums, row, column, Nil).mkString(" "))
}