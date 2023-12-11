package com.example.active

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class MyCalcTest{
    private lateinit var myCalc: MyCalc

    @Before
    fun setUp(){
        myCalc = MyCalc()
    }

    @Test
    fun calculateCicumference_radisGiven_returnCorrectResult(){
        val result = myCalc.calculateCircumference(2.1)
        assertThat(result).isEqualTo(13.188)
    }

    @Test
    fun calculateCicumference_radisZero_returnCorrectResult(){
        val result = myCalc.calculateCircumference(0.0)
        assertThat(result).isZero()
    }

    @Test
    fun calculateArea_radisGiven_returnCorrectResult(){
        val result = myCalc.calculateArea(2.1)
        assertThat(result).isEqualTo(13.8474)
    }

    @Test
    fun calculateArea_radisZero_returnCorrectResult(){
        val result = myCalc.calculateArea(0.0)
        assertThat(result).isZero()
    }
}