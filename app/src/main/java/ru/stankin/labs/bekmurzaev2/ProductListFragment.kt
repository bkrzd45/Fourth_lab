package ru.stankin.labs.bekmurzaev2

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductListFragment : Fragment(), ProductItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.list)
        val adapter = productsAdapter(products(), this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    override fun onProductItemClick(product: productItem) {
        val productDetailFragment = ProductDetailFragment.newInstance(
            product.name,
            product.price.toString(),
            product.rating.toString(),
            product.description,
            product.warrantyPeriod.toString()
        )
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, productDetailFragment)
                .addToBackStack(null)
                .commit()        }
        else
        {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.data_fragment_container, productDetailFragment)
                .addToBackStack(null)
                .commit()        }

    }
}
