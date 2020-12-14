package project.stsBHS.dollarfinalproject.ui.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.jetbrains.anko.doAsync
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.databinding.FragmentAddEarningBinding
import project.stsBHS.dollarfinalproject.db.ExpenseEntity
import project.stsBHS.dollarfinalproject.db.FinanceDatabase
import project.stsBHS.dollarfinalproject.db.IncomeEntity

class AddEarning : Fragment() {

    private lateinit var binding: FragmentAddEarningBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddEarningBinding.inflate(layoutInflater)
        binding.btnAdd.setOnClickListener{ view: View ->

            var desc = binding.editTextDescription.text.toString()
            var amount = (((binding.editTextAmount.text.toString().toDouble() * 100).toInt()).toDouble())/100
            var year = binding.datePicker.year.toString()
            var month = (binding.datePicker.month.toString().toInt() + 1).toString()
            var day = binding.datePicker.dayOfMonth.toString()
            var date = "$year/$month/$day"

            if(desc == null || amount == null){
                Toast.makeText(this.context, "Please fill out all fields!!!", Toast.LENGTH_SHORT).show()
            }else{
                doAsync{
                    var income = IncomeEntity(0, date, desc, amount)
                    var db = context?.let { FinanceDatabase.getInstance(it) }
                    db?.financeDao()?.insertIncome(income)
                }

                Toast.makeText(this.context, "Record added to database", Toast.LENGTH_SHORT).show()
                view.findNavController().navigate(R.id.action_addEarning_to_earningsFragment)
            }

        }

        setHasOptionsMenu(true)
        return binding.root
    }
}