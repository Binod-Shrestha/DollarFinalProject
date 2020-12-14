package project.stsBHS.dollarfinalproject.ui.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_expenditure.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.uiThread
import project.stsBHS.dollarfinalproject.ListItem
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.Session
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
            var session = Session(context)
            var item = session.getSelectedId()

            if(item?.toInt()!! > 0){
                view.findNavController().navigate(R.id.action_earningsFragment_to_modifyEarningsFragment)
            }else{
                Toast.makeText(context, "Please Select one of the Record to Edit!!!", Toast.LENGTH_LONG).show();
            }

        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val incomeList = ArrayList<ListItem>()
        var db = context?.let { FinanceDatabase.getInstance(it) }

        doAsync {
            var incomes = db?.financeDao()?.getAllIncomes()
            uiThread {
                if (incomes != null) {
                    for (expense in incomes) {
                        incomeList += ListItem(expense.id, expense.date, expense.description, expense.amount, false)
                    }
                }
                recycleView.adapter = MyRecyclerView(incomeList)
                recycleView.layoutManager = LinearLayoutManager(view.context)
                recycleView.setHasFixedSize(true)
            }
        }
    }
}