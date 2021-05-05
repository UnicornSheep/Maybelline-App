package com.test.maybellineapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.squareup.picasso.Picasso
import com.test.maybellineapp.viewmodels.ProductsViewModel
import com.willy.ratingbar.ScaleRatingBar

class ProductDetailsFragment : Fragment() {
    private val viewModel: ProductsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val productImage = view.findViewById<ImageView>(R.id.productImage)
        val productName = view.findViewById<TextView>(R.id.productName)
        val productPrice = view.findViewById<TextView>(R.id.productPrice)
        val productRating = view.findViewById<ScaleRatingBar>(R.id.productRating)
        val productDescription = view.findViewById<TextView>(R.id.productDescription)

        viewModel.selected.observe({lifecycle}){
            Picasso.get().load(it.image_link).into(productImage)
            productName.setText(it.nameNormalised)
            productPrice.setText(it.price.toString())
            productRating.rating = it.rating.toFloat()
            productDescription.setText(it.description)
        }
    }
}