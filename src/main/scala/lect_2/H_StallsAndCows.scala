package lect_2

import scala.annotation.tailrec
import scala.io.StdIn

object H_StallsAndCows extends App {
  val distsCount = StdIn.readLine
    .split(" ")
    .map(_.toInt)
    .array(1) - 1

  val coordinates = StdIn.readLine
    .split(" ")
    .map(_.toInt)
    .toSeq

  val maxDistance = (coordinates.last - coordinates.head) / distsCount
  val possibleAnswers = Range.inclusive(1, maxDistance + 1)

  val distances = (for (
    i <- coordinates.indices.tail
  ) yield coordinates(i) - coordinates(i - 1)).toList

  @tailrec
  def countDists(dists: List[Int], dist: Int, appended: Int, counter: Int): Int =
    dists match {
      case x :: xs if x + appended >= dist => countDists(xs, dist, 0, counter + 1)
      case x :: xs                         => countDists(xs, dist, x + appended, counter)
      case _                               => counter
    }

  def canGetWithDistance(dists: List[Int], dist: Int, count: Int): Boolean =
    if (countDists(dists, dist, 0, 0) >= count)
      true
    else
      false

  def search(possibleAnswers: Seq[Int], dists: List[Int], count: Int): Int = {
    def getNextIndex(left: Int, right: Int): Int =
      left + (right - left) / 2

    @tailrec
    def guess(left: Int, right: Int, count: Int): Int = {
      val distIndex = getNextIndex(left, right)

      if (right - left <= 1)
        distIndex
      else if (canGetWithDistance(dists, distIndex, count))
        guess(distIndex, right, count)
      else
        guess(left, distIndex, count)
    }

    guess(possibleAnswers.head,possibleAnswers.last, count)
  }

  println(search(possibleAnswers, distances, distsCount))
}

