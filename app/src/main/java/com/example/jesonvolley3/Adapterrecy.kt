package com.example.jesonvolley3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapterrecy
    (val context: Context, val list: List<DataModel>):
    RecyclerView.Adapter<Adapterrecy.ViewHolder>() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView1: TextView = view.findViewById(R.id.text1)
        val image1: ImageView = view.findViewById(R.id.image1)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapterrecy.ViewHolder {
        val rowView = inflater.inflate(R.layout.list_row, parent, false)
        return ViewHolder(rowView)

    }

    override fun onBindViewHolder(holder: Adapterrecy.ViewHolder, position: Int) {
        holder.textView1.text = list.get(position).name.toString()
            // holder.image1.setImageResource(image[position])
            Glide.with(context)
                .load(list.get(position).image)
                .into(holder.image1)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
