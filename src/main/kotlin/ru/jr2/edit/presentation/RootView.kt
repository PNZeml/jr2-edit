package ru.jr2.edit.presentation

import ru.jr2.edit.presentation.group.view.GroupListView
import ru.jr2.edit.presentation.kanji.view.list.KanjiListView
import ru.jr2.edit.presentation.sentence.view.SentenceListView
import ru.jr2.edit.presentation.word.view.WordListView
import tornadofx.View
import tornadofx.tab
import tornadofx.tabpane

class RootView : View("JR2-Edit") {
    private val kanjiListView: KanjiListView by inject()
    private val wordListView: WordListView by inject()
    private val sentenceListView: SentenceListView by inject()
    private val groupListView: GroupListView by inject()

    override val root = tabpane {
        tab("Кана") {
            isClosable = false
        }
        tab("Радикалы") {
            isClosable = false
        }
        tab("Канджи") {
            isClosable = false
            add(kanjiListView)
        }
        tab("Слова") {
            isClosable = false
            add(wordListView)
        }
        tab("Предложения") {
            isClosable = false
            add(sentenceListView)
        }
        tab("Группы") {
            isClosable = false
            add(groupListView)
        }
    }
}