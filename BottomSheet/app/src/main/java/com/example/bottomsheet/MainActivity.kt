package com.example.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomSheetButton.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, BottomSheetFragment.TAG)

            //behaviorの属性を追加するのに使う
            /*
            asに？がないと、
            null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog
            が出てアプリが落ちた。
             */
            val modalBottomSheetBehavior = (bottomSheetFragment.dialog as? BottomSheetDialog)?.behavior
        }
    }
}