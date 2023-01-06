package com.hy0417sage.traveldiary.ui.map

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hy0417sage.traveldiary.MainActivity
import com.hy0417sage.traveldiary.databinding.FragmentHomeBinding
import com.hy0417sage.traveldiary.databinding.FragmentMapBinding
import com.hy0417sage.traveldiary.ui.home.HomeViewModel

class MapFragment : Fragment() {

    private lateinit var mainActivity: MainActivity

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapViewModel =
            ViewModelProvider(this)[MapViewModel::class.java]
        mapViewModel.text.observe(viewLifecycleOwner) {
            binding.textMap.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}