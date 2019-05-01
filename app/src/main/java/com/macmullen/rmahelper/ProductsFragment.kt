package com.macmullen.rmahelper


import android.content.Intent
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
    private lateinit var mAdapter: RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>
    private lateinit var mLayoutmanager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var exampleList = mutableListOf<ProductCardView>()
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "TAB024C", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "TAB024B", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "TAB0032", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "TAB032B", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_smartphone_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_smartphone_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_smartphone_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_smartphone_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_smartphone_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1", "GADNIC"))

        mRecyclerView = activity!!.findViewById(R.id.productsRecyclerView)
        mRecyclerView.setHasFixedSize(true)
        mLayoutmanager = LinearLayoutManager(context)
        mAdapter = RecyclerViewAdapter(exampleList.toList())

        activity!!.title = "Products"

        mRecyclerView.layoutManager = mLayoutmanager
        mRecyclerView.addItemDecoration(LayoutMarginDecoration(1, -1))
        mRecyclerView.adapter = mAdapter
        var fab = activity!!.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(activity, AddProductActivity::class.java)
            startActivity(intent)
        }
    }


    companion object {
        fun newInstance(): ProductsFragment {
            return ProductsFragment()
        }
    }
}
