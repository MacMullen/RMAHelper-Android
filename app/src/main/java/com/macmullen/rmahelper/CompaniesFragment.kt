package com.macmullen.rmahelper


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CompaniesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_companies, container, false)
    }


    companion object {
        fun newInstance(): CompaniesFragment {
            return CompaniesFragment()
        }
    }
}

