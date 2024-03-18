package task1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.ValueSource
import kotlin.math.cos

class SecTest {

    @ParameterizedTest(name = "sec(from -pi/2 to pi/2)")
    @ValueSource(doubles = [-Math.PI / 2 + 0.001, -Math.PI / 4, 0.0, Math.PI / 4, Math.PI / 2 - 0.001])
    fun testSec(x: Double){
        assertEquals(1/cos(x), Sec.secCalc(x), 0.001)
    }

    @ParameterizedTest(name = "sec(from pi/2 to 3 * pi/2)")
    @ValueSource(doubles = [Math.PI / 2 + 0.001, -Math.PI / 4, 0.0, Math.PI / 4, 3 * Math.PI / 2 - 0.1])
    fun testSec2(x: Double){
        assertEquals(1/cos(x), Sec.secCalc(x), 0.001)
    }

    @Test
    fun testThrow() {
        val start = Math.PI/2

        for (i in -1..2) {
            Assertions.assertThrows(FunctionNotDefinedException::class.java) {
                Sec.secCalc(start + Math.PI*i)
            }
        }
    }
}