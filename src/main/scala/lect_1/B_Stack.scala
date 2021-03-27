package lect_1

/**
 * Реализуйте структуру данных "стек". Программа считывает последовательность команд и в зависимости от команды выполняет
 * ту или иную операцию. После выполнения каждой команды программа должна вывести одну строчку. Возможные команды для программы:

 * push n
 * Добавить в стек число n (значение n задается после команды). Программа должна вывести "ok" (без кавычек).

 * pop
 * Удалить из стека последний элемент. Программа должна вывести его значение.

 * back
 * Программа должна вывести значение последнего элемента, не удаляя его из стека.

 * size
 * Программа должна вывести количество элементов в стеке.

 * clear
 * Программа должна очистить стек и вывести "ok".

 * exit
 * Программа должна вывести "bye" и завершить работу.

 * Перед исполнением операций back и pop программа должна проверять, содержится ли в стеке хотя бы один элемент.
 * Если во входных данных встречается операция back или pop, и при этом стек пуст, то программа должна вместо числового значения вывести строку "error".

 * Входные данные
 * Вводятся команды управления стеком, по одной на строке

 * Выходные данные
 * Программа должна вывести протокол работы стека, по одному сообщению на строке

 * Пример
 * входные данные
 * size
 * push 1
 * size
 * push 2
 * size
 * push 3
 * size
 * exit
 * выходные данные
 * 0
 * ok
 * 1
 * ok
 * 2
 * ok
 * 3
 * bye
 */

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
