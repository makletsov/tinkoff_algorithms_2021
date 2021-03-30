package lect_3

import scala.Array.ofDim
import scala.io.StdIn

object G_HorseTurn_2 extends App {
  val dim = StdIn.readLine()
    .split(" ")
    .map(_.toInt)

  val height = dim(0)
  val width = dim(1)

  def simple(height: Int, width: Int): Int = {
    val matrix = ofDim[Int](height, width)

    matrix(0)(0) = 1

    for (i <- 0 until height - 1)
      for (j <- 0 until width - 1) {
        if (j + 2 < width)
          matrix(i + 1)(j + 2) += matrix(i)(j)
        if (i + 2 < height)
          matrix(i + 2)(j + 1) += matrix(i)(j)
      }

    matrix.last.last
  }

  //  def hard(height: Int, width: Int): Int = {
  //    val dp = ofDim[Int](height, width)
  //
  //    dp(0)(0) = 1
  //
  //    for (i <- 0 until width - 2) {
  //      dp(1)(i + 2) += dp(0)(i)
  //      dp(0)(i + 2) += dp(1)(i)
  //    }
  //
  //    for (i <- 0 until height - 2) {
  //      dp(i + 2)(1) += dp(i)(0)
  //      dp(i + 2)(0) += dp(i)(1)
  //    }
  //
  //    for (i <- 2 until height)
  //      for (j <- 2 until width) {
  //        dp(i)(j) += dp(i - 2)(j - 1) + dp(i - 1)(j - 2)
  //        if (j + 1 < width) dp(i)(j) += dp(i - 2)(j + 1)
  //        if (i + 1 < height) dp(i)(j) += dp(i + 1)(j - 2)
  //      }
  //
  //    for (i <- dp.indices) {
  //      for (j <- dp(i).indices)
  //        print(s"${dp(i)(j)} ")
  //      println()
  //    }
  //    0
  //  }

  def hard(height: Int, width: Int): Int = {
    val dp = ofDim[Int](height, width)

    dp(0)(0) = 1

    for (i <- 0 until width)
      if (i + 4 < width) dp(0)(i + 4) += dp(0)(i)

    for (i <- dp.indices)
      for (j <- dp(i).indices) {
        if (i - 1 >= 0       && j + 2 < width) {
          if (i + 1 < height)                  dp(i + 1)(j + 1) += dp(i)(j)
          if (i + 1 < height && j + 3 < width) dp(i + 1)(j + 3) += dp(i)(j)
          if (                  j + 4 < width) dp(i    )(j + 4) += dp(i)(j)
        }
        if (i + 1 < height && j + 2 < width)  dp(i + 1)(j + 2) += dp(i)(j)
        if (i + 2 < height && j + 1 < width)  dp(i + 2)(j + 1) += dp(i)(j)
        if (j - 1 >= 0     && i + 2 < height) dp(i + 2)(j - 1) += dp(i)(j)
      }

    for (i <- dp.indices)
      for (j <- dp(i).indices)

    for (i <- dp.indices) {
      for (j <- dp(i).indices)
        print(s"${dp(i)(j)} ")
      println()
    }
    0
  }

  hard(height, width)
}
