package lect_1

import scala.io.StdIn

object Queue extends App {
  val queue = new Queue

  def printAnswer(str: String): Unit =
    str match {
      case s: String if s.startsWith("push ") =>
        val number = s.split(' ').apply(1).toInt
        queue.push(number)
        println("ok")

      case "clear" =>
        queue.clear
        println("ok")

      case "pop" => println(queue.pop)
      case "front" => println(queue.front)
      case "size" => println(queue.length)
      case "exit" => println("bye")
    }

  var str = StdIn.readLine()

  while (str != "exit") {
    printAnswer(str)
    str = StdIn.readLine()
  }

  printAnswer("exit")
}

class Queue {
  val arr = new Array[Int](100)
  var start = 0
  var end = 0
  var length = 0

  private def increaseOrSetToZero(counter: Int): Int =
    if (counter < arr.length - 1) {
      counter + 1
    } else {
      0
    }

  def push(elem: Int): Unit = {
    arr(end) = elem
    end = increaseOrSetToZero(end)
    length += 1
  }

  def pop: Int = {
    val elem = arr(start)
    start = increaseOrSetToZero(start)
    length -= 1

    elem
  }

  def front: Int =
    arr(start)

  def size: Int =
    length

  def clear: Unit = {
    start = 0
    end = 0
    length = 0
  }
}