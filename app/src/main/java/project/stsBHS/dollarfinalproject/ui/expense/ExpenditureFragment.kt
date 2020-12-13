package project.stsBHS.dollarfinalproject.ui.expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_expenditure.*import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.databinding.FragmentExpenditureBinding
import project.stsBHS.dollarfinalproject.db.FinanceDatabase

class ExpenditureFragment : Fragment() {

    private lateinit var binding: FragmentExpenditureBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpenditureBinding.inflate(layoutInflater)
        binding.fab.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_expenditureFragment_to_addExpense)
        }
        binding.feb.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_expenditureFragment_to_editExpense)

        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val expenseList = ArrayList<ListItem>()
        var db = context?.let { FinanceDatabase.getInstance(it) }

        doAsync {
            var expenses = db?.financeDao()?.getAllExpenses()
            uiThread {
                if (expenses != null) {
                    for (expense in expenses) {
                        expenseList += ListItem(expense.date, expense.description, expense.amount)
                    }
                }
                recycleView.adapter = MyRecyclerView(expenseList)
                recycleView.layoutManager = LinearLayoutManager(view.context)
                recycleView.setHasFixedSize(true)
            }
        }
    }
}