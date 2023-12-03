package aoc2023

import aoc2023.Day2
import aoc2023.Utils.getFileString

class Day2TestSuite extends munit.FunSuite {

  test("Part 1 - Line Wise") {
    val fileContents = Utils.getFileString("test/day2/1.txt")
    val expectedList = List(1, 2, 0, 0, 5)

    for ((line, idx) <- fileContents.split("\n").zipWithIndex) {
      val obtained = Day2.part1(line)
      val expected = expectedList(idx)

      assertEquals(obtained, expected)
    }
  }

  test("Part 1 - Full") {

    val fileContents = Utils.getFileString("test/day2/1.txt")

    val expectedTotal = 8
    val obtained = Day2.part1(fileContents)

    assertEquals(obtained, expectedTotal)
  }

  test("Part 2 - Line Wise") {
    val fileContents = Utils.getFileString("test/day2/1.txt")
    val expectedList = List(48, 12, 1560, 630, 36)

    for ((line, idx) <- fileContents.split("\n").zipWithIndex) {
      val obtained = Day2.part2(line)
      val expected = expectedList(idx)

      assertEquals(obtained, expected)
    }
  }

  test("Part 2 - Full") {

    val fileContents = Utils.getFileString("test/day2/1.txt")

    val expectedTotal = 2286
    val obtained = Day2.part2(fileContents)

    assertEquals(obtained, expectedTotal)
  }
}
