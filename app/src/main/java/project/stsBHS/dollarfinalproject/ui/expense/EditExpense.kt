package project.stsBHS.dollarfinalproject.ui.expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_expenditure.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.uiThread
import org.w3c.dom.Entity
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.Session
import project.stsBHS.dollarfinalproject.databinding.FragmentEditExpenseBinding
import project.stsBHS.dollarfinalproject.db.ExpenseEntity
import project.stsBHS.dollarfinalproject.db.FinanceDatabase

class EditExpense : Fragment() {

    private lateinit var binding: FragmentEditExpenseBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var session = Session(context)
        var item = session.getSelectedId()?.toLong()

        var db = context?.let { FinanceDatabase.getInstance(it) }

        binding = FragmentEditExpenseBinding.inflate(layoutInflater)

        binding.btnModify.setOnClickListener{ view: View ->
            doAsync {
                var id = item
                var year = binding.datePicker.year.toString()
                var month = (binding.datePicker.month.toString().toInt() + 1).toString()
                var day = binding.datePicker.dayOfMonth.toString()
                var date = "$year/$month/$day"
                var desc = binding.editTextDescription.text.toString()
                var amount = binding.editTextAmount.text.toString().toDouble()

                var entity = item?.let { ExpenseEntity(it, date, desc, amount) }

                doAsync {
                    if (entity != null) {
                        db?.financeDao()?.updateExpense(entity)
                    }
                }

            }
            view.findNavController().navigate(R.id.action_editExpense_to_expenditureFragment)
        }

        binding.btnDelete.setOnClickListener{ view: View ->
            doAsync {
                db?.financeDao()?.deleteAExpense(item)
            }

            view.findNavController().navigate(R.id.action_editExpense_to_expenditureFragment)
        }



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