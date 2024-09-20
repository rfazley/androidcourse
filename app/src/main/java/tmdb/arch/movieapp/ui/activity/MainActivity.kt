package tmdb.arch.movieapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tmdb.arch.movieapp.databinding.ActivityMainBinding
import tmdb.arch.movieapp.utils.delegates.viewBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        setContentView(binding.root) // main activity layout
    }
}
