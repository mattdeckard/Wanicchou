package data.room.dao

import android.arch.persistence.room.Query
import data.room.entity.Tag

interface TagDao : BaseDao<Tag> {
    @Query("""
        SELECT t.TagText
        FROM Tag t
        WHERE t.TagID = :tagID""")
    fun getTagByID(tagID : Int) : String

    //TODO: Test if it's actually returning null
    @Query("""
        SELECT t.*
        FROM Tag t
        WHERE t.TagText = :tag""")
    fun getTag(tag: String) : Tag

    @Query("""
        SELECT COUNT(0)
        FROM Tag t
        WHERE t.TagText = :tag""")
    fun tagExists(tag: String) : Boolean
}
