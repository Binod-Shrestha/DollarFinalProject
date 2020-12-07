package project.stsBHS.dollarfinalproject.ui.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import project.stsBHS.dollarfinalproject.R

class EarningsFragment : Fragment() {

    private lateinit var earningsViewModel: EarningsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        earningsViewModel =
                ViewModelProvider(this).get(EarningsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_earnings, container, false)
        val textView: TextView = root.findViewById(R.id.text_income)
        earningsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}