package ru.stankin.labs.bekmurzaev2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView

class ProductDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_detail, container, false)
        val nameView: TextView = view.findViewById(R.id.product_detail_name)
        val priceView: TextView = view.findViewById(R.id.product_detail_price)
        val ratingView: TextView = view.findViewById(R.id.product_detail_rating)
        val descriptionView: TextView = view.findViewById(R.id.product_detail_description)
        val warrantyView: TextView = view.findViewById(R.id.product_detail_warranty)
        val callIntentButton: Button = view.findViewById(R.id.button_call_intent)

        // Получаем данные о товаре из аргументов фрагмента
        val productName = arguments?.getString("productName")
        val productPrice = arguments?.getString("productPrice")
        val productRating = arguments?.getString("productRating")
        val productDescription = arguments?.getString("productDescription")
        val productWarranty = arguments?.getString("productWarranty")

        nameView.text = productName
        priceView.text = "Price: $productPrice$"
        ratingView.text = "Rating: $productRating"
        descriptionView.text = "Short description: $productDescription"
        warrantyView.text = "Warranty: $productWarranty months"

        callIntentButton.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:88005553535")
            startActivity(callIntent)        }

        return view
    }

    companion object {
        const val ARG_PRODUCT_NAME = "productName"
        const val ARG_PRODUCT_PRICE = "productPrice"
        const val ARG_PRODUCT_RATING = "productRating"
        const val ARG_PRODUCT_DESCRIPTION = "productDescription"
        const val ARG_PRODUCT_WARRANTY = "productWarranty"

        fun newInstance(
            productName: String,
            productPrice: String,
            productRating: String,
            productDescription: String,
            productWarranty: String
        ): ProductDetailFragment {
            val fragment = ProductDetailFragment()
            val args = Bundle()
            args.putString(ARG_PRODUCT_NAME, productName)
            args.putString(ARG_PRODUCT_PRICE, productPrice)
            args.putString(ARG_PRODUCT_RATING, productRating)
            args.putString(ARG_PRODUCT_DESCRIPTION, productDescription)
            args.putString(ARG_PRODUCT_WARRANTY, productWarranty)
            fragment.arguments = args
            return fragment
        }
    }
}
