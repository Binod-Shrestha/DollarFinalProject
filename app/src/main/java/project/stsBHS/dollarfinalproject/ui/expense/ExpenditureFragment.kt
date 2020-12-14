//Author: Hemraj Kafle
//Student#: 991511170

//This fragment contains UI layouts for showing the list of Expense entity from expenses table in database



package project.stsBHS.dollarfinalproject.ui.expense

import project.stsBHS.dollarfinalproject.ListItem
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
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.Session
import project.stsBHS.dollarfinalproject.databinding.FragmentExpenditureBinding
import project.stsBHS.dollarfinalproject.db.FinanceDatabase

//This kotlin class provides backend functionality to FragmentExpenditure

class ExpenditureFragment : Fragment() {

    private lateinit var binding: FragmentExpenditureBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentExpenditureBinding.inflate(layoutInflater)

        //onclick function for add button
        binding.fab.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_expenditureFragment_to_addExpense)
        }

        //onclick function for edit/delete button
        binding.feb.setOnClickListener{ view: View ->
            var session = Session(context)
            var item = session.getSelectedId()

            if(item?.toInt()!! > 0){
                view.findNavController().navigate(R.id.action_expenditureFragment_to_editExpense)
            }else{
                Toast.makeText(context, "Please Select one of the Record to Edit!!!", Toast.LENGTH_LONG).show();
            }

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
                        expenseList += ListItem(expense.id, expense.date, expense.description, expense.amount, false)
                    }
                }
                recycleView.adapter = MyRecyclerView(expenseList)
                recycleView.layoutManager = LinearLayoutManager(view.context)
                recycleView.setHasFixedSize(true)
            }
        }
    }
}