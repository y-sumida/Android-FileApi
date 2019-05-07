package com.example.fileapi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_file_row.view.*
import java.io.File

class FilesAdapter(context: Context,
                   private val files: List<File>,
                   private val onClick: (File) -> Unit) : RecyclerView.Adapter<FilesAdapter.FileViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FilesAdapter.FileViewHolder {
        val view = inflater.inflate(R.layout.list_file_row, p0, false)
        val viewHolder = FileViewHolder(view)

        view.setOnClickListener {
            onClick(files[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount() = files.size

    override fun onBindViewHolder(p0: FileViewHolder, p1: Int) {
        p0.fileName.text = files[p1].name
    }

    class FileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fileName = view.fileName
    }
}