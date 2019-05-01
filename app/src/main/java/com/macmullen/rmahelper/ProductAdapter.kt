package com.macmullen.rmahelper

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter constructor(context: Context, cursor: Cursor) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var mContext: Context = context
    private var mCursor: Cursor = cursor

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImageView = itemView.findViewById<ImageView>(R.id.iconView)
        var mModelLine = itemView.findViewById<TextView>(R.id.modelText)
        var mBrandLine = itemView.findViewById<TextView>(R.id.brandText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var inflater = LayoutInflater.from(mContext)
        var view = inflater.inflate(R.layout.product_card_view, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mCursor.count
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        if (!mCursor.moveToPosition(position)) {
            return
        }
        val brand = mCursor.getString(mCursor.getColumnIndex(COL_BRAND))
        val model = mCursor.getString(mCursor.getColumnIndex(COL_MODEL))

        holder.mBrandLine.text = brand
        holder.mModelLine.text = model
        holder.mImageView.setImageResource(R.drawable.ic_tablet_black_24dp)
    }

    fun swapCursor(newCursor: Cursor) {
        if (mCursor != null) {
            mCursor.close()
        }
        mCursor = newCursor
        if (newCursor != null) {
            notifyDataSetChanged()
        }

    }
}