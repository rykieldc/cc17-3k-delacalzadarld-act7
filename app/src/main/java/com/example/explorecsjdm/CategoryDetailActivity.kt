package com.example.explorecsjdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_category_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton: Button = findViewById(R.id.back_button)
        val backTextView: TextView = findViewById(R.id.back_txt)

        backButton.setOnClickListener {
            finish()
        }

        backTextView.setOnClickListener {
            finish()
        }

        val categoryName = intent.getStringExtra("CATEGORY_NAME")
        val categoryNameTextView: TextView = findViewById(R.id.category_name)
        categoryNameTextView.text = categoryName

        val recyclerView: RecyclerView = findViewById(R.id.rvRecommendedPlaces)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val adapter = DestinationAdapter(getDestinationDataForCategory()) { destination ->
            val intent = Intent(this, DestinationDetailActivity::class.java)
            intent.putExtra("DEST_NAME", destination.name)
            intent.putExtra("DEST_DESC", destination.description)
            intent.putExtra("DEST_LOC", destination.location)
            intent.putExtra("DEST_IMAGE", destination.img)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }


    private fun getDestinationDataForCategory(): List<Destination> {
        val categoryName = intent.getStringExtra("CATEGORY_NAME")
        return when (categoryName) {
            "Pilgrimage" -> listOf(
                Destination(R.drawable.img_grotto_shrine, "Our Lady of Lourdes Grotto Shrine",
                    "The Our Lady of Lourdes Grotto Shrine located at Graceville, San Jose del Monte is the infamous replica of Rosary Basilica of Lourdes, France. This one of the most visited shrines during Lenten season despite being a private property.\n\nBuilt by the Guanzon family and inaugurated on February 11, 1965, it has been a symbol of their thanksgiving to the miraculous healing from cancer of Anita Guidote-Guanzon the wife of Horacio Guanzon after their pilgrimage in Lourdes, France in 1961. \n\nThe Shrine features the Calvary Hill with life-size statues presenting the 14 Stations of the Cross, and the Rosary Hill with 155 huge concrete beads. But the best of all, is the small spring-hosed water flowing beneath the statue of Our Lady of Lourdes which has been claimed to be miraculous.",
                    "Brgy. Graceville, CSJDM, Bulacan"),
                Destination(R.drawable.img_padre_pio, "Padre Pio Mountain of Healing",
                    "Padre Pio Mountain of Healing has been one of the most visited religious sites in the City of San Jose del Monte. Considering it being a privately-owned property, many devotees of Padre Pio all over the Philippines visit this place of healing to pray for their health and miracle healing.\n\nPadre Pio, also known as St. Pio of Pietrelcina, was the first stigmatized priest in the history of the church. He was known for the miracle of healing through his intercessions.\n\nLocated at Barangay Paradise III, this pious place features a 50-feet image of St. Pio, a Way of the Cross and a Chapel. Devotees and visitors can feel the sacredness of the place as it was built to be one of the highest places in the City. Padre Pio Mountain of Healing also offers Healing Mass every 23rd of the month at 9AM and Regular Mass every Sunday at 3PM.",
                    "Brgy. Paradise III, CSJDM, Bulacan"),
                Destination(
                    R.drawable.img_st_joseph,
                    "St. Joseph The Worker Parish",
                    "St. Joseph The Worker Parish is one of the oldest churches in the province of Bulacan. Built in 1751 and later reconstructed with stone between 1842 and 1854, it showcases elegant classic architecture typical of 19th-century churches.\n\nThis historical landmark has witnessed significant events, including the Spanish-Filipino War, the Japanese-Filipino War, and the Hukbalahap Rebellion, during which it was burned three times but remarkably survived.\n\nDespite renovations, the parish retains its antique ambiance and houses one of the oldest bells in the Philippines.",
                    "Brgy. Poblacion I, CSJDM, Bulacan"
                )
            )

            "Nature Trips" -> listOf(
                Destination(R.drawable.img_mt_balagbag, "Mt. Balagbag",
                    "Mount Balagbag derived its name from the tagalog word pabalagbag which means “in horizontal position”. Since it is located at Barangay San Isidro which is also situated in between Bulacan and Rizal, Mount Balagbag has been known by the common trail at Rizal.\n\nNow, the City of San Jose del Monte offers a new exciting experience by hiking the newly discovered trail—the Dumagat Trail. The City Tourism has trained the Dumagat Tribe as tour guides to guide new hikers and tourists who may need company to their very own Dumagat Trail that has been the pathway for their trading.\n\nWith the difficulty of 4 out of 9, the Dumagat Trail gives a nature experience of the Dumagats natural habitat in the City of San Jose del Monte. Adventure lovers will have spontaneous nature experience in 3-4 hours trekking.",
                    "Brgy. San Isidro, CSJDM, Bulacan"),
                Destination(R.drawable.img_tungtong, "Tungtong Falls",
                    "Tungtong Falls is one of the most visited falls and one of the closest eco-tourism spots in the City of San Jose del Monte. Visitors can bring their pets and swim to the lower part of the river to avoid drowning from the falls.",
                    "Brgy. Sto. Cristo, CSJDM, Bulacan"),
                Destination(R.drawable.img_kaytitinga, "Kaytitinga Falls",
                    "Along the Dumagat Trail located at Barangay San Isidro, one of the Trio Falls is the Kaytitinga Falls which has been the main source of water of the Dumagat Tribe. Its name came from the word tingga or lead due to its presence in the said falls.\n\nEstimated around 50-feet, the three-tiered falls is situated in a vast natural forest which has been preserved as a natural habitat of the Dumagats. It is rich with biodiversity and fully adorned with a wide variety of flora and fauna. Tourists may enjoy the cold water falls as the beauty of nature mesmerizes their eyes. Currently, some Dumagats still live in the place preserving their culture and acting as its protectors.\n\nDue to the Dumagat Trail being naturally preserved, tourists can visit and enjoy the nature trip going to the Kaytitinga Falls in a 40-minute walk.",
                    "Brgy. San Isidro, CSJDM, Bulacan"),
                Destination(R.drawable.img_burong, "Burong Falls",
                    "Burong Falls is one of the Trio Falls (Burong Falls, Kaytitinga Falls, Otso Otso Falls) found in the Ancestral Domain of the Dumagat Tribe in San Jose del Monte, Bulacan. It is estimated to be 10-15 feet high.\n\nDue to it being along the Dumagat Trail, tourists have to walk for 30 minutes or less while enjoying the preserved captivating natural view of the site. They can also go bathing and relax through the rushing waters of the falls while being captivated by nature’s beauty.\n\nBurong Falls is also considered to be a preserved eco-tourist spot. Thus, tourists should observe CLAY Go (Clean As You Go) to preserve the beauty of the natural falls.",
                    "Brgy. San Isidro, CSJDM, Bulacan"),
                Destination(R.drawable.img_otso_otso, "Otso-Otso Falls",
                    "Located at the Dumagat Trail, Otso-Otso Falls is the nearest among the Trio Falls. Because of the shape of its stream, its name was derived from the Spanish word ocho which means eight.\n\nIt is estimated around 10-15 feet high which is also surrounded by a vast amount of trees. Visitors will enjoy some deep waters in the falls as it splashes to its base.\n\nSince, Otso-Otso Falls is considered to be a preserved eco-tourist spot, tourists are expected to observe CLAY Go (Clean As You Go) to preserve its beauty.",
                    "Brgy. San Isidro, CSJDM, Bulacan")

            )

            "Resorts" -> listOf(
                Destination(R.drawable.img_grotto_resort, "Grotto Vista Resort",
                    "Grotto Vista Resort is one of the premier resorts not only in the city but in the province of Bulacan. They are 27 years in the business industry. It is owned by a businessman, philanthropist and a former politician in the City of San Jose del Monte. According to him, his purpose in life is to help and be a channel of service to others by putting up businesses and foundation.\n\nThe resort’s name was derived from the famous Pilgrim Church, Our Lady of Lourdes Grotto Shrine which is only walking distance from the resort.\n\nOne of their main attraction is the Galleon Ship Pool. It is a 1,600 sq.m. pool with a ship at the middle that serves as the resort’s trade mark. Also, they offer international cuisine and exotic food at their Cafe 101.\n\nFurthermore, they offer accommodation, hotel & apertelle, bowling alley, catering services, and events management.",
                    "Brgy. Graceville, CSJDM, Bulacan"),
                Destination(R.drawable.img_villa_leonora, "Villa Leonora",
                    "Villa Leonora Resort and Event Venue was established last 2017. It was named from the resort owner’s wife, “Leonora”. They are located at Lot 5, Igay Rd., Sto. Cristo, City San Jose del Monte City, Bulacan in front of ABS-CBN Soundstage.\n\nAccording to the owner, their establishment started from a five room apartment only. They decided to add a small event hall with pool to be rented out for small gatherings, like birthday, reunion or meetings. People loved the place due to its secluded area and an affordable rates of its amenities.\n\nAfter 2 years of operating, they added two more pools for public used. At the same time, “Fernando Hall and Leang Garden was built. It can accommodate for about 200-250 guests.",
                    "Brgy. Sto. Cristo, CSJDM, Bulacan"),
                Destination(R.drawable.img_casa_editha, "Casa Editha",
                    "The Casa Editha Event Center was established year 2019. They are located at L2D KM 33 Brgy. Sto. Cristo, Quirino Highway, City of San Jose del Monte, Bulacan.\n\nThe name of this event place was derived from the owner’s name, “Editha”. She grew up in a farm. Raising ducks, navigating the myriad of onion and rice paddies while balancing a basket of eggs. Even she lived in Manila for 50 years, she is still a farm girl at heart.\n\nAccording to her, Casa Editha was her sanctuary located in the city. A place of healing, reflection and retreat.\n\nThey started planting organic vegetables in 2012 and slowly expanded to planting local trees and seedlings. As time goes by, they built swimming pools, casitas and large cabanas for others to experience what she feels every time she is here.\n\nThey have overlooking view of sprawling mountains of Sierra Madre and surrounded by a lush organic garden that you may celebrate your special occasion amidst nature. They are accepting different occasion.",
                    "Brgy. Sto. Cristo, CSJDM, Bulacan"),
                Destination(R.drawable.img_pacific_waves, "Pacific Waves Resort",
                    "Pacific Waves Resort is located at Km. 31, Bayani Road, Brgy. Sto. Cristo, CSJDM, Bulacan.\n\nTheir land was purchased by the family in 1985. By the year 2010, their family decided to put up a resort as a rest house and family events venue but eventually, they open it to the public for business venture.\n\nThe name of the resort was came from the owners’ first letter names which is “Pacifico” and “Warlita”.\n\nUpon the entry of the resort, you will experience a warm heartfelt welcome situated with lush greenery environment of 1.6 hectares of land. You will be fascinated with their luscious display of nature as they preserve different fruit bearing trees which surrounds the entire resort. The relaxing sound of the bird’s chirping and the serenity of the place will surely make your stay enjoyable and memorable.\n\nThe resort offers accommodation that consists of 31 guest rooms. During the duration of their stay, they have a free access of the pool.\n\nAlso, they have restaurant and bar. Their chef use the fresh produce and quality local ingredients to create a unique menu for guests. One of their specialty is sisig.\n\nVenue rental, chapel, swimming pools and cottages, amusement center are also available.",
                    "Brgy. Sto. Cristo, CSJDM, Bulacan"),
                Destination(R.drawable.img_tierra_fontana, "Tierra Fontana 12 Waves Resort",
                    "Tierra Fontana 12 Waves Resort was established last 2010. This was operated by a Filipino-Chinese family who offer a quiet and tranquil environment for their guests. The area are famous for being sanctuary of sea turtle statue and dinosaur statue.\n\nThey offer different type of accommodation and event area. Holidays that are marketed as inclusive always include in their booking price such as accommodation, meals and beverages.\n\nThey are easily accessible with private and public transportation. They are located at 479 Paradise Drive, Brgy. Tungkong Mangga, CSJDM, Bulacan.",
                    "Brgy. Tungkong Mangga, CSJDM, Bulacan"),
            )

            "Shopping Centers" -> listOf(
                Destination(R.drawable.img_starmall, "Starmall San Jose Del Monte",
                    "Starmall San Jose Del Monte is the first Starmall built in Bulacan. Conveniently located along Quirino Highway, the world-class designed regional super center sets the standard for innovation and an evolved shopping experience. To house the increasing number of food outlets offering various specialties, the Al Fresco Garden was added, with an upper level walkway lined with an abundance of greenery that connects the main mall to Quirino Highway.",
                    "Brgy. Kaypian, CSJDM, Bulacan"),

                Destination(R.drawable.img_sm, "SM City San Jose Del Monte",
                    "SM City San Jose Del Monte is a shopping mall located in San Jose del Monte, Bulacan, Philippines. It is the first SM Supermall in the city and the 78th SM Supermall overall. The mall opened on April 28, 2023, and features a wide variety of shops, restaurants, and entertainment options. It is a popular destination for shoppers and families in the area.",
                    "Brgy. Tungkong Mangga, CSJDM, Bulacan"),

                Destination(R.drawable.img_uptown_center, "Muzon Uptown Center",
                    "Muzon Uptown Center is a community mall located in Muzon, San Jose del Monte City. It features a variety of shops, restaurants, and services catering to the needs of the local community.",
                    "Brgy. Muzon, CSJDM, Bulacan")
            )

            "Food Parks" -> listOf(
                Destination(R.drawable.img_savano, "Savano Park",
                    "Savano Park is a food park located in San Jose del Monte, Bulacan. It offers a variety of food stalls and dining options, making it a popular destination for food lovers in the area.",
                    "Brgy. San Manuel, CSJDM, Bulacan"),

                Destination(R.drawable.img_logbi, "Logbi's Food Park",
                    "Logbi's Food Park is a vibrant and diverse culinary destination in San Jose del Monte, Bulacan. It features a variety of food stalls offering a wide range of cuisines. You'll find everything from juicy burgers and fresh seafood to sizzling grills, aromatic coffee, and freshly baked treats. For those who enjoy a refreshing drink, there's also a beer garden where you can unwind and socialize. With its lively atmosphere, live music, and affordable prices, Logbi's Food Park is a popular spot for families, friends, and food enthusiasts to gather and enjoy a delicious meal.",
                    "Brgy. Kaypian, CSJDM, Bulacan"),

                Destination(R.drawable.img_people_park, "River Park Esplanade Night Market",
                    "River Park Esplanade Night Market comes alive as the sun sets, transforming into a vibrant hub of culinary delights and lively entertainment. Located along the scenic River Park Esplanade, this night market offers a diverse array of food stalls, tempting aromas, and a bustling atmosphere. Indulge in local delicacies, international flavors, and refreshing drinks as you soak in the enchanting ambiance. With live music, twinkling lights, and the cool river breeze, River Park Esplanade Night Market is the perfect place to unwind and enjoy the vibrant nightlife of San Jose del Monte.",
                    "Brgy. Dulong Baya, CSJDM, Bulacan"),
            )

            else -> emptyList()
        }
    }
}