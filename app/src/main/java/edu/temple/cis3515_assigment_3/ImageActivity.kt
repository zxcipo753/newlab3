package edu.temple.cis3515_assigment_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dogdata: Array<ImageObject> = getData()
        val recycle = findViewById<RecyclerView>(R.id.rcvView) as RecyclerView
        var text = findViewById<TextView>(R.id.dog)
        var image = findViewById<ImageView>(R.id.mainImageView)
        var adapter =ImageAdapter(dogdata)
        recycle.adapter = adapter
        adapter.setOnItemClickListener(object : ImageAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                image.setImageResource(dogdata[position].resourceId)
                text.text = dogdata[position].description
                text.textSize = 22F
            }
        })
        recycle.layoutManager = GridLayoutManager(this,3)

    }

    private fun getData(): Array<ImageObject> {
        return arrayOf(ImageObject("chihuahua", R.drawable.chihuahua),
            ImageObject("dashshund",R.drawable.dashshund),
            ImageObject("doberman", R.drawable.doberman),
            ImageObject("goldenretriever",R.drawable.goldenretriever),
            ImageObject("bulldog",R.drawable.bulldog),
            ImageObject("pomeranian",R.drawable.pomeranian),
            ImageObject("havanese",R.drawable.havanese),
            ImageObject("corgi",R.drawable.corgi),
            ImageObject("bernesemountain",R.drawable.bernesemountain),
            ImageObject("bodercollie",R.drawable.bodercollie))

    }

}