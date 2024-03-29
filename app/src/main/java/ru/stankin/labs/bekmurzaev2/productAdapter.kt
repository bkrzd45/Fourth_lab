package ru.stankin.labs.bekmurzaev2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
/**
 * Адаптер для RecyclerView.
 * Конструктор принимает список контактов.
 * Наследуемся от RecyclerView.Adapter и переопределяем
 * необходимые методы.
 */
class productsAdapter(
    private val products: List<productItem>,
    private val itemClickListener: ProductItemClickListener
): RecyclerView.Adapter<productViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return productViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: productViewHolder, position: Int) {
        holder.bind(products[position])
    }
}



/**
 * ViewHolder элемента списка.
 * Наследуемся от RecyclerView.ViewHolder
 */
interface ProductItemClickListener {
    fun onProductItemClick(product: productItem)
}



class productViewHolder(
    itemView: View,
    private val itemClickListener: ProductItemClickListener
): RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private val nameView: TextView = itemView.findViewById(R.id.product_name)
    private val priceView: TextView = itemView.findViewById(R.id.product_price)
    //private val descriptionView: TextView = itemView.findViewById(R.id.product_description)
    private val ratingView: TextView = itemView.findViewById(R.id.product_rating)

    override fun onClick(view: View) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION) {
            val product = products()[position]
            itemClickListener.onProductItemClick(product)
        }
    }

    init {
        itemView.setOnClickListener(this)
    }

    /**
     * Метод для связывания данных с ViewHolder
     */
    fun bind(item: productItem) {
        // Bind data to views
        nameView.text = item.name
        priceView.text = "$${item.price}"
        //descriptionView.text = item.description
        ratingView.text = "Rating: ${item.rating}"

//        itemView.setOnClickListener {
//            onItemClicked(adapterPosition)
//        }
    }
}