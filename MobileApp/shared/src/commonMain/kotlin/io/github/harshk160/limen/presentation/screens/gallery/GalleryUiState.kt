package io.github.harshk160.limen.presentation.screens.gallery

import io.github.harshk160.limen.domain.model.generation.GenerationOutput

data class GalleryUiState(
    val generations: List<GenerationOutput> = emptyList(),
    val isLoading: Boolean = false,
)

sealed interface GalleryUiEvent {
    data class OnClickItem(val item: GenerationOutput) : GalleryUiEvent
    data object OnClickGenerate : GalleryUiEvent
}
