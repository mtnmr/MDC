package com.example.mdcsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mdcsample.model.ProductEntry

class ProductCardRecyclerViewAdapter(private val productList : List<ProductEntry>)
    :RecyclerView.Adapter<ProductCardViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCardViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ProductCardViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ProductCardViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = productList.size

}


class ProductCardViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

}