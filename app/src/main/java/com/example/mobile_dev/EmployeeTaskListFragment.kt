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
import com.example.mobile_dev.databinding.FragmentEmployeeTaskListBinding
import com.example.mobile_dev.databinding.FragmentProjectListBinding


class EmployeeTaskListFragment : Fragment() {

    private var _binding: FragmentEmployeeTaskListBinding? = null
    private val binding get() = _binding!!
    private var columnCount = 1
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Nickname",viewModel.nickname2.value.toString())
        arguments?.let {
            columnCount = it.getInt(ProjectListPageFragment.ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEmployeeTaskListBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun adapterOnClick() {
        viewModel.changeItemContent("new one")
        findNavController().navigate(R.id.action_employeeTaskListFragment_to_employeeDetailFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.employeeList.adapter = EmployeeTaskPageRecyclerViewAdapter(ViewModel.PlaceholderContent.ITEMS
        ) { adapterOnClick() }
        binding.employeeList.layoutManager = when {
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
         * @return A new instance of fragment EmployeeTaskListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EmployeeTaskListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}