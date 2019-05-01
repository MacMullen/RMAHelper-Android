package com.macmullen.rmahelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_NAME = "ProductsDB"
val PRODUCTS_TABLE_NAME = "Products"
val COL_ID = "ID"
val COL_BRAND = "brand"
val COL_MODEL = "model"
val COL_DIST_COMPANY = "company"
val COL_EAN = "ean"
val COL_ACCESSORIES = "accessories"

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable =
            "CREATE TABLE " + PRODUCTS_TABLE_NAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_BRAND + " VARCHAR(256)," + COL_MODEL + " VARCHAR(256)," + COL_DIST_COMPANY + " VARCHAR(256)," + COL_EAN + " VARCHAR(256)," + COL_ACCESSORIES + " VARCHAR(256))"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertProduct(product: Product): Long {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_BRAND, product.brand)
        cv.put(COL_MODEL, product.model)
        cv.put(COL_DIST_COMPANY, product.dist_company)
        cv.put(COL_EAN, product.ean)
        cv.put(COL_ACCESSORIES, product.accessories)
        return db.insert(PRODUCTS_TABLE_NAME, null, cv)
    }
}