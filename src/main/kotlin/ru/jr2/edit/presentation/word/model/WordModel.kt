package ru.jr2.edit.presentation.word.model

import javafx.beans.property.SimpleStringProperty
import ru.jr2.edit.domain.entity.WordEntity
import ru.jr2.edit.presentation.base.model.BaseModel
import ru.jr2.edit.util.JlptLevel
import tornadofx.getValue
import tornadofx.setValue

class WordModel(id: Int = 0) : BaseModel(id) {
    val pWord = SimpleStringProperty()
    var word: String by pWord

    val pFurigana = SimpleStringProperty()
    var furigana: String? by pFurigana

    val pJlptLevel = SimpleStringProperty()
    var jlptLevel: String? by pJlptLevel

    companion object {
        fun fromEntity(wordEntity: WordEntity) = WordModel(wordEntity.id.value).apply {
            word = wordEntity.word
            furigana = wordEntity.furigana
            jlptLevel = JlptLevel.fromCode(wordEntity.jlptLevel).str
        }
    }
}