package tmdb.arch.movieapp.utils

import androidx.recyclerview.widget.DiffUtil

class SimpleDiffCallback<T : Any> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(
        oldItem: T,
        newItem: T,
    ): Boolean = oldItem::class == newItem::class

    @Suppress("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: T,
        newItem: T,
    ): Boolean = oldItem == newItem
}
