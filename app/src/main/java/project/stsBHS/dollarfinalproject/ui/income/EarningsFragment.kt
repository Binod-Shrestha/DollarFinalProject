package project.stsBHS.dollarfinalproject.ui.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_expenditure.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.uiThread
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.databinding.FragmentEarningsBinding
import project.stsBHS.dollarfinalproject.db.FinanceDatabase

class EarningsFragment : Fragment() {

    private lateinit var binding: FragmentEarningsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEarningsBinding.inflate(layoutInflater)
        binding.fab.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_earningsFragment_to_addEarning)
        }
        binding.feb.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_earningsFragment_to_modifyEarningsFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val earningsList = ArrayList<ListItem>()
        var db = context?.let { FinanceDatabase.getInstance(it) }

        doAsync {
            var earnings = db?.financeDao()?.getAllEarnings()
            uiThread {
                if (earnings != null) {
                    for (earning in earnings) {
                        earningsList += ListItem(earning.id, earning.date, earning.description, earning.amount
                        )
                    }
                }
                recycleView.adapter = MyRecyclerView(earningsList)
                recycleView.layoutManager = LinearLayoutManager(view.context)
                recycleView.setHasFixedSize(true)
            }
        }
    }
}