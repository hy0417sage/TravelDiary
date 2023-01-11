package com.hy0417sage.traveldiary.ui

import android.Manifest
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hy0417sage.traveldiary.R
import com.hy0417sage.traveldiary.databinding.ActivityMainBinding
import com.hy0417sage.traveldiary.repository.data.DairyEntity
import com.hy0417sage.traveldiary.ui.home.diary.DairyActivity.Companion.newIntent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    val dairyViewModel: DiaryViewModel by viewModels()
//    val dairyAdapter: DairyAdapter = DairyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavigationView()
        checkLocationPermission()
//        dairyViewModel.wholeDiary().observe(this, Observer { wholeDairy ->
//            dairyAdapter.submitList(wholeDairy)
//        })
    }

    private fun setBottomNavigationView() {
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_map
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun checkLocationPermission() {
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    // Precise location access granted.
                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    // Only approximate location access granted.
                }
                else -> {
                    // No location access granted.
                }
            }
        }
        locationPermissionRequest.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION))
    }

    fun openDetailPage(dairyEntity: DairyEntity) {
        startActivity(newIntent(this, -1, dairyEntity.title, dairyEntity.mainText))
    }
}