package com.illuminatefocusx.swingtireloop

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        settingsButton.setOnClickListener {
            Toast
                .makeText(this, "Функция еще не добавлена, ожидайте обновления.", Toast.LENGTH_SHORT)
                .show()
        }


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController


        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragmentStart -> {
                    moveButton.text = "Продукты"
                    moveButton.setOnClickListener {
                        navController.navigate(R.id.fragmentCheck)
                        backButton.isClickable = false
                        backButton.isVisible = false
                    }
                }

                R.id.fragmentCheck -> {
                    moveButton.text = "Рецепты"
                    moveButton.setOnClickListener {
                        navController.navigate(R.id.fragmentRecipes)
                        moveButton.isEnabled = false
                        moveButton.isClickable = false
                        backButton.isClickable = false
                        backButton.isVisible = false
                    }
                }

                R.id.fragmentRecipes -> {
                    moveButton.text = "Выберите рецепт"
                    moveButton.isEnabled = false
                    moveButton.isClickable = false
                    backButton.isClickable = false
                    backButton.isVisible = false
                }

                R.id.fragmentDescription -> {
                    moveButton.text = "Работа кипит"
                    moveButton.isEnabled = false
                    moveButton.isClickable = false
                    backButton.isClickable = true
                    backButton.isVisible = true
                }

            }

            backButton.setOnClickListener {
                navController.popBackStack()
            }

            onBackPressedDispatcher.addCallback(object: OnBackPressedCallback(true) {
                /* override back pressing */
                override fun handleOnBackPressed() {
                    //Your code here
                }
            })

        }

    }
}