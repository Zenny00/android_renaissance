package com.example.renaissancepaintings;

public class Painting {
    //Private data members
    private String mDescription;
    private int mId;

    //Constructor
    public Painting(String description, int id)
    {
        mDescription = description;
        mId = id;
    }

    //Public getters
    public String getDescription()
    {
        return  mDescription;
    }

    public int getId()
    {
        return mId;
    }

    //Public setters
    public void setDescription(String description)
    {
        mDescription = description;
    }

    public void setId(int id)
    {
        mId = id;
    }
}
