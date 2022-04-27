package com.example.mobile_dev

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_dev.databinding.FragmentProjectDetailBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProjectDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProjectDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentProjectDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModel by activityViewModels()
    private var columnCount = 1
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProjectDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    private fun adapterOnClick() {
//        viewModel.changeItemContent("new one")
//        findNavController().navigate(R.id.action_projectListPageFragment_to_projectDetailFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.taskList.adapter = MyTaskListPageRecyclerViewAdapter(ViewModel.TaskObj.ITEMS
        ) { adapterOnClick() }
        binding.taskList.layoutManager = when {
            columnCount <= 1 -> LinearLayoutManager(context)
            else -> GridLayoutManager(context, columnCount)
        }
        val duration = Toast.LENGTH_SHORT
        binding.managerMenu.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.action_search ->{
                    val text1 = "click 1"
                    Toast.makeText(context, text1, duration).show()
                }
                R.id.action_settings ->{
                    val text2 = "click 2"
                    Toast.makeText(context, text2, duration).show()
                }
                R.id.action_navigation ->{
                    val text3 = "click 3"
                    Toast.makeText(context, text3, duration).show()
                }
            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProjectDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProjectDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}