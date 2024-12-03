package com.aoc.day3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun testLoadData() {
        val data = Day3.loadInstructions("test_input.txt")
        val expected = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        Assertions.assertThat(data).isEqualTo(expected)
    }

    @Test
    fun testSumInstructions() {
        val input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"

        val actual = Day3.sumMulInstructions(input)
        val expected = 161

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun testSumInstructionsConditionally() {
        val input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

        val actual = Day3.sumMulInstructionsConditionally(input)
        val expected = 48

        Assertions.assertThat(actual).isEqualTo(expected)
    }

}