package com.example.notes

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private var notes:List<Note>, context:Context):
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val titleTextView:TextView = itemView.findViewById(R.id.titleTextView)
        val contentTextView:TextView = itemView.findViewById(R.id.contentTextView)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.NoteViewHolder {
     val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesAdapter.NoteViewHolder, position: Int) {
       val note = notes[position]
        holder.titleTextView.text = note.title
        holder.contentTextView.text = note.content
    }

    override fun getItemCount(): Int = notes.size
    fun refreshData(newNotes: List<Note>) {
        notes =newNotes
        notifyDataSetChanged()

    }
}