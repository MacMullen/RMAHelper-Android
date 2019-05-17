package com.macmullen.rmahelper

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_product.*
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.squareup.picasso.Picasso


class AddProductActivity : AppCompatActivity() {

    var accList: String = ""
    var imageUriString: Uri = Uri.EMPTY
    private val PICK_IMAGE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        var db = DatabaseHandler(this)
        setSupportActionBar(findViewById(R.id.addProductToolbar))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        title = getString(R.string.new_product)
        accessoryListTextView.visibility = View.GONE
        fun getCompanyNames(): List<String> {
            return mutableListOf("Hola", "Chau").toList()
        }

        var mAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line, getCompanyNames()
        )
        this.companySpinner.setAdapter(mAdapter)

        this.addAccessoryButton.setOnClickListener {
            addAccesoryToList()
        }

        this.saveNewProductButton.setOnClickListener {
            var wrong_field: Boolean = false
            if (brandInputText.text.toString().trim().toLowerCase() == "".toLowerCase()) {
                brandInputLayout.error = resources.getString(R.string.required)
                wrong_field = true
            } else {
                brandInputLayout.error = ""
            }
            if (modelInputText.text.toString().trim().toLowerCase() == "".toLowerCase()) {
                modelInputLayout.error = resources.getString(R.string.required)
                wrong_field = true
            } else {
                modelInputLayout.error = ""
            }
            if (companySpinner.text.toString().trim().toLowerCase() == "".toLowerCase()) {
                companySpinner.error = resources.getString(R.string.required)
                wrong_field = true
            } else {
                companySpinner.setError("", null)
            }
            when (wrong_field) {
                true -> return@setOnClickListener
            }
            val op_result = db.insertProduct(
                Product(
                    brandInputText.text.toString(),
                    modelInputText.text.toString(),
                    companySpinner.text.toString(),
                    eanInputText.text.toString(),
                    accList, imageUriString
                )
            )
            addProductImageVIew.setImageResource(R.drawable.ic_image_black_24dp)
            this.brandInputText.setText("")
            this.modelInputText.setText("")
            this.eanInputText.setText("")
            accessoryChipGroup.removeAllViews()
            if (op_result == (-1).toLong()) {
                Snackbar.make(it, R.string.insert_failed, Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(it, R.string.item_saved, Snackbar.LENGTH_SHORT).show()
            }
            accessoryListTextView.visibility = View.GONE
        }

        this.scanButton.setOnClickListener {
            run {
                IntentIntegrator(this).initiateScan()
            }
        }

        this.addAccessoryButton.setOnClickListener {
            addAccesoryToList()
        }

        this.accesoryInputText.setOnEditorActionListener { _, keyCode, keyEvent ->
            if ((keyEvent != null && (keyEvent.keyCode == KeyEvent.KEYCODE_ENTER) && (keyEvent.action == KeyEvent.ACTION_UP)) || (keyCode == EditorInfo.IME_ACTION_DONE)) {
                this.addAccessoryButton.performClick()
            } else {
                false
            }
        }

        this.addProductImageVIew.setOnClickListener {
            openGallery()
        }
    }

    override fun onBackPressed() {
        val resultIntent = Intent()
        intent.putExtra("keyName", "YOLO")
        setResult(Activity.RESULT_OK, resultIntent)
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            val resultIntent = Intent()
            intent.putExtra("keyName", "YOLO")
            setResult(Activity.RESULT_OK, resultIntent)
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun addAccesoryToList() {
        val newAccesory = Chip(this)
        newAccesory.text = accesoryInputText.text
        newAccesory.isCloseIconVisible = true
        newAccesory.setOnCloseIconClickListener {
            accessoryChipGroup.removeView(it)
            if (accessoryChipGroup.childCount == 0) {
                accessoryListTextView.visibility = View.GONE
            }
        }
        accList = if (accessoryChipGroup.childCount == 0) {
            newAccesory.text.toString()
        } else {
            accList + "$$" + newAccesory.text.toString()
        }
        accessoryListTextView.visibility = View.VISIBLE

        this.accessoryChipGroup.addView(newAccesory)
        this.accesoryInputText.setText("")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE && data != null) {
            imageUriString = data.data
            Picasso.get().load(data.data).noPlaceholder().fit().centerInside().into((this.addProductImageVIew))
        }
        val result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

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

    fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE)
    }
}
