package project.stsBHS.dollarfinalproject.ui.expense

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import project.stsBHS.dollarfinalproject.R

class ModifyExpenseFragment : Fragment() {

    companion object {
        fun newInstance() = ModifyExpenseFragment()
    }

    private lateinit var viewModel: ModifyExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.modify_expense_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ModifyExpenseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}