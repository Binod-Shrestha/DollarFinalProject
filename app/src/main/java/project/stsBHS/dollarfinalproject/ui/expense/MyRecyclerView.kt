package project.stsBHS.dollarfinalproject.ui.expense

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.earnings_item.view.*
import kotlinx.android.synthetic.main.expense_item.view.*
import kotlinx.android.synthetic.main.expense_item.view.textView_amount
import kotlinx.android.synthetic.main.expense_item.view.textView_date
import kotlinx.android.synthetic.main.expense_item.view.textView_description
import project.stsBHS.dollarfinalproject.R

class MyRecyclerView(private val sampleList: List<ListItem>): RecyclerView.Adapter<MyRecyclerView.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val date: TextView = itemView.textView_date
        val description: TextView = itemView.textView_description
        val amount: TextView =itemView.textView_amount
        var id: Int = itemView.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.expense_item,
                parent, false)
        itemView.setOnClickListener{ v: View ->

        }
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = sampleList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = sampleList[position]

        holder.description.text= currentItem.description
        holder.date.text=currentItem.date
        holder.amount.text = currentItem.amount.toString()
        holder.id = currentItem.id.toInt()
    }
}