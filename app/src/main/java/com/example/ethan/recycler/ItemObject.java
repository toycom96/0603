package com.example.ethan.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import java.util.ArrayList;
import java.util.List;
/**
 * Created by ethan on 16. 6. 8..
 */
public class ItemObject
{
    private int _id;
    private String _name;
    private String _author;

    public ItemObject(String name, String auth, int _id)
    {
        this._name = name;
        this._author = auth;
        this._id = _id;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        this._name = name;
    }

    public String getAuthor()
    {
        return _author;
    }

    public void setAuthor(String auth)
    {
        this._author = auth;
    }

    public void setId(int id) { this._id = id; }

    public int getId() { return _id;}
}