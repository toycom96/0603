package com.example.ethan.recycler;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by dongkwanglee on 16. 6. 13..
 */
public abstract class EndlessRecyclerViewScrollListener extends RecyclerView.OnScrollListener {
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private int lastVisibleItemPosition = 0;        //화면에 리스트의 마지막 아이템이 보여지는지 체크
    private int visibleThreshold = 0;


    public EndlessRecyclerViewScrollListener(StaggeredGridLayoutManager layoutManager) {
        this.mStaggeredGridLayoutManager = layoutManager;
        visibleThreshold = visibleThreshold * mStaggeredGridLayoutManager.getSpanCount();
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
        int[] lastVisibleItemPositions = mStaggeredGridLayoutManager.findLastVisibleItemPositions(null);
        lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions);
        int visibleItemCount = view.getChildCount();
        int totalItemCount = mStaggeredGridLayoutManager.getItemCount();
        // same code as before
    }
}