package com.macmullen.rmahelper

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_product.*

class ViewProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_product)
        setSupportActionBar(findViewById(R.id.viewProductToolbar))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        getIntentExtras()
    }

    fun getIntentExtras() {
        val cursor: Cursor = DatabaseHandler(applicationContext).writableDatabase.query(
            PRODUCTS_TABLE_NAME, null, null, null, null, null,
            COL_ID
        )
        cursor.moveToPosition(intent.getIntExtra("product_id", 0))
        title = cursor.getString(cursor.getColumnIndex(COL_MODEL)).toUpperCase()
    }
}
