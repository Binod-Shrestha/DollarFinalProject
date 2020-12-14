package project.stsBHS.dollarfinalproject.ui.income

import project.stsBHS.dollarfinalproject.ListItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.earnings_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onCheckedChange
import project.stsBHS.dollarfinalproject.R
import project.stsBHS.dollarfinalproject.Session

class MyRecyclerView(private val sampleList: List<ListItem>): RecyclerView.Adapter<MyRecyclerView.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val date: TextView = itemView.textView_date
        val description: TextView = itemView.textView_description
        val amount: TextView =itemView.textView_amount
        var id: TextView = itemView.txt_id
        var radio: RadioButton = itemView.rdoModify
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.earnings_item,
                parent, false
        )

        var card = MyViewHolder(itemView)
        var session: Session = Session(itemView.context)
        session.setSelectedId("0")

        itemView.rdoModify.onCheckedChange { buttonView, isChecked ->
            session.setSelectedId(card.id.text.toString())
        }
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = sampleList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = sampleList[position]

        holder.description.text= currentItem.description
        holder.date.text=currentItem.date
        holder.amount.text = currentItem.amount.toString()
        holder.id.text = currentItem.id.toString()
        holder.radio.isChecked = currentItem.checked
    }
}