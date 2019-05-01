package com.macmullen.rmahelper

class ProductCardView(imageResource: Int, model: String, brand: String) {
    private var mImageResource: Int = imageResource
    private var brandLine: String = brand
    private var modelLine: String = model

    fun getImageResource(): Int {
        return mImageResource
    }

    fun getBrand(): String {
        return brandLine
    }

    fun getModel(): String {
        return modelLine
    }

}