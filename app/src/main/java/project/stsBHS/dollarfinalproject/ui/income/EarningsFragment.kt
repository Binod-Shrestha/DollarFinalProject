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
import org.sheridancollege.expensetracker.ListItem
import org.sheridancollege.expensetracker.MyRecyclerView
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.databinding.FragmentEarningsBinding

class EarningsFragment : Fragment() {

    private lateinit var binding: FragmentEarningsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEarningsBinding.inflate(layoutInflater)
        binding.fab.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_earningFragment_to_addEarning)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        var incomeList = generateIncomeList()


        recycleView.adapter = MyRecyclerView(incomeList)
        recycleView.layoutManager = LinearLayoutManager(this.context)
        recycleView.setHasFixedSize(true)
    }

    private fun generateIncomeList(): List<ListItem> {
        val list = ArrayList<ListItem>()
        list += ListItem("2020/12/06", "Payroll", 2500.00)
        list += ListItem("2020/12/04", "Benefits", 65.78)

        return list
    }
}