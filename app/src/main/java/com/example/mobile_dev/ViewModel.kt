package com.example.mobile_dev

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.ArrayList
import java.util.HashMap

class ViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _loginEmail = MutableLiveData<String>("yutong")
    val loginEmail: LiveData<String> get() = _loginEmail
    private val _loginPwd = MutableLiveData<String>("syt1234")
    val loginPwd: LiveData<String> get() = _loginPwd
    private val _nickname = MutableLiveData<String>("Yutong")
    val nickname: LiveData<String> get() = _nickname

   //employee
    private val _loginEmail2 = MutableLiveData<String>("zhihong")
    val loginEmail2: LiveData<String> get() = _loginEmail2
    private val _loginPwd2 = MutableLiveData<String>("lzh1234")
    val loginPwd2: LiveData<String> get() = _loginPwd2
    private val _nickname2 = MutableLiveData<String>("zhihong")
    val nickname2: LiveData<String> get() = _nickname2



    private val _itemContent = MutableLiveData<String>("default")
    val itemContent: LiveData<String> get() = _itemContent

    fun changeItemContent(value: String){
        _itemContent.value = value
    }


    object PlaceholderContent {

        /**
         * An array of sample (placeholder) items.
         */
        private val _ITEMS: MutableList<PlaceholderItem> = ArrayList()
        val ITEMS: List<PlaceholderItem> get() = _ITEMS

        /**
         * A map of sample (placeholder) items, by ID.
         */
        private val ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

        private const val COUNT = 25

        init {
            // Add some sample items.
            for (i in 1..COUNT) {
                addItem(createPlaceholderItem(i))
            }
        }

        private fun addItem(item: PlaceholderItem) {
            _ITEMS.add(item)
            ITEM_MAP[item.id] = item
        }

        private fun createPlaceholderItem(position: Int): PlaceholderItem {
            return PlaceholderItem(position.toString(), "Item $position", makeDetails(position))
        }

        private fun makeDetails(position: Int): String {
            val builder = StringBuilder()
            builder.append("Details about Item: ").append(position)
            for (i in 0 until position) {
                builder.append("\nMore details information here.")
            }
            return builder.toString()
        }

        /**
         * A placeholder item representing a piece of content.
         */
        data class PlaceholderItem(val id: String, val content: String, val details: String) {
            override fun toString(): String = content
        }
    }

    object TaskObj {

        /**
         * An array of sample (placeholder) items.
         */
        private val _ITEMS: MutableList<TaskItem> = ArrayList()
        val ITEMS: List<TaskItem> get() = _ITEMS

        /**
         * A map of sample (placeholder) items, by ID.
         */
        private val ITEM_MAP: MutableMap<String, TaskItem> = HashMap()

        private const val COUNT = 25

        init {
            // Add some sample items.
            for (i in 1..COUNT) {
                addItem(createPlaceholderItem(i))
            }
        }

        private fun addItem(item: TaskItem) {
            _ITEMS.add(item)
            ITEM_MAP[item.id] = item
        }

        private fun createPlaceholderItem(position: Int): TaskItem {
            return TaskItem(position.toString(), "Item $position", makeDetails(position))
        }

        private fun makeDetails(position: Int): String {
            val builder = StringBuilder()
            builder.append("Details about Item: ").append(position)
            for (i in 0 until position) {
                builder.append("\nMore details information here.")
            }
            return builder.toString()
        }

        /**
         * A placeholder item representing a piece of content.
         */
        data class TaskItem(val id: String, val content: String, val details: String) {
            override fun toString(): String = content
        }
    }



}