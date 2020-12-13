package project.stsBHS.dollarfinalproject.ui.summary

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.databinding.FragmentSummaryBinding


class SummaryFragment : Fragment() {

    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentSummaryBinding.inflate(
            inflater, container, false)

        binding.btnCancel.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_summaryFragment_to_nav_home)
        }
        return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var datePick = binding.datePicker
        var day = datePick.dayOfMonth
        var month = datePick.month
        var year = datePick.year
        datePick.init(
            year,
            month,
            day,
            DatePicker.OnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            var year = year
                var day = dayOfMonth
                var month = monthOfYear
                binding.labelAnalysis.text = "Date Changed : $year/$month/$day"
            }
        )
    }

}


