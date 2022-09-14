package com.example.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.bottomsheet.databinding.ActivityPersistentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class PersistentBottomSheetActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPersistentBottomSheetBinding

    private lateinit var bottomSheetBehavior:BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersistentBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icecream.setOnClickListener {
            Toast.makeText(this, "IceCream taped!", Toast.LENGTH_SHORT).show()
        }
        binding.cake.setOnClickListener {
            Toast.makeText(this, "Cake taped!", Toast.LENGTH_SHORT).show()
        }
        binding.cookie.setOnClickListener {
            Toast.makeText(this, "Cookie taped!", Toast.LENGTH_SHORT).show()
        }

        bottomSheetBehavior = BottomSheetBehavior.from(binding.persistentBottomSheet)
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                binding.buttonBottomSheetPersistent.text = when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> "Close Persistent Bottom Sheet"
                    BottomSheetBehavior.STATE_COLLAPSED -> "Open Persistent Bottom Sheet"
                    else -> "Persistent Bottom Sheet"
                }
            }
        })

        binding.buttonBottomSheetPersistent.setOnClickListener {
            val state =
                if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                    BottomSheetBehavior.STATE_COLLAPSED
                else
                    BottomSheetBehavior.STATE_EXPANDED
            bottomSheetBehavior.state = state
        }
    }
}