package com.app.bansikajal_mapd711_project.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.app.bansikajal_mapd711_project.R
import com.app.bansikajal_mapd711_project.adapter.CategoryAdapter
import com.app.bansikajal_mapd711_project.common.appSharedPref
import com.app.bansikajal_mapd711_project.common.customerID
import com.app.bansikajal_mapd711_project.common.customerName
import com.app.bansikajal_mapd711_project.common.isLogin
import com.app.bansikajal_mapd711_project.common.kAccessories
import com.app.bansikajal_mapd711_project.common.kGadgets
import com.app.bansikajal_mapd711_project.common.kHomeAndKitchen
import com.app.bansikajal_mapd711_project.common.kJewellery
import com.app.bansikajal_mapd711_project.common.kKids
import com.app.bansikajal_mapd711_project.common.kMen
import com.app.bansikajal_mapd711_project.common.kSelfCare
import com.app.bansikajal_mapd711_project.common.kWomen
import com.app.bansikajal_mapd711_project.common.userName
import com.app.bansikajal_mapd711_project.databinding.ActivityMainProductBinding
import com.app.bansikajal_mapd711_project.databinding.NavHeaderBinding
import com.app.bansikajal_mapd711_project.db.DatabaseManager
import com.app.bansikajal_mapd711_project.model.Category

class MainProductActivity : AppCompatActivity(), CategoryAdapter.CategoryClickListener {
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryList: java.util.ArrayList<Category>
    private lateinit var binding: ActivityMainProductBinding
    private lateinit var actionBarToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.rvCategory.layoutManager = GridLayoutManager(this@MainProductActivity, 3)
        categoryList = getCategoryList()
        categoryAdapter = CategoryAdapter(this@MainProductActivity, categoryList, this)
        binding.rvCategory.adapter = categoryAdapter

        setUpDrawer()
    }

    private fun setUpDrawer(){
        // Pass the ActionBarToggle action into the drawerListener
        actionBarToggle = ActionBarDrawerToggle(this, binding.drawerLayout,binding.toolbar, 0, 0)
        // Set the custom toggle icon

        //supportActionBar.setDisplayHomeAsUpEnabled(true)
        //supportActionBar.setDefaultDisplayHomeAsUpEnabled(false)
        actionBarToggle.isDrawerIndicatorEnabled = false
        actionBarToggle.setHomeAsUpIndicator(R.drawable.drawer_menu)

        binding.drawerLayout.addDrawerListener(actionBarToggle)

        // Display the hamburger icon to launch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Call syncState() on the action bar so it'll automatically change to the back button when the drawer layout is open
        actionBarToggle.syncState()

        // Access the header view
        val prefs = applicationContext.getSharedPreferences(appSharedPref, Context.MODE_PRIVATE)
        val headerView = binding.navView.getHeaderView(0)
        val headerTextView: TextView = headerView.findViewById(R.id.customerNameTextView)
        headerTextView.text = "Hello, " + prefs.getString(customerName, "")

        actionBarToggle.setToolbarNavigationClickListener {
            // Handle the toolbar navigation click
            if (binding.drawerLayout.isDrawerVisible(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        // Call setNavigationItemSelectedListener on the NavigationView to detect when items are clicked
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfile -> {
                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.orders -> {
                    Toast.makeText(this, "orders", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.logout -> {
                    logout()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun getCategoryList(): ArrayList<Category> {
        var list = ArrayList<Category>()
        list.add(Category(R.drawable.c_men, kMen))
        list.add(Category(R.drawable.c_women, kWomen))
        list.add(Category(R.drawable.c_per_care, kSelfCare))
        list.add(Category(R.drawable.c_accessories, kAccessories))
        list.add(Category(R.drawable.c_kids, kKids))
        list.add(Category(R.drawable.c_jewellery, kJewellery))
        list.add(Category(R.drawable.c_home_kitchen, kHomeAndKitchen))
        list.add(Category(R.drawable.c_gadgets, kGadgets))
        return list
    }

    override fun onItemClick(category: Category, pos: Int) {
        startActivity(Intent(this, ProductsActivity::class.java)
            .putExtra("title", category.c_name)
            .putExtra("pos", pos))
    }

    private fun logout(){
        // clear user and customer login related data from preference
        val prefs = applicationContext.getSharedPreferences(appSharedPref, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.remove(isLogin)
        editor.remove(userName)
        editor.remove(customerName)
        editor.remove(customerID)
        editor.apply()

        DatabaseManager.getInstance().signOut()

        // navigate to login screen after logout
        jumpToLogin()
    }

    private fun jumpToLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}