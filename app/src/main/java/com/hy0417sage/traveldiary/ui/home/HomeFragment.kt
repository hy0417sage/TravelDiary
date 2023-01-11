package com.hy0417sage.traveldiary.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hy0417sage.traveldiary.ui.MainActivity
import com.hy0417sage.traveldiary.databinding.FragmentHomeBinding
import com.hy0417sage.traveldiary.repository.data.DairyEntity
import com.hy0417sage.traveldiary.ui.home.diary.adapter.DairyAdapter
import com.hy0417sage.traveldiary.viewmodel.DiaryViewModel

class HomeFragment : Fragment() {

    private lateinit var mainActivity: MainActivity
//    val dairyAdapter: DairyAdapter = DairyAdapter()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        mainActivity.dairyViewModel.wholeDiary().observe(mainActivity, Observer { wholeDairy ->
//            dairyAdapter.submitList(wholeDairy)
//        })

        binding.createDiaryButton.setOnClickListener {
            mainActivity.openDetailPage(DairyEntity(-1, "", ""))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    private fun recyclerViewInit(){
//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(mainActivity)
//            adapter = mainActivity.dairyAdapter
//            addItemDecoration(
//                DividerItemDecoration(
//                    mainActivity,
//                    LinearLayoutManager.VERTICAL
//                )
//            )
//        }
//    }

}