/*
--- Day 1: Trebuchet?! ---

Something is wrong with global snow production, and you've been selected to take a look.
The Elves have even given you a map; on it, they've used stars to mark the top fifty locations
that are likely to be having problems.

You've been doing this long enough to know that to restore snow operations,
you need to check all fifty stars by December 25th.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar;
the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

You try to ask why they can't just use a weather machine ("not powerful enough") and where they're even
sending you ("the sky") and why your map looks mostly blank ("you sure ask a lot of questions") and hang
on did you just say the sky ("of course, where do you think snow comes from") when you realize that the
Elves are already loading you into a trebuchet ("please hold still, we need to strap you in").

As they're making the final adjustments, they discover that their calibration document (your puzzle input)
has been amended by a very young Elf who was apparently just excited to show off her art skills.
Consequently, the Elves are having trouble reading the values on the document.

--- Part One ---

The newly-improved calibration document consists of lines of text; each line originally contained a specific
calibration value that the Elves now need to recover. On each line, the calibration value can be found by
combining the first digit and the last digit (in that order) to form a single two-digit number.

For example:

1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet

In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.

Consider your entire calibration document. What is the sum of all of the calibration values?

--- Part Two ---

Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters:
one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".

Equipped with this new information, you now need to find the real first and last digit on each line. For example:

two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen

In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.

What is the sum of all of the calibration values?
 */

package aoc2023

object Day1 {

  def part1(input: String): Int = {

    var total = 0

    for (line <- input.split("\n")) {
      // Get a list of all the numbers in a string
      // Consecutive numbers will be interpreted separately
      val numbers_in_line = ("""\d""".r findAllIn line).toList

      // Take the first number "a" and the last number "b" and concatenate them "ab"
      val number_for_line = numbers_in_line.head.concat(numbers_in_line.last)

      // Convert the string to int and add it to total
      total += Utils.stringToInt(number_for_line).getOrElse(0)
    }

    total
  }

  def part2(input: String): Int = {

    // Mapping words to integers
    val replacementsMap = Map(
      "one" -> 1,
      "two" -> 2,
      "three" -> 3,
      "four" -> 4,
      "five" -> 5,
      "six" -> 6,
      "seven" -> 7,
      "eight" -> 8,
      "nine" -> 9
    )

    // We also need to recognize normal integers in the line
    val numberStrings = (1 to 9).map(_.toString)

    // Make an "OR" regex for all the words and numbers
    // We use positive lookahead to not consume characters and thus match overlapping cases
    val replacementRegex =
      s"""(?=(${(replacementsMap.keysIterator ++ numberStrings).mkString("|")}))""".r

    var total = 0
    for (line <- input.toLowerCase.split("\n")) {

      // Find all the matches in each line
      val matches = replacementRegex.findAllMatchIn(line).map(_.group(1)).toList

      // If the match is a word, get the int representation times 10, because the
      // numbers are concatenated
      if (replacementsMap.contains(matches.head)) {
        total += replacementsMap(matches.head) * 10
      } else {
        total += Utils.stringToInt(matches.head).getOrElse(0) * 10
      }

      // Add the last match in the line
      if (replacementsMap.contains(matches.last)) {
        total += replacementsMap(matches.last)
      } else {
        total += Utils.stringToInt(matches.last).getOrElse(0)
      }
    }

    total
  }
}
