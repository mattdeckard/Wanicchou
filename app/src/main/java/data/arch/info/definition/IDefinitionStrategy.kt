package data.arch.info.definition

import data.room.entity.Definition
import org.jsoup.nodes.Document

internal interface IDefinitionStrategy {
    fun get(htmlDocument: Document,
            definitionLanguageID: Long,
            dictionaryID: Long,
            vocabularyID: Long) : Definition
}