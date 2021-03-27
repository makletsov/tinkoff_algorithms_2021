package lect_1

import scala.io.StdIn

//object Stack extends App {
//  val stack = new Stack
//
//  def printAnswer(str: String): Unit =
//    str match {
//      case s: String if s.startsWith("push ") =>
//        val number = s.split(' ').apply(1).toInt
//        stack.push(number)
//        println("ok")
//
//      case "clear" =>
//        stack.clear
//        println("ok")
//
//      case "pop" => println(stack.pop)
//      case "back" => println(stack.back)
//      case "size" => println(stack.size)
//      case "exit" => println("bye")
//    }
//
//  var str = StdIn.readLine()
//
//  while (str != "exit") {
//    try {
//      printAnswer(str)
//    } catch {
//      case _: Exception => println("error")
//    }
//
//    str = StdIn.readLine()
//  }
//
//  printAnswer("exit")
//}

//class Stack {
//  private var list = List.empty[Int]
//
//  def push(elem: Int): Unit =
//    list = elem :: list
//
//  def pop: Int =
//    list match {
//      case x :: xs =>
//        list = xs
//        x
//      case _ =>
//        throw new Exception
//    }
//
//  def back: Int =
//    list match {
//      case x :: _ => x
//      case _ => throw new Exception
//    }
//
//  def size: Int = list.size
//
//  def clear: Unit =
//    list = List.empty[Int]
//}
