package com.example.dialogfragment

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.style.TtsSpan.ARG_GENDER
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_superheroes_list_dialog.*
import kotlinx.android.synthetic.main.fragment_superheroes_list_dialog_item.view.*


// TODO: Customize parameter argument names
const val ARG_NAME = "Name"
const val ARG_POWER = "Power"
const val ARG_IMAGE = "Image"
const val ARG_GENDER = "Gender"

class SuperheroesListDialogFragment : BottomSheetDialogFragment() {
 //   private var mListener: Listener? = null
    private var paramName: String? = null
    private var paramPower: Int? = null
    private var paramGender: String? = null
    private var paramImageUrl: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramName = it.getString(ARG_NAME)
            paramPower = it.getInt(ARG_POWER)
            paramGender = it.getString(ARG_GENDER)
            paramImageUrl = it.getInt(ARG_IMAGE)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_superheroes_list_dialog, container, false)
    }

    companion object {
        fun newInstance(name: String, power: String, gender: String, imageUrl: Int): SuperheroesListDialogFragment =
            SuperheroesListDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_POWER, power)
                    putString(ARG_GENDER, gender)
                    putInt(ARG_IMAGE, imageUrl)

                }
            }
    }
}