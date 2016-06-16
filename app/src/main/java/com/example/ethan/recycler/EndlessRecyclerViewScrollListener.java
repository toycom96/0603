package com.example.ethan.recycler;


import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ethan.recycler.MainActivity;
/**
 * Created by dongkwanglee on 16. 6. 13..
 */
public class EndlessRecyclerViewScrollListener extends RecyclerView.OnScrollListener {
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    public int lastVisibleItemPosition = 0;        //화면에 리스트의 마지막 아이템이 보여지는지 체크
    public int visibleThreshold = 0;
    public View view;
    private Context mContext = null;
    MainActivity mActivity;



    public EndlessRecyclerViewScrollListener(MainActivity activity, StaggeredGridLayoutManager layoutManager) {
        this.mActivity = activity;
        this.mStaggeredGridLayoutManager = layoutManager;
        visibleThreshold = visibleThreshold * mStaggeredGridLayoutManager.getSpanCount();
        //Toast.makeText(getActivity().getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();
        //Toast.makeText(AppCompatActivity(), "msg msg", Toast.LENGTH_SHORT).show();

    }

    public int getLastVisibleItem(int[] lastVisibleItemPositions) {
        int maxSize = 0;
        for (int i = 0; i < lastVisibleItemPositions.length; i++) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i];
            }
            else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i];
            }
        }
        return maxSize;
    }

    // This happens many times a second during a scroll, so be wary of the code you place here.
    // We are given a few useful parameters to help us work out if we need to load some more data,
    // but first we check if we are waiting for the previous load to finish.
    @Override
    public void onScrolled(RecyclerView view, int dx, int dy) {
        String tmpstr ="";
        int[] lastVisibleItemPositions = mStaggeredGridLayoutManager.findLastVisibleItemPositions(null);
        lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions);
        int visibleItemCount = view.getChildCount();
        int totalItemCount = mStaggeredGridLayoutManager.getItemCount();
        // same code as before


        tmpstr = "position" + visibleItemCount +  "/" + lastVisibleItemPosition + "/" + totalItemCount;
        //Toast.makeText(view.getContext(), tmpstr, 1).show();
        if (lastVisibleItemPositions[0] + 2 >= totalItemCount) {
            int offset = this.mActivity.items.get(totalItemCount).getId();

            this.mActivity.customLoadMoreDataFromApi(offset + 0);
            this.mActivity.customLoadMoreDataFromApi(1);
            this.mActivity.customLoadMoreDataFromApi(2);
            this.mActivity.customLoadMoreDataFromApi(3);
            this.mActivity.customLoadMoreDataFromApi(4);
            this.mActivity.customLoadMoreDataFromApi(5);
            this.mActivity.customLoadMoreDataFromApi(6);
            this.mActivity.customLoadMoreDataFromApi(7);
            this.mActivity.customLoadMoreDataFromApi(8);
            this.mActivity.customLoadMoreDataFromApi(9);




            //Toast.makeText(view.getContext(), "aaaa", 1).show();
        }

    }
}
