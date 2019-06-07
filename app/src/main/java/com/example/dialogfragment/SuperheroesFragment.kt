package com.example.dialogfragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.dialogfragment.dummy.DummyContent
import com.example.dialogfragment.dummy.DummyContent.DummyItem

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [SuperheroesFragment.OnListFragmentInteractionListener] interface.
 */

data class Superhero(var name: String, var gender: String, var power: Int, var image: Int)
class SuperheroesFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_superheroes_list, container, false)
        val names = arrayOf("Superman", "Spider man", "Wonder woman", "Thor", "Batman")
        val genders = arrayOf("M", "M", "F", "M", "M")
        val powers = arrayOf(100, 85, 90, 95, 80)
        val superheroes = ArrayList<Superhero>()
        val image = intArrayOf(R.drawable.superman, R.drawable.spooderman, R.drawable.wonderwoman, R.drawable.Thor, R.drawable.betmen)
        for(i in 0 until names.size) {
            superheroes.add(Superhero(names[i], genders[i], powers[i], image[i]))
        }
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = MySuperheroesRecyclerViewAdapter(activity as MainActivity, fragmentManager!!, superheroes)
//
            }
        }
        return view
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            SuperheroesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
