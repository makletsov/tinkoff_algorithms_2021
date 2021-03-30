package lect_3

/**
 * Дана прямоугольная доска n×m (n строк и m столбцов). В левом верхнем углу находится шахматный конь,
 * которого необходимо переместить в правый нижний угол доски. При этом конь может ходить только на две клетки вниз и
 * на одну клетку вправо, либо на две клетки вправо и на одну клетку вниз. Необходимо определить,
 * сколько существует различных маршрутов, ведущих из левого верхнего в правый нижний угол.

 * Входные данные
 * В первой строке входного файла находятся два натуральных числа n и m (1 ≤ n, m ≤ 50).

 * Выходные данные
 * Выведите единственное число количество способов добраться конём до правого нижнего угла доски.
 * */

import scala.Array.ofDim
import scala.io.StdIn

object F_HorseTurn extends App {
  val dim = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  val height = dim(0)
  val width = dim(1)

  val matrix = ofDim[Int](height, width)

  matrix(0)(0) = 1

  for (i <- 0 until height - 1)
    for (j <- 0 until width - 1) {
      if (j + 2 < width)
        matrix(i + 1)(j + 2) += matrix(i)(j)
      if (i + 2 < height)
        matrix(i + 2)(j + 1) += matrix(i)(j)
    }

  println(matrix.last.last)
}
