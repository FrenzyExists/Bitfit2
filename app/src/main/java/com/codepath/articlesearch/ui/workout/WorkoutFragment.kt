package com.codepath.articlesearch.ui.workout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.codepath.articlesearch.AddWorkoutActivity
import com.codepath.articlesearch.R


class WorkoutFragment : Fragment(), WorkoutAdapter.WorkoutClickListener {

    lateinit var viewModel: WorkoutViewModel
    lateinit var adapter: WorkoutAdapter

    private val updateOrDeleteTodo =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val work = result.data?.getSerializableExtra("workout") as WorkoutEntity
                val isDelete = result.data?.getBooleanExtra("delete_workout", false) as Boolean
                if (!isDelete) {
                    viewModel.updateWorkout(work)
                } else if(isDelete){
                    viewModel.deleteWorkout(work)
                }
            }
        }
//
    override fun onItemClicked(workout: WorkoutEntity) {
        val intent = Intent(this.context, AddWorkoutActivity::class.java)
        intent.putExtra("current_workout", workout)
//        val intent = Intent(this, AddWorkoutActivity::class.java)
//        intent.putExtra("current_journal", workout)
        Log.v("DDD", "DSFDS")
        updateOrDeleteTodo.launch(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WorkoutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WorkoutFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }

    }

}