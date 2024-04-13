package com.codepath.articlesearch.ui.workout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.codepath.articlesearch.R

class WorkoutAdapter(private val context: Context, val listener: WorkoutClickListener):
    RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>(){

    private val workoutList = ArrayList<WorkoutEntity>()
    inner class WorkoutViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val todo_layout = itemView.findViewById<CardView>(R.id.card_layout)
        val title = itemView.findViewById<TextView>(R.id.textExercise)
        val reps = itemView.findViewById<TextView>(R.id.textReps)
        val date = itemView.findViewById<TextView>(R.id.textDate)
    }

    interface WorkoutClickListener {
        fun onItemClicked(workout: WorkoutEntity)
    }

    override fun onBindViewHolder(holder: WorkoutAdapter.WorkoutViewHolder, position: Int) {
        val item = workoutList[position]
        holder.title.text = item.exTitle
        holder.title.isSelected = true
        holder.reps.text = item.reps
        holder.date.text = item.date
        holder.date.isSelected = true
        holder.todo_layout.setOnClickListener {
            listener.onItemClicked(workoutList[holder.adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutAdapter.WorkoutViewHolder {
        return WorkoutViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_workout, parent, false)
        );
    }

    override fun getItemCount(): Int {
        return workoutList.size
    }

}