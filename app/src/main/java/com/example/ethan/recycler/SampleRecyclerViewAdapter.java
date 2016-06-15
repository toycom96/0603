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

    public SampleRecyclerViewAdapter(Context context,
                                     List<ItemObject> itemList)
    {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public SampleViewHolders onCreateViewHolder(ViewGroup parent, int viewType)
    {
        //View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, null);
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_over_text, null);
        SampleViewHolders rcv = new SampleViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(SampleViewHolders holder, int position)
    {
        //holder.bookName.setText(itemList.get(position).getName());
        /*try {
            URL url = new URL("http://cars.mclaren.com/files/live/sites/mclaren/files/cars-mclaren-com-Main/McLaren%20Model%20Section/650S%20Spider/Introduction/650Spiderintroduction-home-resize4932x2479-crop3699x2473-crop3702x2175.jpg?t=w1440");
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.bookName.setImageBitmap(bmp);
        }catch(IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

        //Toast.makeText(context, "width = " + holder.authorName.getWidth(), 3).show();
        Picasso.with(context).load(itemList.get(position).getName()).resize(476,0).into(holder.bookName);
        //Picasso.with(context).load(itemList.get(position).getName()).fit().into(holder.bookName);
        holder.authorName.setText(itemList.get(position).getAuthor());
    }

    @Override
    public int getItemCount()
    {
        return this.itemList.size();
    }
}
