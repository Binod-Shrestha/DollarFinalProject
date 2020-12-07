package org.sheridancollege.expensetracker

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import project.stsBHS.dollarfinalproject.R

class ModifyEarningsFragment : Fragment() {

    companion object {
        fun newInstance() = ModifyEarningsFragment()
    }

    private lateinit var viewModel: ModifyEarningsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.modify_earnings_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ModifyEarningsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}