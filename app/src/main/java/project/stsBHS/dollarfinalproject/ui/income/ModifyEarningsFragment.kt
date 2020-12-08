package project.stsBHS.dollarfinalproject.ui.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.databinding.ModifyEarningsFragmentBinding

class ModifyEarningsFragment : Fragment() {

    private lateinit var binding: ModifyEarningsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ModifyEarningsFragmentBinding.inflate(layoutInflater)

        binding.btnModifyEarning.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_modifyEarningsFragment_to_earningsFragment)
        }

        binding.btnDeleteEarning.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_modifyEarningsFragment_to_earningsFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}