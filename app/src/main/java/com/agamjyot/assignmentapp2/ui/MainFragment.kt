package com.agamjyot.assignmentapp2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.agamjyot.assignmentapp2.adapter.MainAdapter
import com.agamjyot.assignmentapp2.databinding.FragmentMainBinding
import kotlin.random.Random

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var mainAdapter: MainAdapter

    private var list: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 5)
        repeat(25) {
            list.add("")
        }
        mainAdapter = MainAdapter(list)
        binding.recyclerView.adapter = mainAdapter

        binding.btn.setOnClickListener {
            val row = Random.nextInt(5)
            val column = Random.nextInt(5)
            mainAdapter.setFirstImagePosition(row, column)
        }
    }



}