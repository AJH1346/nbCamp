package com.example.myapplication


class AddOperation {
    fun calculate(num1: Double, num2: Double): Double {
        return num1 + num2
    }
}

class SubtractOperation {
    fun calculate(num1: Double, num2: Double): Double {
        return num1 - num2
    }
}

class MultiplyOperation {
    fun calculate(num1: Double, num2: Double): Double {
        return num1 * num2
    }
}

class DivideOperation {
    fun calculate(num1: Double, num2: Double): Double {
        return num1 / num2
    }
}

class Calculator(private val operation: Any) {
    fun calculate(num1: Double, num2: Double): Double {
        when (operation) {
            is AddOperation -> return operation.calculate(num1, num2)
            is SubtractOperation -> return operation.calculate(num1, num2)
            is MultiplyOperation -> return operation.calculate(num1, num2)
            is DivideOperation -> return operation.calculate(num1, num2)
            else -> throw IllegalArgumentException("Invalid operation.")
        }
    }
}

fun main() {
    println("첫 번째 숫자를 입력하세요:")
    val num1 = readLine()?.toDouble() ?: 0.0

    println("두 번째 숫자를 입력하세요:")
    val num2 = readLine()?.toDouble() ?: 0.0

    println("연산 종류를 선택하세요(더하기: +, 빼기: -, 곱하기: *, 나누기: /):")
    val operator = readLine()

    val operation = when (operator) {
        "+" -> AddOperation()
        "-" -> SubtractOperation()
        "*" -> MultiplyOperation()
        "/" -> DivideOperation()
        else -> {
            println("잘못된 연산 선택입니다.")
            return
        }
    }

    val calculator = Calculator(operation)
    val result = calculator.calculate(num1, num2)
    println("결과: $result")

}


