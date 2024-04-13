package com.codepath.articlesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.codepath.articlesearch.databinding.ActivityMainBinding
import com.codepath.articlesearch.ui.dashboard.DashboardFragment
import com.codepath.articlesearch.ui.workout.WorkoutFragment
//import com.codepath.articlesearch
//import com.example.project6bitfitpart2.R
//import com.example.project6bitfitpart2.databinding.ActivityMainBinding
import kotlinx.serialization.json.Json

fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

private const val TAG = "MainActivity/"
//private const val SEARCH_API_KEY = BuildConfig.API_KEY
//private const val ARTICLE_SEARCH_URL =
//    "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=${SEARCH_API_KEY}"

class MainActivity : AppCompatActivity() {
//    private val articles = mutableListOf<Article>()
    private lateinit var articlesRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        replaceFragment(WorkoutFragment())

        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.workoutOption -> replaceFragment(WorkoutFragment())
                R.id.dashboardOption -> replaceFragment(DashboardFragment())
                R.id.settingsOption -> replaceFragment(AddWorkoutActivity())
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val tag = fragment.javaClass.simpleName
        val supportFragmentManager = supportFragmentManager
        val existingFragment = supportFragmentManager.findFragmentByTag(tag)

        if (existingFragment == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, fragment, tag)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .show(existingFragment)
                .commit()
        }
    }
}