package com.macmullen.rmahelper

class ProductCardView(imageResource: Int, text: String) {
    private var mImageResource: Int = imageResource
    private var line1: String = text

    fun ProductCardView(imageResource: Int, text1: String) {
        mImageResource = imageResource
        line1 = text1
    }

    fun getImageResource(): Int {
        return mImageResource
    }

    fun getLine1(): String {
        return line1
    }

}