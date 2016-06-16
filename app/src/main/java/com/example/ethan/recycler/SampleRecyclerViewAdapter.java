package com.example.ethan.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ethan on 16. 6. 8..
 */
public class SampleRecyclerViewAdapter extends RecyclerView.Adapter<SampleViewHolders>
{
    private List<ItemObject> itemList;
    private Context context;

    public SampleRecyclerViewAdapter(Context context, List<ItemObject> itemList)
    {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public SampleViewHolders onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_over_text, null);
        SampleViewHolders rcv = new SampleViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(SampleViewHolders holder, int position)
    {
        Picasso.with(context).load(itemList.get(position).getName()).resize(476,0).into(holder.bookName);
        holder.authorName.setText(itemList.get(position).getAuthor());
        holder.contentId = itemList.get(position).getId();
    }

    @Override
    public int getItemCount()
    {
        return this.itemList.size();
    }
}
