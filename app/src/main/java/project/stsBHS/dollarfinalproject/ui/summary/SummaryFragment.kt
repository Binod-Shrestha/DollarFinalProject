package project.stsBHS.dollarfinalproject.ui.summary

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.databinding.FragmentSummaryBinding


class SummaryFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val binding = FragmentSummaryBinding.inflate(
                inflater, container, false)
        binding.btnCancel.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_summaryFragment_to_nav_home)
            var datePick = binding.datePicker
                var day = datePick.dayOfMonth
            var month = datePick.month
            var year = datePick.year
           // var msg = "Day: " + day + "-Month:" + month + "-Year:" + year
            //binding.labelExpenditure.text = msg
         //   binding.labelExpenditure.setText("msg")
          //  Toast.makeText(context,msg,Toast.LENGTH_LONG)
          //  print("msg" + msg)


            


        }
        return binding.root

        }




}


