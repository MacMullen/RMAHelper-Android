package com.macmullen.rmahelper


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
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line2"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line3"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line4"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line5"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line2"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line3"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line4"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line5"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line2"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line3"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line4"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line5"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line1"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line2"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line3"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line4"))
        exampleList.add(ProductCardView(R.drawable.ic_tablet_black_24dp, "Line5"))

        mRecyclerView = activity!!.findViewById(R.id.productsRecyclerView)
//        mRecyclerView.setHasFixedSize(true)
        mLayoutmanager = LinearLayoutManager(context)
        mAdapter = RecyclerViewAdapter(exampleList.toList())

        mRecyclerView.layoutManager = mLayoutmanager
        mRecyclerView.adapter = mAdapter
        var fab = activity!!.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            Toast.makeText(activity!!.applicationContext, "To be implemented", Toast.LENGTH_LONG).show()
        }
    }


    companion object {
        fun newInstance(): ProductsFragment {
            return ProductsFragment()
        }
    }
}
