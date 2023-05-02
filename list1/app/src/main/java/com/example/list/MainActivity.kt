package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lv = findViewById<ListView>(R.id.list)
        val is_list =
            arrayOf("Sumenep", "Manding", "Rubaru", "Batuh Putih", "Gapura", "Kota Sumenep")

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, is_list)
        lv.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)

        val searchitem = menu?.findItem(R.id.search)
        val searchview = searchitem?.actionView as SearchView
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_profil -> {
                Toast.makeText(this, "Anda Memilih Menu Profil", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_help -> {
                Toast.makeText(this, "Anda Memilih Menu Help", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_keluar -> {
                Toast.makeText(this, "Anda Memilih Menu keluar", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

