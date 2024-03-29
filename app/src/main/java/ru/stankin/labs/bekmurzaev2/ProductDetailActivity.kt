package ru.stankin.labs.bekmurzaev2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val nameView: TextView = findViewById(R.id.product_detail_name)
        val priceView: TextView = findViewById(R.id.product_detail_price)
        val ratingView: TextView = findViewById(R.id.product_detail_rating)
        val descriptionView: TextView = findViewById(R.id.product_detail_description)
        val warrantyView: TextView = findViewById(R.id.product_detail_warranty)
        val callIntentButton: Button = findViewById(R.id.button_call_intent)

        nameView.text = intent.getStringExtra("productName")
        priceView.text = "Price: "+intent.getStringExtra("productPrice")+"$"
        ratingView.text = "Rating: " + intent.getStringExtra("productRating")
        descriptionView.text = "Short description: " + intent.getStringExtra("productDescription")
        warrantyView.text = "Warranty: " + intent.getStringExtra("productWarranty")+" months"

        callIntentButton.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:88005553535")
            startActivity(callIntent)
        }
    }
}
