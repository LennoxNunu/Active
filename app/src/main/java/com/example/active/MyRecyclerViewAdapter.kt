package com.example.active

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.active.databinding.ListItemBinding
import com.example.active.db.Subscriber

class MyRecyclerViewAdapter(private  val subscribersList: List<Subscriber>):RecyclerView.Adapter<MyViewHolder>()  {
    private  lateinit var binding: ListItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return MyViewHolder(binding)

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return subscribersList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val subscriber = subscribersList[position]
        holder.bind(subscriber)
    }

}

class MyViewHolder(val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(subscriber: Subscriber){
         binding.nameTextView.text = subscriber.name
         binding.emailTextView.text = subscriber.email
    }
}