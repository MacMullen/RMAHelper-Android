package com.macmullen.rmahelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import com.weiwangcn.betterspinner.library.BetterSpinner
import kotlinx.android.synthetic.main.activity_add_product.*
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class AddProductActivity : AppCompatActivity() {

    var accList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        setSupportActionBar(findViewById(R.id.addProductToolbar))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        title = "New Product"

        fun getCompanyNames(): List<String> {
            return mutableListOf("Hola", "Chau").toList()
        }

        var mAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line, getCompanyNames()
        )
        var spinner = findViewById<BetterSpinner>(R.id.companySpinner)
        spinner.setAdapter(mAdapter)

        var mAddButton = findViewById<Button>(R.id.addAccessoryButton)
        mAddButton.setOnClickListener {
            //            addAccesoryToList()
        }

        var mSaveButton = findViewById<ImageButton>(R.id.saveNewProductButton)
        mSaveButton.setOnClickListener {
            Snackbar.make(it, R.string.item_saved, Snackbar.LENGTH_SHORT).show()
        }

        this.scanButton.setOnClickListener {
            run {
                IntentIntegrator(this).initiateScan();
            }
        }

        this.addAccessoryButton.setOnClickListener {
            addAccesoryToList()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun addAccesoryToList() {
        val newAccesory = CheckedTextView(this)
        newAccesory.text = "USB"
        newAccesory.isChecked = true
        accList.add(newAccesory.toString())
        this.accessoryListVIew.addView(newAccesory)
        this.accesoryInputText.setText("")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        var result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            if (result.contents != null) {
                eanInputText.setText(result.contents)
            } else {
                eanInputText.setText("Scan Failed!")
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}
