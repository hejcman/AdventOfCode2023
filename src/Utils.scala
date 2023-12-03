// Utils.scala

package aoc2023

import scala.io.Source
import java.io.File
import scala.util.{Try, Success, Failure}

object Utils {

  def getFileString(filePath: String): String = {

    // Try to open the file and read the contents
    val result: Try[String] = Try {
      val source = Source.fromFile(filePath)
      val content = source.mkString
      source.close()
      content
    }

    // Handle possible errors
    result match {
      case Success(fileContent) => fileContent
      case Failure(exception) => {
        println(s"Error reading file: ${exception.getMessage}")
        ""
      }
    }
  }

  def stringToInt(input: String): Option[Int] = scala.util.Try(input.toInt).toOption

}
