package ru.jr2.edit.presentation.viewmodel.word

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.stage.StageStyle
import ru.jr2.edit.data.db.repository.WordDbRepository
import ru.jr2.edit.domain.model.Word
import ru.jr2.edit.presentation.view.word.WordEditFragment
import tornadofx.ViewModel

class WordListViewModel(
    private val wordRepository: WordDbRepository = WordDbRepository()
) : ViewModel() {
    val words: ObservableList<Word> = FXCollections.observableArrayList<Word>()
    var selectedWord: Word? = null

    init {
        fetchWords()
        subscribeOnEventBus()
    }

    fun onShowNewWordFragment() {
        find<WordEditFragment>().openModal(StageStyle.UTILITY, resizable = false)
    }

    fun onShowEditWordFragment() {
        find<WordEditFragment>(
            Pair(WordEditFragment::paramWordId, selectedWord?.id)
        ).openModal(StageStyle.UTILITY, resizable = false)
    }

    private fun fetchWords() {
        words.clear()
        words.addAll(wordRepository.getAll())
    }

    private fun subscribeOnEventBus() {
        subscribe<WordSavedEvent> {
            fetchWords()
        }
    }
}