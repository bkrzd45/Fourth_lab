package ru.stankin.labs.bekmurzaev2

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), ProductItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        set_layout()
        fill_list()
    }

    override fun onConfigurationChanged(newConfig: Configuration)
    {
        super.onConfigurationChanged(newConfig)
        set_layout()
        fill_list()
    }

    fun fill_list()
    {
        val productListFragment = ProductListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, productListFragment)
            .commit()
    }

    fun set_layout()
    {
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main)
        }
        else
        {
            setContentView(R.layout.ls_activity)
        }
    }

    override fun onProductItemClick(product: productItem) {
        val productDetailFragment = ProductDetailFragment.newInstance(
            product.name,
            product.price.toString(),
            product.rating.toString(),
            product.description,
            product.warrantyPeriod.toString()
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, productDetailFragment)
            .addToBackStack(null)
            .commit()
    }
}
