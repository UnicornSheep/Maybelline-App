package com.test.maybellineapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.maybellineapp.R
import com.test.maybellineapp.dataaccess.models.Product
import org.w3c.dom.Text

class ProductsAdapter(private val products:List<Product>, private val onInteraction: ProductsAdapter.Interactions) : RecyclerView.Adapter<ProductViewHolder>() {
    interface Interactions {
        fun onClick(product: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.listitem_productpreview, parent, false))
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
        holder.itemView.setOnClickListener { onInteraction.onClick(products[position]) }
    }
}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(product : Product){
        itemView.apply {
            findViewById<ImageView>(R.id.productImage).apply {
                Picasso.get().load(product.image_link).into(this)
            }
            findViewById<TextView>(R.id.productName).setText(product.nameNormalised)
            findViewById<TextView>(R.id.productPrice).setText(product.price.toString())

        }

    }
}
