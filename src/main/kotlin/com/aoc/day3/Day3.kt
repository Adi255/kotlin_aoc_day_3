package com.aoc.day3

import com.aoc.day3.Day3.Companion.loadInstructions
import com.aoc.day3.Day3.Companion.sumMulInstructions
import com.aoc.day3.Day3.Companion.sumMulInstructionsConditionally

class Day3 {

    companion object {
        fun loadInstructions(path: String): String {
            return this::class.java.classLoader.getResource(path)?.readText()?.trim()
                ?: throw IllegalArgumentException("File not found")
        }

        fun sumMulInstructions(input: String): Int {
            val regex = Regex("mul\\((\\d+),(\\d+)\\)")
            return regex.findAll(input).map { match ->
                val operands = match.groupValues.drop(1)
                operands.map(String::toInt).reduce(Int::times)
            }.sum()
        }

        fun sumMulInstructionsConditionally(input: String): Int {
            val sections = input.split("don't()")
            val validSectionBuilder = StringBuilder()
            validSectionBuilder.append(sections.first())
            for (section in sections.drop(1)) {
                val doSections = section.split("do()")
                doSections.drop(1).forEach() {
                    validSectionBuilder.append(it)
                }
            }
            return sumMulInstructions(validSectionBuilder.toString())
        }
    }
}

fun main() {
    val data = loadInstructions("input.txt")
    println("Unmodified result: ${sumMulInstructions(data)}")
    println("Conditional result: ${sumMulInstructionsConditionally(data)}")
}