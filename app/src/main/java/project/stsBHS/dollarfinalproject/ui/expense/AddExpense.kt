//Author: Hemraj Kafle
//Student#: 991511170

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

//This kotlin class provides backend functionality to AddExpenseFragment
class AddExpense : Fragment() {

    private lateinit var binding: FragmentAddExpenseBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddExpenseBinding.inflate(layoutInflater)

        binding.btnAdd.setOnClickListener{ view: View ->

            //retrive the values of datepickers and editTexts from the fragment
            var desc = binding.editTextDescription.text.toString()
            var amount = (((binding.editTextAmount.text.toString().toDouble() * 100).toInt()).toDouble())/100
            var year = binding.datePicker.year.toString()
            var month = (binding.datePicker.month.toString().toInt() + 1).toString()
            var day = binding.datePicker.dayOfMonth.toString()
            var date = "$year/$month/$day"

            //print toast message if clicked without inputting values
            if(desc == null || amount == null){
                Toast.makeText(this.context, "Please fill out all fields!!!", Toast.LENGTH_SHORT).show()
            }else{
                //inserts to the database
                doAsync{
                    var expense = ExpenseEntity(0, date, desc, amount)
                    var db = context?.let { FinanceDatabase.getInstance(it) }
                    db?.financeDao()?.insertExpense(expense)
                }

                Toast.makeText(this.context, "Record added to database", Toast.LENGTH_SHORT).show()
            }

            view.findNavController().navigate(R.id.action_addExpense_to_expenditureFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}