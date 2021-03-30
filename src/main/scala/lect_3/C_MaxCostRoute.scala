package lect_3

/**
 * В левом верхнем углу прямоугольной таблицы размером n⋅m находится черепашка. В каждой клетке таблицы записано некоторое число.
 * Черепашка может перемещаться вправо или вниз, при этом маршрут черепашки заканчивается в правом нижнем углу таблицы.

 * Подсчитаем сумму чисел, записанных в клетках, через которую проползла черепашка (включая начальную и конечную клетку).
 * Найдите наибольшее возможное значение этой суммы и маршрут, на котором достигается эта сумма.

 * Входные данные
 * В первой строке входных данных записаны два натуральных числа n и m, не превосходящих 100 — размеры таблицы.
 * Далее идет n строк, каждая из которых содержит m чисел, разделенных пробелами — описание таблицы.
 * Все числа в клетках таблицы целые и могут принимать значения от 0 до 100.

 * Выходные данные
 * Первая строка выходных данных содержит максимальную возможную сумму, вторая – маршрут, на котором достигается эта сумма.
 * Маршрут выводится в виде последовательности, которая должна содержать n−1 букву D, означающую передвижение вниз,
 * и m−1 букву R, означающую передвижение направо. Если таких последовательностей несколько, необходимо вывести ровно одну (любую) из них.

 * Пример
 * входные данные
 * 5 5
 * 9 9 9 9 9
 * 3 0 0 0 0
 * 9 9 9 9 9
 * 6 6 6 6 8
 * 9 9 9 9 9
 * выходные данные
 * 74
 * D D R R R R D D
 * */

import scala.Array.ofDim
import scala.annotation.tailrec
import scala.io.StdIn

object C_MaxCostRoute extends App {
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