package com.example.ethan.recycler;


import android.content.Context;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;
/**
 * Created by ethan on 16. 6. 8..
 */
public class SampleViewHolders extends RecyclerView.ViewHolder implements
        View.OnClickListener
{
    public ImageView bookName ;
    public TextView authorName;
    public int contentId;

    public SampleViewHolders(View itemView)
    {
        super(itemView);
        itemView.setOnClickListener(this);
        bookName = (ImageView) itemView.findViewById(R.id.BookName);
        authorName = (TextView) itemView.findViewById(R.id.AuthorName);
        contentId = 0;
    }

    @Override
    public void onClick(View view)
    {
        Toast.makeText(view.getContext(),
                "Clicked ContentId = " + contentId, Toast.LENGTH_SHORT)
                .show();
    }
}