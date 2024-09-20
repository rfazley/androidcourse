package tmdb.arch.movieapp.ui.screens.discover.adapter

import coil.load
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tmdb.arch.movieapp.BuildConfig
import tmdb.arch.movieapp.databinding.MovieListItemBinding
import tmdb.arch.movieapp.domain.model.Movie
import tmdb.arch.movieapp.utils.delegates.viewBinding
import androidx.recyclerview.widget.DiffUtil
import tmdb.arch.movieapp.utils.SimpleDiffCallback


class MoviesListAdapter() :

    ListAdapter<Movie, MoviesListAdapter.MovieViewHolder>(SimpleDiffCallback<Movie>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            binding = parent.viewBinding {
                layoutInflater, viewGroup, _ ->MovieListItemBinding.inflate(layoutInflater, viewGroup, false)
            }
        )


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position) ?: return

        holder.bind(item)
    }

    class MovieViewHolder(private val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movie) {
            binding.title.text = item.title
            binding.originalTitle.text = item.originalTitle
            binding.releaseDate.text = item.releaseDate
            binding.poster.load(BuildConfig.IMAGE_URL + item.posterPath)
        }
    }
}