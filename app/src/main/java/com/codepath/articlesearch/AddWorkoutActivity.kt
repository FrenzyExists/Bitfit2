package com.codepath.articlesearch

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.codepath.articlesearch.databinding.ActivityAddWorkoutBinding
import com.codepath.articlesearch.ui.workout.WorkoutEntity
import com.codepath.articlesearch.ui.workout.WorkoutFragment
import java.text.SimpleDateFormat
import java.util.Date

class AddWorkoutActivity : Fragment() {

    private lateinit var binding: ActivityAddWorkoutBinding
    private lateinit var workout: WorkoutEntity
    private lateinit var oldWorkout: WorkoutEntity
    var isUpdate = false

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
            AddWorkoutActivity().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddWorkoutBinding.inflate(layoutInflater)
//        setContentView(binding.root)

//        try {
//            oldWorkout = intent.getSerializableExtra("current_workout") as WorkoutEntity
//            binding.etTitle.setText(oldWorkout.exTitle)
//            binding.etNote.setText(oldWorkout.reps)
//            isUpdate = true
//        }catch (e: Exception){
//            e.printStackTrace()
//        }
//
//        binding.imgCheck.setOnClickListener {
//            val title = binding.etTitle.text.toString()
//            val journalDescription = binding.etNote.text.toString()
//
//            if(title.isNotEmpty() && journalDescription.isNotEmpty()){
//                val formatter = SimpleDateFormat("EEE, d MMM yyyy HH:mm a")
//
//                if(isUpdate){
//                    workout = WorkoutEntity(workout.id, title, journalDescription, formatter.format(
//                        Date()
//                    ))
//                }else{
//                    workout = WorkoutEntity(0, title, journalDescription, formatter.format(Date()))
//                }
//                var intent = Intent()
//                intent.putExtra("workout", workout)
//                setResult(Activity.RESULT_OK, intent)
//                finish()
//            }else{
//                Toast.makeText(this@AddWorkoutActivity, "please enter some data", Toast.LENGTH_LONG).show()
//                return@setOnClickListener
//            }
//        }
//
//        binding.imgDelete.setOnClickListener {
//            var intent = Intent()
//            intent.putExtra("workout", oldWorkout)
//            intent.putExtra("delete_workout", true)
//            setResult(Activity.RESULT_OK, intent)
//            finish()
//        }
//
//        binding.imgBackArrow.setOnClickListener {
//            onBackPressed()
//        }



    }
}