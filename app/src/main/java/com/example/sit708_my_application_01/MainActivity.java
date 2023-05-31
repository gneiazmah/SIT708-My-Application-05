package com.example.sit708_my_application_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    DataModel [] datalist;

    public MainActivity(DataModel[] datalist) {
        this.datalist = datalist;
    }

    @NonNull

    public MainActivity.View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View list_items = layoutInflater.inflate(R.layout.activity_main, null);

        MainActivity.View_Holder view_holder = new MainActivity.View_Holder(list_items);

        return view_holder;
    }


    public void onBindViewHolder(@NonNull MainActivity.View_Holder holder, int position) {

        DataModel dataModel = datalist[position];

        holder.img.setImageResource(dataModel.getImage());
        holder.title.setText(dataModel.getTitle());
        holder.description.setText(dataModel.getDescription());

        holder.mainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myintent = new Intent(view.getContext(),DataActivity.class);
                myintent.putExtra("Title", dataModel.getTitle());
                myintent.putExtra("Des", dataModel.getDescription());
                myintent.putExtra("Image", dataModel.getImage());

                view.getContext().startActivity(myintent);
            }
        });
    }


    public int getItemCount() {
        return datalist.length;
    }

    public class View_Holder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title, description;

        CardView mainCard;
        public View_Holder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textViewTitle);
            description = itemView.findViewById(R.id.textViewDescription);
            mainCard = itemView.findViewById(R.id.mainCard);
        }
    }

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        DataModel [] mydata = new DataModel[]{
                new DataModel("Saftey\n" + "Independents call for action to protect children",
                        "The Transportation Security Administration has announced an expansion of TSA PreCheck access just as the busy summer travel season is about to kick off.\n" +
                                "\n" +
                                "The agency said Monday that teenagers from 13 to 17 may accompany parents or guardians who are enrolled in PreCheck through security screening when they are traveling on the same reservation and when the PreCheck designation is shown on the teen’s boarding pass.\n" +
                                "\n" +
                                "Children 12 and younger had already been allowed to accompany adults without restriction and that policy remains in place.", R.drawable.news1),
                new DataModel("\n" + "Customer reviews name top car dealers",
                        "There is a popular saying in Italian – similar to how Anglophones use “when hell freezes over” – that translates as “I’ll do it when the bridge to Messina is finished.”\n" +
                                "\n" +
                                "The dream of a bridge connecting the mainland to Sicily across the Straits of Messina goes back to Roman times, when Consul Metellus strung together barrels and wood to move 100 war elephants from Carthage to Rome in 252 BCE, according to writings by Pliny the Elder.\n" +
                                "\n" +
                                "Since then, various plans, including a short-lived idea for a tunnel, have come and gone – like water under the bridge.\n" +
                                "\n" +
                                "If built, the bridge across the Straits of Messina would span two miles (3.2 kilometers) and would be the longest suspension bridge in the world.", R.drawable.news2),
                new DataModel("price freezes groceries\n" +  "Strategic shopping helps reduce grocery bills",
                        "Disney will pull certain fire effects from shows at their resorts worldwide after an animatronic dragon caught fire at Disneyland in Southern California on Saturday, company officials say.\n" +
                                "\n" +
                                "“We are temporarily suspending fire effects similar to those used at Disneyland park’s Fantasmic at select shows and entertainment experiences globally out of an abundance of caution,” Disneyland officials said in a statement on Monday.", R.drawable.news3),
                new DataModel("health insurance\n" + "Health insurance hikes add to budget pressures",
                        "High pollution levels in Thailand’s northern city of Chiang Mai and surrounding provinces are keeping tourists away and alarming locals, with the government on Monday, April 10, urging residents to avoid outdoor activities.\n" +
                                "\n" +
                                "For several weeks last month the city was at the top of air quality information platform IQAir’s global chart on poor air quality, ahead of Lahore, Pakistan and New Delhi, India.\n" +
                                "\n" +
                                "Chiang Mai, known for its scenic mountainous views, temples and chic cafés, received 10.8 million visitors in pre-pandemic 2019, but hotel bookings in the city have dropped to 45% occupancy, the Thai Hotel Association Northern Chapter president Phunut Thanalaopanich told Reuters on Monday.", R.drawable.news4),
                new DataModel("\n" +  "Marsupial from 3.5 million years ago revealed",
                        "Flowers, a coconut and a round of cheers were part of the celebrations following the inaugural test run through India’s first underwater metro tunnel on Wednesday.\n" +
                                "\n" +
                                "The Kolkata metro’s newest line, set to open to the public in November, passes underneath the Hooghly River in the city’s northeast, with the tunnel 32 meters (105 feet) below the water.\n" +
                                "\n" +
                                "“This is a historic moment for Metro Railway,” Kausik Mitra, chief public relations officer for the Kolkata metro system, said in a statement.", R.drawable.news5),

                new DataModel("RocKwiz\n" + "Live RocKwiz storms around nation",
                        "\n" +
                                "Myanmar’s military junta is holding up humanitarian access to some cyclone-hit communities in western Rakhine state after Cyclone Mocha devastated the lives and livelihoods of millions of people in the poorest parts of the country.\n" +
                                "\n" +
                                "United Nations agencies said Thursday they were still negotiating access to parts of the state four days after Mocha slammed into Myanmar’s coast on Sunday as one of the strongest storms ever to hit the country.\n" +
                                "\n" +
                                "Hundreds of people are feared to have died and thousands more are in urgent need of shelter, clean water, food and health care as a clearer picture of the devastation is beginning to emerge.", R.drawable.news6),

        };

        MainActivity myadapter = new MainActivity(mydata);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
