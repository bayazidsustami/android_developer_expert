package com.dicoding.submission.thesports.commons.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B: ViewBinding>(
    val bindingFactory: (LayoutInflater) -> B
): AppCompatActivity() {

    private var _binding: ViewBinding? = null

    @Suppress("UNCHECKED_CAST")
    protected val binding: B
        get() = _binding as B

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = bindingFactory(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onCreateView(savedInstanceState)
    }

    abstract fun onCreateView(savedInstanceState: Bundle?)

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}