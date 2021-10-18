package com.e.kotlin_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.e.Model.News
import com.e.RecyclerAdapter.MyAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<News>
    private lateinit var imageArr:Array<Int>
    private lateinit var titleArr:Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageArr= arrayOf(
            R.drawable.news_one,
            R.drawable.news_two,
            R.drawable.news_three,
            R.drawable.news_four,
            R.drawable.news_five,
            R.drawable.news_six,
            R.drawable.news_seven,
            R.drawable.news_eight,
            R.drawable.news_nine,
            R.drawable.news_ten

        )

        titleArr= arrayOf(
            "UP Police warn of action against those who will participate in 'Rail Roko' stir",

            "India records 13,596 new Covid-19 cases; lowest single-day tally in 230 days",

            "Alert in Assam over threats of attacks by Pakistan’s ISI, al Qaeda",

            "BJP lawmaker draws flak for ‘Father and chader’ comments",

            "Attacks on Durga Puja pandals pre-planned': Bangladesh home minister",

            "Tata Punch SUV to launch today: Live and latest updates",

            "Kohli explains why Ashwin was selected over wrist spinners for T20 World Cup",

            "Neena Gupta says she didn’t tell her mom about being molested as a kid",

            "China growth slides to 4.9% in third quarter",

            "Three Panchkula youths killed as car hits parked truck in Rajpura"
        )

        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        arrayList= arrayListOf<News>()
        getArrayData()

    }

    private fun getArrayData() {

        for(i in imageArr.indices){
            var news=News(imageArr[i],titleArr[i])
            arrayList.add(news)
        }

        var adapter=MyAdapter(arrayList)
        recyclerView.adapter=adapter
        adapter.setOnItemClickListener(object:MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {



                val image=imageArr[position]
                val titleNews=titleArr[position]

                val i= Intent(this@MainActivity,ItemClicked::class.java)
                i.putExtra("IMAGE",image)
                i.putExtra("HEADLINE",titleNews)

                startActivity(i)
            }

        })
    }
}