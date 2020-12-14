//Author: Hemraj Kafle
//Student#: 991511170

//This fragment contains UI layouts for editing or deleting existing Expense entity in the db

package project.stsBHS.dollarfinalproject.ui.expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.uiThread
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.Session
import project.stsBHS.dollarfinalproject.databinding.FragmentEditExpenseBinding
import project.stsBHS.dollarfinalproject.db.ExpenseEntity
import project.stsBHS.dollarfinalproject.db.FinanceDatabase

//This kotlin class provides backend functionality to FragmentEditExpense
class EditExpense : Fragment() {

    private lateinit var binding: FragmentEditExpenseBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        //get the id of selected cardView from Session
        var session = Session(context)
        var item = session.getSelectedId()?.toLong()

        //instance of db object
        var db = context?.let { FinanceDatabase.getInstance(it) }

        binding = FragmentEditExpenseBinding.inflate(layoutInflater)

        //onclick function for Modify button
        binding.btnModify.setOnClickListener{ view: View ->
            doAsync {

                //retrieve the required values from fragments
                var id = item
                var year = binding.datePicker.year.toString()
                var month = (binding.datePicker.month.toString().toInt() + 1).toString()
                var day = binding.datePicker.dayOfMonth.toString()
                var date = "$year/$month/$day"
                var desc = binding.editTextDescription.text.toString()
                var amount = (((binding.editTextAmount.text.toString().toDouble() * 100).toInt()).toDouble())/100

                var entity = id?.let { ExpenseEntity(it, date, desc, amount) }

                //updates the record in db if entity is not null
                doAsync {
                    if (entity != null) {
                        db?.financeDao()?.updateExpense(entity)
                    }
                }

            }
            view.findNavController().navigate(R.id.action_editExpense_to_expenditureFragment)
        }

        //onclick function for delete button
        binding.btnDelete.setOnClickListener{ view: View ->
            doAsync {
                db?.financeDao()?.deleteExpense(item)
            }

            view.findNavController().navigate(R.id.action_editExpense_to_expenditureFragment)
        }



        //set the values retrived from db to the textboxes
        doAsync {
            var expense = db?.financeDao()?.getExpense(item)
            uiThread {
                binding.editTextDescription.setText(expense?.description)
                binding.editTextAmount.setText(expense?.amount.toString())
            }
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}