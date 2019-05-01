package com.macmullen.rmahelper


import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.thekhaeng.recyclerviewmargin.LayoutMarginDecoration
import java.util.*

class ProductsFragment : Fragment() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>
    private var GET_NEW_PRODUCTS = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity!!.title = resources.getString(R.string.products)

        mRecyclerView = activity!!.findViewById(R.id.productsRecyclerView)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = context?.let { ProductAdapter(it, getAllItems()) }!!
        mRecyclerView.adapter = mAdapter

        var fab = activity!!.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(activity, AddProductActivity::class.java)
            startActivityForResult(intent, GET_NEW_PRODUCTS)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == GET_NEW_PRODUCTS) {
            if (resultCode == Activity.RESULT_OK) {
                mAdapter = context?.let { ProductAdapter(it, getAllItems()) }!!
                mRecyclerView.adapter = mAdapter
            }
        }
    }

    companion object {
        fun newInstance(): ProductsFragment {
            return ProductsFragment()
        }
    }

    private fun getAllItems(): Cursor {
        return context?.let {
            DatabaseHandler(it).writableDatabase.query(
                PRODUCTS_TABLE_NAME, null, null, null, null, null,
                COL_BRAND
            )
        }!!
    }
}
