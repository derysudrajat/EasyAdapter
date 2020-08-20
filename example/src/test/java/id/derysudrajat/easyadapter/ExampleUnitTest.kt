package id.derysudrajat.easyadapter

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testType(){
        val data: Any? = Data.Items("sadasdas","sadasdasd")
        print("data is ${data!!.javaClass}")
        
    }
}