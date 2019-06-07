package com.example.dialogfragment

import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide


import com.example.dialogfragment.SuperheroesFragment.OnListFragmentInteractionListener
import com.example.dialogfragment.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.fragment_superheroes.view.*
import kotlin.collections.ArrayList

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MySuperheroesRecyclerViewAdapter(

    private val activity: MainActivity,
    private val fragmentManager: FragmentManager,
    private val mValues: ArrayList<Superhero>
//    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MySuperheroesRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_superheroes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
       item.image.toString()
        holder.mView.namez.text = item.name
        holder.mView.genderz.text = item.gender
        holder.mView.powerz.text = item.power.toString()
        Glide.with(activity)
            .load(item.image)
            .placeholder(R.drawable.Thor)
            .into(holder.mView.hero_image)

        item.image.toString())

        holder.mView.setOnClickListener() {
            val bottomSheetFragment = SuperheroesListDialogFragment.newInstance(item.name, item.gender, item.power, item.image)
            bottomSheetFragment.show(fragmentManager, "")
        }
    }


    override fun getItemCount(): Int = mValues.size
    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView){
   //l
    }
}