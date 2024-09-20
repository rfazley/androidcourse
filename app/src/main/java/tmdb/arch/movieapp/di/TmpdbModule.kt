package tmdb.arch.movieapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tmdb.arch.movieapp.domain.remote.MoviesService
import tmdb.arch.movieapp.domain.repository.MoviesRepository
import tmdb.arch.movieapp.ui.screens.details.MoviesDetailsViewModel
import tmdb.arch.movieapp.ui.screens.discover.DiscoverMoviesViewModel
import tmdb.arch.movieapp.ui.screens.saved.SavedMoviesViewModel
import tmdb.arch.movieapp.ui.screens.search.SearchMoviesViewModel

val viewModels =
    module {

        viewModel { DiscoverMoviesViewModel(get<MoviesRepository>()) }
        viewModel { MoviesDetailsViewModel() }
        viewModel { SearchMoviesViewModel() }
        viewModel { SavedMoviesViewModel() }
    }
