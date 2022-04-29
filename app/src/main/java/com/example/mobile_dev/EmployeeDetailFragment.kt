package com.example.mobile_dev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_dev.databinding.FragmentEmployeeDetailBinding
import com.example.mobile_dev.databinding.FragmentEmployeeTaskListBinding



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class EmployeeDetailFragment : Fragment() {
    private var _binding: FragmentEmployeeDetailBinding? = null
    private val binding get() = _binding!!
    private var columnCount = 1
    private val viewModel: ViewModel by activityViewModels()
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
        _binding = FragmentEmployeeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun adapterOnClick() {
//        viewModel.changeItemContent("new one")
//        findNavController().navigate(R.id.action_projectListPageFragment_to_projectDetailFragment)
    }


    //注意此处的binding.taskList对应的xml文件与经理的页面相同
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

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EmployeeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}