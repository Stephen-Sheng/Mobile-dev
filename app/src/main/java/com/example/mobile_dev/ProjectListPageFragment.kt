package com.example.mobile_dev

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.mobile_dev.databinding.FragmentProjectListBinding
import com.example.mobile_dev.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ProjectListPageFragment : Fragment() {

    private var _binding: FragmentProjectListBinding? = null
    private val binding get() = _binding!!
    private var columnCount = 1
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Nickname",viewModel.nickname.value.toString())
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProjectListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = MyProjectListPageRecyclerViewAdapter(PlaceholderContent.ITEMS)
        binding.list.layoutManager = when {
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
            true
        }
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ProjectListPageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}