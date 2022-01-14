package com.surya.suryaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.surya.suryaproject.adapter.gridadapter
import com.surya.suryaproject.model.griditem

class Home : AppCompatActivity(),AdapterView.OnItemClickListener {

    lateinit var auth: FirebaseAuth
    lateinit var  toggle: ActionBarDrawerToggle
    private var arrayList:ArrayList<griditem> ?= null
    private var gridView: GridView?= null
    private var adapterview: gridadapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val drawerLayout:DrawerLayout= findViewById(R.id.drawerLayout)
        toggle=ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fun logoutpage(){
            auth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        val navview:NavigationView=findViewById(R.id.nav_View)
        navview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.about -> Toast.makeText(applicationContext,"About",Toast.LENGTH_SHORT).show()
                R.id.logout -> logoutpage()
            }
            true
        }
        // firebase check
        auth= FirebaseAuth.getInstance()
        val currentUser=auth.currentUser

//        Reference


        if(currentUser==null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


        // image Slider
        val imageSlider:ImageSlider= findViewById(R.id.ImageSlider)
        val imagelist=ArrayList<SlideModel>()
        imagelist.add(SlideModel("https://i.pinimg.com/564x/7d/1f/bf/7d1fbfb5b54c156a2dccd2b57a3ae7c1.jpg") )
        imagelist.add(SlideModel("https://i.pinimg.com/564x/5e/cd/0e/5ecd0e6694b00abaab676c3643952b9c.jpg"))
        imagelist.add(SlideModel("https://i.pinimg.com/564x/87/fc/3a/87fc3a4a66397a075b5f5158e7bf304d.jpg"))
        imagelist.add(SlideModel("https://i.pinimg.com/736x/aa/0d/15/aa0d150da729b48721cdfeb71c95d3cc.jpg"))
        imageSlider.setImageList(imagelist, ScaleTypes.FIT)

        //grid view
        gridView= findViewById( R.id.gridview)
        arrayList= ArrayList()
        arrayList=setdata()
        adapterview= gridadapter(applicationContext,arrayList!!)
        gridView ?.adapter= adapterview
        gridView ?.onItemClickListener=this


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
            return super.onOptionsItemSelected(item)
    }
    private  fun setdata():ArrayList<griditem>{
        var arrayList:ArrayList<griditem> = ArrayList()
        arrayList.add(griditem(R.drawable.travel,"Travel"))
        arrayList.add(griditem(R.drawable.package_img,"Package"))
        arrayList.add(griditem(R.drawable.hotel_img3,"Hotel"))
        arrayList.add(griditem(R.drawable.trasportation,"Transport"))
        arrayList.add(griditem(R.drawable.locationicon,"Location"))
        arrayList.add(griditem(R.drawable.weather,"Weather"))
        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item:griditem=arrayList!!.get(position)
      //  Toast.makeText(applicationContext,item.name,Toast.LENGTH_SHORT).show()
        val choice:Int=position
        val intent=Intent(applicationContext,Travel::class.java)
        val intent1=Intent(applicationContext,Package::class.java)
        val intent2=Intent(applicationContext,Hotel::class.java)
        val intent3=Intent(applicationContext,Transport::class.java)
        val intent4=Intent(applicationContext,Direction::class.java)
        val intent5=Intent(applicationContext,Weather::class.java)


        when(choice){
            // connect the pages
            0-> startActivity(intent)
            1->startActivity(intent1)
            2->startActivity(intent2)
            3->startActivity(intent3)
            4->startActivity(intent4)
            5->startActivity(intent5)
        }
    }


}