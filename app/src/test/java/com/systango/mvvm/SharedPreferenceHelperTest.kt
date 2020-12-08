package com.systango.mvvm

import android.content.SharedPreferences
import com.systango.mvvm.prefs.SharedPreferencesHelper
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SharedPreferenceHelperTest {
    private lateinit var mockPrefHelper: SharedPreferencesHelper
    @Mock
    private lateinit var mockSharedPreferences: SharedPreferences

    @Before
    fun initMocks() {
        mockPrefHelper = SharedPreferencesHelper(mockSharedPreferences)
    }

    @Test
    fun testIsLoggedIn_shouldBeTrue() {
        `when`(mockPrefHelper.isLoggedIn()).thenReturn(true)
        val loggedIn = mockPrefHelper.isLoggedIn()
        assertTrue(loggedIn)
    }

    @Test
    fun testIsLoggedIn_shouldBeFalse() {
        `when`(mockPrefHelper.isLoggedIn()).thenReturn(false)
        val loggedIn = mockPrefHelper.isLoggedIn()
        assertFalse(loggedIn)
    }
}