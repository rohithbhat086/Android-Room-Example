package com.rgb.example.android_room_demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rgb.example.android_room_demo.databinding.ItemSubscriberBinding
import com.rgb.example.android_room_demo.db.Subscriber

class SubscriberAdapter(private val clickListener : (Subscriber)->Unit) : RecyclerView.Adapter<MyViewHolder>() {

    private var data = ArrayList<Subscriber>()

    fun setData(dataSet : List<Subscriber>){
        data.clear()
        data.addAll(dataSet)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding : ItemSubscriberBinding = DataBindingUtil.inflate(inflator, R.layout.item_subscriber, parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position], clickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class MyViewHolder(private val mBinding : ItemSubscriberBinding) : RecyclerView.ViewHolder(mBinding.root){

    fun bind(subscriber: Subscriber, clickListener : (Subscriber)->Unit){
        mBinding.itemName.text = subscriber.name
        mBinding.itemEmail.text = subscriber.email

        mBinding.root.setOnClickListener {
            clickListener(subscriber)
        }
    }

}