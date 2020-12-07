package project.stsBHS.dollarfinalproject.ui.expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.databinding.FragmentAddExpenseBinding

class AddExpense : Fragment() {

    private lateinit var binding: FragmentAddExpenseBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddExpenseBinding.inflate(layoutInflater)
        binding.btnAdd.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_addExpense_to_expenditureFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}