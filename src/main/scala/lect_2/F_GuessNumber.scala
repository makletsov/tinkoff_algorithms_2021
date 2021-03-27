package lect_2

import scala.annotation.tailrec
import scala.io.StdIn

object F_GuessNumber extends App {
  def makeGuess(num: Int): Unit =
    println(num)

  def isItLower: Boolean =
    StdIn.readLine == "<"

  def getNextGuessNumber(left: Int, right: Int): Int =
    left + (right - left) / 2

  def giveAnswer(answer: Int): Unit =
    println("! " + answer)

  @tailrec
  def guess(left: Int, right: Int): Int = {
    val current = getNextGuessNumber(left, right)
    makeGuess(current)

    if (right - left <= 1)
      current
    else if (isItLower)
      guess(left, current)
    else
      guess(current, right)
  }

  giveAnswer(guess(1, 1000001))
}
