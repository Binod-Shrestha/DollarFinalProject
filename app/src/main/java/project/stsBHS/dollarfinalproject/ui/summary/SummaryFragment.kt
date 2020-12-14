package project.stsBHS.dollarfinalproject.ui.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.databinding.FragmentSummaryBinding
import project.stsBHS.dollarfinalproject.db.FinanceDatabase
import java.util.*


class SummaryFragment : Fragment() {

    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSummaryBinding.inflate(
            inflater, container, false
        )

        binding.btnCancel.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_summaryFragment_to_nav_home)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var year_picker = binding.yearPicker
        var currentYear = Calendar.getInstance().get(Calendar.YEAR)
        year_picker.minValue = currentYear - 5
        year_picker.maxValue = currentYear
        year_picker.wrapSelectorWheel = true
        year_picker.setOnValueChangedListener { picker, oldVal, newVal ->
        }
        val months = arrayOf(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        )
        var month_picker = binding.monthPicker
        month_picker.minValue = 1
        month_picker.maxValue = months.size
        month_picker.wrapSelectorWheel = true
        month_picker.displayedValues = months
        month_picker.setOnValueChangedListener { picker, oldVal, newVal ->
           // binding.labelAnalysis.text = "$newVal"
        }

        var db = context?.let { FinanceDatabase.getInstance(it) }
        var totalExpense: Double = 0.0
        var totalIncome: Double = 0.0
        doAsync {
            var expenses = db?.financeDao()?.getAllExpenses()
            if (expenses != null) {
                for (x in expenses) totalExpense += x.amount

            }
            //for incomes
           // var incomes = db?.financeDao()?.getAllIncomes()
            //if (incomes != null) {
            //    for(x in incomes) totalIncome += x.incomes
           // }
            uiThread {
                totalExpense = (((totalExpense * 100).toInt()).toDouble()) / 100
                totalIncome = (((totalIncome * 100).toInt()).toDouble()) / 100
                binding.labelExpense.text = "$ " + totalExpense.toString()
                binding.labelIncome.text = "$ " + totalIncome.toString()
            }


        }


        // Analysis of income and expense
        when {
            totalIncome > totalExpense -> binding.labelAnalysis.text = "Saving Good"
            totalIncome < totalExpense -> binding.labelAnalysis.text = "Conrol your Expense"
            else -> binding.labelAnalysis.text = "Break Even"
        }


    }


}


