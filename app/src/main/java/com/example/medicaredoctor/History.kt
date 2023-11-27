package com.example.medicaredoctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medicaredoctor.Models.Appointment

class History : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
              setupActionBar()
            // Get the current logged in user details.
            FirestoreClass().getappointmenthistoryList(this@History)
        showProgressDialog("Please Wait")

        }
    private fun setupActionBar(){

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_history)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        if(actionbar !=null){
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionbar.title = "History"
        }
        toolbar.setNavigationOnClickListener{
            onBackPressed()
        }



    }
    fun populatesbookingHistoryListToUI(booking_List: ArrayList<Appointment>) {
        hideProgressDialog()
        Log.e("populateBoardsListToUI", "Doctor List: $booking_List")

        val rv_speciality_list = findViewById<RecyclerView>(R.id.historyrecyclerView)
        rv_speciality_list.layoutManager = LinearLayoutManager(this@History)

//        rv_speciality_list.setHasFixedSize(true)

        // Create an instance of DoctorListAdapter and pass the doctor_List to it.
        val adapter = BookingHistoryListAdapter(this@History, booking_List)
        rv_speciality_list.adapter = adapter // Attach the adapter to the recyclerView.

//        adapter.setOnClickListener(object : DoctorListAdapter.OnClickListener {
//            override fun onClick(position: Int, model: Doctor) {
//                val intent = Intent(this@Details_of_Doctors,DoctorDescriptionActivity::class.java)
//                val selectedModel = doctor_List[position] // Use a different variable name
//
//                intent.putExtra(Constants.DOCTOR_MODEL, selectedModel)
//                startActivity(intent)
//            }
//        })
    }
    }
