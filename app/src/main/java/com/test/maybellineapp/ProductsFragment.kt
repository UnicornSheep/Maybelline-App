package com.test.maybellineapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.test.maybellineapp.adapters.ProductsAdapter
import com.test.maybellineapp.dataaccess.models.Product
import com.test.maybellineapp.viewmodels.ProductsViewModel

class ProductsFragment : Fragment() {

    private val viewModel: ProductsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val productsView : RecyclerView = view.findViewById(R.id.productsView)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        viewModel.products.observe({ lifecycle }){
            progressBar.visibility = View.INVISIBLE
            productsView.adapter = ProductsAdapter(it, object : ProductsAdapter.Interactions{
                override fun onClick(product: Product) {
                    viewModel.select(product)
                    findNavController(this@ProductsFragment).navigate(R.id.ProductDetailsFragment)
                }

            })
        }

    }
}