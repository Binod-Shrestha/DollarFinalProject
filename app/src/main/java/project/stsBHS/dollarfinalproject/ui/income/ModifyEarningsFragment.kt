package project.stsBHS.dollarfinalproject.ui.income

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
import project.stsBHS.dollarfinalproject.databinding.ModifyEarningsFragmentBinding
import project.stsBHS.dollarfinalproject.db.IncomeEntity
import project.stsBHS.dollarfinalproject.db.FinanceDatabase

class ModifyEarningsFragment : Fragment() {

    private lateinit var binding: ModifyEarningsFragmentBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var session = Session(context)
        var item = session.getSelectedId()?.toLong()

        var db = context?.let { FinanceDatabase.getInstance(it) }

        binding = ModifyEarningsFragmentBinding.inflate(layoutInflater)

        binding.btnModifyEarning.setOnClickListener{ view: View ->
            doAsync {
                var id = item
                var year = binding.datePicker.year.toString()
                var month = (binding.datePicker.month.toString().toInt() + 1).toString()
                var day = binding.datePicker.dayOfMonth.toString()
                var date = "$year/$month/$day"
                var desc = binding.editTextDescription.text.toString()
                var amount = (((binding.editTextAmount.text.toString().toDouble() * 100).toInt()).toDouble())/100

                var entity = item?.let { IncomeEntity(it, date, desc, amount) }

                doAsync {
                    if (entity != null) {
                        db?.financeDao()?.updateIncome(entity)
                    }
                }

            }
            view.findNavController().navigate(R.id.action_modifyEarningsFragment_to_earningsFragment)
        }

        binding.btnDeleteEarning.setOnClickListener{ view: View ->
            doAsync {
                db?.financeDao()?.deleteIncome(item)
            }

            view.findNavController().navigate(R.id.action_modifyEarningsFragment_to_earningsFragment)
        }



        doAsync {
            var income = db?.financeDao()?.getIncome(item)
            uiThread {
                binding.editTextDescription.setText(income?.description)
                binding.editTextAmount.setText(income?.amount.toString())
            }
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}