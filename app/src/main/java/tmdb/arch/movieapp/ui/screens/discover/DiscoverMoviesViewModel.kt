package tmdb.arch.movieapp.ui.screens.discover

import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import tmdb.arch.movieapp.domain.model.Movie
import tmdb.arch.movieapp.domain.remote.MoviesService
import tmdb.arch.movieapp.domain.repository.MoviesRepository
import tmdb.arch.movieapp.utils.UiState

class DiscoverMoviesViewModel(private val repository: MoviesRepository) : ViewModel() {
    private val _movies = MutableStateFlow<UiState<List<Movie>>>(UiState.Loading)
    val movies: StateFlow<UiState<List<Movie>>> get() = _movies.asStateFlow()

    init {
        viewModelScope.launch {

            _movies.emit(UiState.Loading)

            Log.d("MyActivity", "Attempting API call")

            try {
                val result = repository.getLatestMovies()
                _movies.emit(UiState.Result(item = result))
            } catch (ex: Exception) {
                Log.d("MyActivity-EXCEPTION", ex.message.toString())
                _movies.emit(UiState.Error)
            }
        }
    }
}
