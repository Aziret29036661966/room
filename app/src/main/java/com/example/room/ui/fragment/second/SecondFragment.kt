package com.example.room.ui.fragment.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.room.databinding.FragmentSecondBinding
import com.example.room.ui.fragment.second.adapter.AdapterRvRc

class SecondFragment : Fragment() {

    private val binding: FragmentSecondBinding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: ViewModelForSecond
    private lateinit var adapterRvRc: AdapterRvRc

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initRvRc()
        initViewModel()
        return binding.root
    }

    private fun initViewModel() {
         viewModel = ViewModelProvider(this).get(ViewModelForSecond::class.java)
         viewModel.readAllData.observe(viewLifecycleOwner, Observer {history ->
             adapterRvRc.setResult(history)
         })
    }

    private fun initRvRc() {
        adapterRvRc = AdapterRvRc(true)
        binding.rvRc.adapter = adapterRvRc
    }


}