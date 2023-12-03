package aoc2023

import aoc2023.Day1
import aoc2023.Utils.getFileString

class Day1TestSuite extends munit.FunSuite {

  test("Part 1 - Line wise") {
    val fileContents = Utils.getFileString("test/day1/1.txt")
    val expectedList = List(12, 38, 15, 77)

    for ((line, idx) <- fileContents.split("\n").zipWithIndex) {
      val obtained = Day1.part1(line)
      val expected = expectedList(idx)

      assertEquals(obtained, expected)
    }
  }

  test("Part 1 - Full") {

    val fileContents = Utils.getFileString("test/day1/1.txt")

    val expectedTotal = 142
    val obtained = Day1.part1(fileContents)

    assertEquals(obtained, expectedTotal)
  }

  test("Part 2 - Line wise") {
    val fileContents = Utils.getFileString("test/day1/2.txt")
    val expectedList = List(29, 83, 13, 24, 42, 14, 76)

    for ((line, idx) <- fileContents.split("\n").zipWithIndex) {
      val obtained = Day1.part2(line)
      val expected = expectedList(idx)

      assertEquals(obtained, expected)
    }
  }

  test("Part 2 - Full") {

    val fileContents = Utils.getFileString("test/day1/2.txt")

    val expectedTotal = 281
    val obtained = Day1.part2(fileContents)

    assertEquals(obtained, expectedTotal)
  }
}
