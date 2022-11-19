package com.example.demo.ui.activity

import android.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.databinding.ActivityProductDetailBinding
import com.example.demo.models.Product
import com.example.demo.utils.Constants
import com.squareup.picasso.Picasso

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_product_detail)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
        val product = intent.getParcelableExtra<Product>(Constants.PRoDUCT_DETAILS)

        product?.let {
            binding.textViewTitle.text = it.title
           val rating= String.format("%.1f", it.ratingCount).toDouble()
            binding.txtRating.text = rating.toString()
            for (priceValue in it.price){
                binding.textViewPrice.text = "$ ${priceValue.value.toString()}"
            }
            Picasso.get()
                .load(it.imageURL)
                .into(binding.imageView)

            for (favoriteItem in Constants.favoriteList) {
                if (favoriteItem.id.equals(product.id)) {
                    binding.imageFavorite.setImageResource(com.example.demo.R.drawable.ic_favorite_)
                }
            }

            binding.imageFavorite.setOnClickListener {
                var isAdded =true
                for(favoriteList in Constants.favoriteList){
                    if (favoriteList.id.equals(product.id)){
                        isAdded =false
                    }
                }
                if (isAdded){
                    binding.imageFavorite.setImageResource(com.example.demo.R.drawable.ic_favorite_)
                    Constants.favoriteList.add(product)
                }
            }
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}