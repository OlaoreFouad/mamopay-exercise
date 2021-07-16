package dev.olaore.mamopay_exercise

import dev.olaore.mamopay_exercise.mappers.format
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.math.exp

class FormatCurrencyTest {

    @Before
    fun setup() {
    }

    @After
    fun teardown() {
    }

    // test when nothing is passed in, it returns 0.00
    @Test
    fun `test when empty text is passed in should return all zeros`() {
        // arrange
        val text: String = ""
        val expected = "0.00"

        // act
        val actual = text.format()

        // assert
        Assert.assertEquals(expected, actual)
    }

    // test when 1 is passed in, it returns 1.00
    @Test
    fun `test when 1 is passed in, should return 1_00`() {
        val text: String = "1"
        val expected = "1.00"

        val actual = text.format()

        Assert.assertEquals(expected, actual)
    }

    // test when 12 is passed in, it returns 12.00
    @Test
    fun `test when 12 is passed in, should return 12_00`() {
        val text: String = "12"
        val expected = "12.00"

        val actual = text.format()

        Assert.assertEquals(expected, actual)
    }

    // test when 12343 is passed in, it returns 12,343.00
    @Test
    fun `test when 12343 is passed in, should return 12,343_00`() {
        val text: String = "12343"
        val expected = "12,343.00"

        val actual = text.format()

        Assert.assertEquals(expected, actual)
    }

    // test when 12343.2 is passed in, it returns 12,343.20
    @Test
    fun `test when 12343_2 is passed in, should return 12,343_20`() {
        val text: String = "12343.2"
        val expected = "12,343.20"

        val actual = text.format()

        Assert.assertEquals(expected, actual)
    }

    // test when 12232. is passed in, it returns 12,232.00
    @Test
    fun `test when 12232 is passed in, should return 12,232_00`() {
        val text: String = "12232"
        val expected = "12,232.00"

        val actual = text.format()

        Assert.assertEquals(expected, actual)
    }

}