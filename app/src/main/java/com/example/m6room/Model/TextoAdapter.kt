package com.example.m6room.Model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.m6room.Model.Database.TextoEntity
import com.example.m6room.databinding.ItemtextoBinding

class TextoAdapter : RecyclerView.Adapter<TextoAdapter.TaskVH>(){


    private var  listTextoEntity = listOf<TextoEntity>()

    private  val selectedTextoEntity = MutableLiveData<TextoEntity>()

    fun selectedItem(): LiveData<TextoEntity> = selectedTextoEntity

    fun update(listTextoEntity: List<TextoEntity>){
        this.listTextoEntity = listTextoEntity
        notifyDataSetChanged()
    }
    inner class TaskVH(private  val binding :ItemtextoBinding) :
        RecyclerView.ViewHolder(binding.root),

        View.OnClickListener{

        fun bind (textoEntity: TextoEntity){

            binding.tvTitle.text= textoEntity.texto


            // activar el elemto clik dentro de la vista
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            selectedTextoEntity.value= listTextoEntity[adapterPosition]
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVH {
        return  TaskVH( ItemtextoBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = listTextoEntity.size

    override fun onBindViewHolder(holder: TaskVH, position: Int) {
        val TextoEntity = listTextoEntity[position]
        holder.bind(TextoEntity)
    }
}