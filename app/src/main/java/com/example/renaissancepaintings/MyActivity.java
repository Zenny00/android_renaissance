package com.example.renaissancepaintings;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    //Private data member
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Get a reference to the layout in the view
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        //Fill the layout with paintings
        fillPaintingGallery();
    }

    //Fills the gallery with paintings
    private void fillPaintingGallery()
    {
        //Used to store the images
        ImageButton buttonItem;

        //Iterate through each image description
        for (int i = 0; i < RenaissanceDatabase.description.length; i++)
        {
            //Save images as buttons
            buttonItem = new ImageButton(this);

            //Initialize a painting to the corresponding values in the Renaissance database
            Painting painting = new Painting(RenaissanceDatabase.description[i], RenaissanceDatabase.id[i]);

            //Set the description
            buttonItem.setContentDescription(painting.getDescription());

            //Set the image
            buttonItem.setImageDrawable(getResources().getDrawable(painting.getId()));

            //Add on click listener
            buttonItem.setOnClickListener(displayPaintingInformation);

            //Add button to the layout
            mLinearLayout.addView(buttonItem);
        }
    }

    //Click listener | anonymous
    private View.OnClickListener displayPaintingInformation = new View.OnClickListener() {
        public void onClick(View btn)
        {
            //Get description from the painting
            String paintingDescription = (String) btn.getContentDescription();

            //Display description
            displayToast(paintingDescription);
        }
    };

    //Display info using a toast
    public void displayToast(String paintingDescription)
    {
        //Make a new toast with a short life and display it
        Toast.makeText(this, paintingDescription, Toast.LENGTH_SHORT).show();
    }
}