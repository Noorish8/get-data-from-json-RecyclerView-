package com.example.jesonvolley3

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

        lateinit var recyclerView:RecyclerView
        lateinit var adapterrecy: Adapterrecy
        val i:Int=0
        var list:ArrayList<DataModel> = ArrayList<DataModel>()
        val url:String="https://simplifiedcoding.net/demos/view-flipper/heroes.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recy)
//        adapterrecy=Adapterrecy(list)

//Show progress dialog
        val progressDialog = ProgressDialog(this@MainActivity)
      progressDialog.setTitle("kotlin Progress bar")
        progressDialog.setMessage("Application is loading,please wait")
        progressDialog.show()

        val request: StringRequest = StringRequest(Request.Method.GET,url,Response.Listener {
                response ->
            progressDialog.hide()

            Log.e("response>>>>>>",response)
            val jsonObject: JSONObject = JSONObject(response)
            val heroesArray= jsonObject.getJSONArray("heroes")
            for (i in 0 until heroesArray.length()) {
                val jsonObject = heroesArray.getJSONObject(i)
                val name :String=jsonObject.getString("name")
                val imageUrl :String=jsonObject.getString("imageurl")
                val dataModel= DataModel()
                dataModel.name = name
                dataModel.image = imageUrl
                list.add(dataModel)
            }

            adapterrecy=Adapterrecy(this,list)
             val layoutManager = LinearLayoutManager(this)
             recyclerView.layoutManager=layoutManager
             recyclerView.adapter=adapterrecy







        }, Response.ErrorListener {

        })
        val requestQueue= Volley.newRequestQueue(this)
        requestQueue.add(request)
    }
}