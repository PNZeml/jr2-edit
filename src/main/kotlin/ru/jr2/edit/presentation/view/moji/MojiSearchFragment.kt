package ru.jr2.edit.presentation.view.moji

import org.controlsfx.glyphfont.FontAwesome
import ru.jr2.edit.domain.model.Moji
import ru.jr2.edit.presentation.viewmodel.moji.MojiSearchViewModel
import tornadofx.*
import tornadofx.controlsfx.customTextfield
import tornadofx.controlsfx.toGlyph

class MojiSearchFragment : Fragment("Поиск моджи") {
    private val viewModel: MojiSearchViewModel by inject()
    override val root = borderpane {
        top = customTextfield(right = FontAwesome.Glyph.SEARCH.toGlyph()) {
            textProperty().addListener { _, _, query ->
                viewModel.onSearchQueryChange(query)
            }
        }
        center = tableview(viewModel.mojis) {
            column("Моджи", Moji::valueProp)
            smartResize()
            placeholder = label("Нет моджи по заданному запросу")
            onUserSelect(2) { moji ->
                viewModel.onMojiSelect(moji)
                close()
            }
        }

    }
}