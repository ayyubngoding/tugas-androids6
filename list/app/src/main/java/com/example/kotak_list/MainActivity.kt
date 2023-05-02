package com.example.kotak_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val lv = findViewById<ListView>(R.id.list)
        val is_list =
            arrayOf("Sumenep", "Manding", "Rubaru", "Batuh Putih", "Gapura", "Kota Sumenep")

        lv.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, is_list)
        registerForContextMenu(lv)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_edit -> {
                Toast.makeText(this, "Anda Memilih Menu Edit", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_hapus ->{
                Toast.makeText(this, "Anda Memilih Menu Edit", Toast.LENGTH_SHORT).show()
            return true
        }
    }
        return super.onContextItemSelected(item)
}
}
