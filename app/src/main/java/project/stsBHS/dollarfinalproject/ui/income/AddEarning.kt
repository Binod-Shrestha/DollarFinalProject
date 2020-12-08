package project.stsBHS.dollarfinalproject.ui.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.databinding.FragmentAddEarningBinding

class AddEarning : Fragment() {

    private lateinit var binding: FragmentAddEarningBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddEarningBinding.inflate(layoutInflater)
        binding.btnAdd.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_addEarning_to_earningsFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}