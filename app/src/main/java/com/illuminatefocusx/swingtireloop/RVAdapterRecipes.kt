package com.illuminatefocusx.swingtireloop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapterRecipes (
    private val mList: List<DataRecipes>,
    private val listener: Communicator
    ) : RecyclerView.Adapter<RVAdapterRecipes.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val DataRecipes = mList[position]

        holder.image.setImageResource(DataRecipes.image)
        holder.title.text = DataRecipes.title

    }

    override fun getItemCount() = mList.size

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView), View.OnClickListener {
        val image: ImageView = itemView.findViewById(R.id.imageRecipe)
        val title: TextView = itemView.findViewById(R.id.titleRecipe)

        init {
            itemView.setOnClickListener (this)
        }

        override fun onClick(p0: View?) {
            val image = mList[adapterPosition].image
            val title =  mList[adapterPosition].title
            val description =  mList[adapterPosition].description

            listener.passData(title, image, description)
        }

    }

}
