package com.diest.simplenotes.view.listofnodes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.diest.simplenotes.R
import com.diest.simplenotes.model.note.entity.NoteModel

class ListOfNodesAdapter(var listener: NoteClickListener): RecyclerView.Adapter<ListOfNodesAdapter.NotesViewHolder>(){

    private var data: List<NoteModel> = ArrayList<NoteModel>()

    fun setNodes(list: List<NoteModel>){
        data = list
        notifyDataSetChanged()
    }

    class NotesViewHolder(view: View): RecyclerView.ViewHolder(view){

        val titleTextView: TextView = view.findViewById<TextView>(R.id.tv_note_title)
        val textTextView: TextView = view.findViewById<TextView>(R.id.tv_note_text)
        val editImage: ImageView = view.findViewById<ImageView>(R.id.iv_edit)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.nodes_list_item, parent, false)
        return NotesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.titleTextView.text = data[position].title
        holder.textTextView.text = data[position].text
        holder.editImage.setOnClickListener {
            listener.onClickEdit(data[position])
        }
        holder.itemView.setOnClickListener{
            listener.onClick(data[position])
        }
        holder.itemView.isLongClickable = true

        holder.itemView.setOnLongClickListener {
            listener.onLongClick(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}