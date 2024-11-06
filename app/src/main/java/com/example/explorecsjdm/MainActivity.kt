package com.example.explorecsjdm

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val categoryRecyclerView: RecyclerView = findViewById(R.id.rvCategory)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val categoryAdapter = CategoryAdapter(getCategoryData())
        categoryRecyclerView.adapter = categoryAdapter

        val destinationRecyclerView: RecyclerView = findViewById(R.id.rvDestination)
        destinationRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val destinationAdapter = PopularDestinationAdapter(getPopularDestinationData()) { destination ->
            val intent = Intent(this, DestinationDetailActivity::class.java).apply {
                putExtra("DEST_NAME", destination.name)
                putExtra("DEST_DESC", destination.description)
                putExtra("DEST_LOC", destination.location)
                putExtra("DEST_IMAGE", destination.img)
            }
            startActivity(intent)
        }
        destinationRecyclerView.adapter = destinationAdapter
    }

    private fun getCategoryData(): List<Category> {
        return listOf(
            Category(R.drawable.ic_pilgrimage, "Pilgrimage"),
            Category(R.drawable.ic_nature, "Nature Trips"),
            Category(R.drawable.ic_resort, "Resorts"),
            Category(R.drawable.ic_shopping_center, "Shopping Centers"),
            Category(R.drawable.ic_food_park, "Food Parks")
        )
    }

    private fun getPopularDestinationData(): List<Destination> {
        return listOf(
            Destination(R.drawable.img_grotto_resort, "Grotto Vista Resort",
                "Grotto Vista Resort is one of the premier resorts not only in the city but in the province of Bulacan. They are 27 years in the business industry. It is owned by a businessman, philanthropist and a former politician in the City of San Jose del Monte. According to him, his purpose in life is to help and be a channel of service to others by putting up businesses and foundation.\n\nThe resort’s name was derived from the famous Pilgrim Church, Our Lady of Lourdes Grotto Shrine which is only walking distance from the resort.\n\nOne of their main attraction is the Galleon Ship Pool. It is a 1,600 sq.m. pool with a ship at the middle that serves as the resort’s trade mark. Also, they offer international cuisine and exotic food at their Cafe 101.\n\nFurthermore, they offer accommodation, hotel & apertelle, bowling alley, catering services, and events management.",
                "Brgy. Graceville, CSJDM, Bulacan"),
            Destination(R.drawable.img_grotto_shrine, "Our Lady of Lourdes Grotto Shrine",
                "The Our Lady of Lourdes Grotto Shrine located at Graceville, San Jose del Monte is the infamous replica of Rosary Basilica of Lourdes, France. This one of the most visited shrines during Lenten season despite being a private property.\n\nBuilt by the Guanzon family and inaugurated on February 11, 1965, it has been a symbol of their thanksgiving to the miraculous healing from cancer of Anita Guidote-Guanzon the wife of Horacio Guanzon after their pilgrimage in Lourdes, France in 1961. \n\nThe Shrine features the Calvary Hill with life-size statues presenting the 14 Stations of the Cross, and the Rosary Hill with 155 huge concrete beads. But the best of all, is the small spring-hosed water flowing beneath the statue of Our Lady of Lourdes which has been claimed to be miraculous.",
                "Brgy. Graceville, CSJDM, Bulacan"),
            Destination(R.drawable.img_mt_balagbag, "Mt. Balagbag",
                "Mount Balagbag derived its name from the tagalog word pabalagbag which means “in horizontal position”. Since it is located at Barangay San Isidro which is also situated in between Bulacan and Rizal, Mount Balagbag has been known by the common trail at Rizal.\n\nNow, the City of San Jose del Monte offers a new exciting experience by hiking the newly discovered trail—the Dumagat Trail. The City Tourism has trained the Dumagat Tribe as tour guides to guide new hikers and tourists who may need company to their very own Dumagat Trail that has been the pathway for their trading.\n\nWith the difficulty of 4 out of 9, the Dumagat Trail gives a nature experience of the Dumagats natural habitat in the City of San Jose del Monte. Adventure lovers will have spontaneous nature experience in 3-4 hours trekking.",
                "Brgy. San Isidro, CSJDM, Bulacan"),
            Destination(R.drawable.img_kaytitinga, "Kaytitinga Falls",
                "Along the Dumagat Trail located at Barangay San Isidro, one of the Trio Falls is the Kaytitinga Falls which has been the main source of water of the Dumagat Tribe. Its name came from the word tingga or lead due to its presence in the said falls.\n\nEstimated around 50-feet, the three-tiered falls is situated in a vast natural forest which has been preserved as a natural habitat of the Dumagats. It is rich with biodiversity and fully adorned with a wide variety of flora and fauna. Tourists may enjoy the cold water falls as the beauty of nature mesmerizes their eyes. Currently, some Dumagats still live in the place preserving their culture and acting as its protectors.\n\nDue to the Dumagat Trail being naturally preserved, tourists can visit and enjoy the nature trip going to the Kaytitinga Falls in a 40-minute walk.",
                "Brgy. San Isidro, CSJDM, Bulacan")
        )
    }
}
