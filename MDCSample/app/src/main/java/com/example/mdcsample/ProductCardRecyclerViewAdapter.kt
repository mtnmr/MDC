package com.example.mdcsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mdcsample.model.ProductEntry

class ProductCardRecyclerViewAdapter(private val productList : List<ProductEntry>)
    :RecyclerView.Adapter<ProductCardViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCardViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ProductCardViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ProductCardViewHolder, position: Int) {
        if (position < productList.size) {
            val product = productList[position]
            holder.productTitle.text = product.title
            holder.productPrice.text = product.price
        }
    }

    override fun getItemCount(): Int = productList.size

}


class ProductCardViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var productTitle: TextView = itemView.findViewById(R.id.product_title)
    var productPrice: TextView = itemView.findViewById(R.id.product_price)
}