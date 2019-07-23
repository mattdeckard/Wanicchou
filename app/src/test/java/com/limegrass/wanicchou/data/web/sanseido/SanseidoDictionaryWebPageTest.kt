package com.limegrass.wanicchou.data.web.sanseido

import data.enums.MatchType
import data.web.sanseido.SanseidoWebPage
import org.junit.Test
import kotlin.test.asserter

class SanseidoDictionaryWebPageTest {
    @Test
    fun buildQueryURL_SupportedMatchType(){
        val webPage = SanseidoWebPage("http://fake.base.url/")
        val searchTerm = "テスト"
        val wordLanguageID = 1L
        val definitionLanguageID = 1L
        val matchType = MatchType.WORD_EQUALS
        val actual = webPage.buildQueryURL(searchTerm, wordLanguageID, definitionLanguageID, matchType)
        val expected = "http://fake.base.url/?st=1&TWords=%E3%83%86%E3%82%B9%E3%83%88&DORDER=151716&DailyJJ=checkbox"
        val message = "Expected: $expected, got $actual"

        asserter.assertEquals(message, expected, actual.toString())
    }

    @Test(expected = IllegalArgumentException::class)
    fun buildQueryURL_UnsupportedMatchType(){
        val webPage = SanseidoWebPage()
        val searchTerm = "Test"
        val wordLanguageID = 1L
        val definitionLanguageID = 1L
        val matchType = MatchType.DEFINITION_CONTAINS
        webPage.buildQueryURL(searchTerm, wordLanguageID, definitionLanguageID, matchType)
    }

    @Test(expected = IllegalArgumentException::class)
    fun buildQueryURL_UnsupportedWordLanguageID(){
        val webPage = SanseidoWebPage()
        val searchTerm = "Test"
        val wordLanguageID = 1L
        val definitionLanguageID = -1L
        val matchType = MatchType.WORD_STARTS_WITH
        webPage.buildQueryURL(searchTerm, wordLanguageID, definitionLanguageID, matchType)
    }
}
