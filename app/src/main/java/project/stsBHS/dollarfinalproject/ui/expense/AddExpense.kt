package project.stsBHS.dollarfinalproject.ui.expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.databinding.FragmentAddExpenseBinding
import project.stsBHS.dollarfinalproject.db.ExpenseEntity
import project.stsBHS.dollarfinalproject.db.FinanceDatabase
import org.jetbrains.anko.doAsync

class AddExpense : Fragment() {

    private lateinit var binding: FragmentAddExpenseBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddExpenseBinding.inflate(layoutInflater)

        binding.btnAdd.setOnClickListener{ view: View ->

            var desc = binding.editTextDescription.text.toString()
            var amount = binding.editTextAmount.text.toString().toDouble()
            var year = binding.datePicker.year.toString()
            var month = binding.datePicker.month.toString()
            var day = binding.datePicker.dayOfMonth.toString()
            var date = "$year/$month/$day"

            if(desc == null || amount == null){
                Toast.makeText(this.context, "Please fill out all fields!!!", Toast.LENGTH_SHORT).show()
            }else{
                doAsync{
                    var expense = ExpenseEntity(0, date, desc, amount)
                    var db = context?.let { FinanceDatabase.getInstance(it) }
                    db?.financeDao()?.insert(expense)
                }

                Toast.makeText(this.context, "Record added to database", Toast.LENGTH_SHORT).show()
            }

            view.findNavController().navigate(R.id.action_addExpense_to_expenditureFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}