package task1

import kotlin.math.pow

object Sec{
    private tailrec fun fact(n: Long, acc: Long = 1): Long{
        return if (n == 0.toLong()){
            acc
        } else {
            fact(n - 1, acc * n)
        }
    }

    private fun cosTaylor(x: Double, terms: Int = 11): Double{
        var result = 0.0

        for (n in 0 until terms){
            val term = (-1.0).pow(n) * x.pow(2 * n) / fact((2 * n).toLong())
            result += term
        }
        return result
    }

    fun secCalc(x: Double, terms: Int = 11): Double{
        if (terms == 0)
            throw WrongArgumentException()

        val cos = cosTaylor(x % (2*Math.PI), terms)

        if (cos > -0.000001 && cos < 0.000001)
            throw FunctionNotDefinedException()

        return 1 / cos
    }
}

class WrongArgumentException : Exception("Wrong argument!")
class FunctionNotDefinedException : Exception()