package com.example.projectuts.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuts.*


class HomeFragment : Fragment() {


    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: PixelAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var pixelArrayList: ArrayList<Pixel>

    lateinit var image: Array<Int>
    lateinit var name: Array<String>
    lateinit var description: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_pixel)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = PixelAdapter(pixelArrayList){
            val intent = Intent(context,DetailPixelActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }

    private fun dataInitialize(){
        pixelArrayList = arrayListOf<Pixel>()

        image = arrayOf(
            R.drawable.spartan,
            R.drawable.samurai,
            R.drawable.grimreaper,
            R.drawable.cowboy,
            R.drawable.king,
            R.drawable.viking,
            R.drawable.ninja,
            R.drawable.pirates2,
            R.drawable.reaper,
            R.drawable.knight,

            )
        name = arrayOf(
            "Spartan",
            "Samurai",
            "Grim Reaper",
            "Cowboy",
            "King",
            "Viking",
            "Ninja",
            "Pirates",
            "Wizard",
            "Knight",

            )

        description = arrayOf(
            "Logo Mascot Esport",
            "Logo Mascot Esport",
            "Logo Mascot Esport",
            "Logo Mascot Esport",
            "Logo Mascot Esport",
            "Logo Mascot Esport",
            "Logo Mascot Esport",
            "Logo Mascot Esport",
            "Logo Mascot Esport",
            "Logo Mascot Esport",

            )
        for (i in image.indices){

            val pixel = Pixel(image[i],name[i], description[i])
            pixelArrayList.add(pixel)
        }


    }
}