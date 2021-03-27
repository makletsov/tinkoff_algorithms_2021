package lect_2

import scala.annotation.tailrec
import scala.io.StdIn

object G_FloatingBinarySearch extends App {
  def func(number: Double) =
    math.pow(number, 2) + math.pow(number, 0.5)

  def isItLower(current: Double, necessary: Double): Boolean =
    func(current) - necessary >= 0

  def getNextGuessNumber(left: Double, right: Double): Double =
    left + (right - left) / 2

  def giveAnswer(answer: Double): Unit =
    printf("%.20f", answer)

  @tailrec
  def guess(left: Double, right: Double, necessary: Double, remainingGuesses: Int): Double = {
    val current = getNextGuessNumber(left, right)

    if (right - left < 0.0000001 && remainingGuesses <= 0)
      current
    else if (isItLower(current, necessary))
      guess(left, current, necessary, remainingGuesses - 1)
    else
      guess(current, right, necessary, remainingGuesses - 1)
  }

  val inputNumber = StdIn.readDouble

  giveAnswer(guess(1.0, 10000000000.0, inputNumber, 100))
}
