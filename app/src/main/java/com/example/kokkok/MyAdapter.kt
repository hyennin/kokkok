package com.example.kokkok

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    // 임시 cardView
    var titles = arrayOf("one", "two", "three", "four", "five")
    var details = arrayOf("Item one", "Item two", "Item three", "Item four", "Itme five")
    var images = intArrayOf(
        R.drawable.cat,
        R.drawable.cat,
        R.drawable.cat,
        R.drawable.cat,
        R.drawable.cat
    )


    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val itemimage: ImageView = itemview.findViewById(R.id.item_image)
        val itemtitle: TextView = itemview.findViewById(R.id.item_title)
        val itemdetail: TextView = itemview.findViewById(R.id.item_detail)
    }

    override fun onCreateViewHolder(viewgroup: ViewGroup, position: Int): MyViewHolder {
        var v: View = LayoutInflater.from(viewgroup.context).inflate(R.layout.card_layout, viewgroup, false)

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // cardView 구성
        holder.itemtitle.setText(titles.get(position))
        holder.itemimage.setImageResource(images.get(position))
        holder.itemdetail.setText(details.get(position))

        holder.itemView.setOnClickListener {
            // 프로젝트 세부 사항 페이지로 이동
            val intent = Intent(holder.itemView.context, GiftInfoActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}