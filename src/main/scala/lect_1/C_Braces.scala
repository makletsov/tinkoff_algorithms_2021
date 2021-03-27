package lect_1

import scala.io.StdIn

object Braces extends App {
  val str = StdIn.readLine()

  val stack = new SimpleStack[Char]

  val map = Map(
    '(' -> ')',
    '[' -> ']',
    '{' -> '}',
  )
  val open = map.keys.toSeq

  try {
    for (ch <- str) {
      if (open.contains(ch))
        stack.push(ch)
      else if (map(stack.back) == ch)
        stack.pop
      else
        throw new Exception
    }

    if (stack.size == 0)
      println("yes")
    else
      println("no")
  } catch {
    case _: Exception => println("no")
  }
}

class SimpleStack[A] {
  private var list = List.empty[A]

  def push(elem: A): Unit =
    list = elem :: list

  def pop: A =
    list match {
      case x :: xs =>
        list = xs
        x
      case _ =>
        throw new Exception
    }

  def back: A =
    list match {
      case x :: _ => x
      case _ => throw new Exception
    }

  def size: Int = list.size
}
