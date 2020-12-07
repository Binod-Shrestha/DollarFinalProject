package org.sheridancollege.expensetracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.expense_item.view.*
import project.stsBHS.dollarfinalproject.R


class MyRecyclerView (private val sampleList: List <ListItem>): RecyclerView.Adapter <MyRecyclerView.MyViewHolder>() {

    class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

        val date: TextView = itemView.textView_date
        val description: TextView = itemView.textView_description
        val amount: TextView =itemView.textView_amount
        val modify : Button = itemView.btn_modify
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.earnings_item,
            parent, false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount() = sampleList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = sampleList [position]

        holder.description.text= currentItem.description
        holder.date.text=currentItem.date
        holder.amount.text = currentItem.amount.toString()
        holder.modify.text = "Modify"
    }
}