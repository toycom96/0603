package com.example.ethan.recycler;

import android.content.ClipData;
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
import android.widget.AbsListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{
    private StaggeredGridLayoutManager _sGridLayoutManager;
    public List<ItemObject> items = new ArrayList<ItemObject>();
    public SampleRecyclerViewAdapter rcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //recyclerView.setHasFixedSize(true);

        _sGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(_sGridLayoutManager);


        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(_sGridLayoutManager) {
            //@Override
            public void onLoadMore(int page, int totalItemsCount) {
                customLoadMoreDataFromApi(page);
            }
        });

        rcAdapter = new SampleRecyclerViewAdapter(MainActivity.this, items);
        recyclerView.setAdapter(rcAdapter);

        customLoadMoreDataFromApi(0);
    }

    public void customLoadMoreDataFromApi(int offset) {
        // Send an API request to retrieve appropriate data using the offset value as a parameter.
        // Deserialize API response and then construct new objects to append to the adapter
        // Add the new objects to the data source for the adapter
        items.add(new ItemObject("https://i.ytimg.com/vi/OMB4TS6sCYo/hqdefault.jpg", "George Orwell"));

        // For efficiency purposes, notify the adapter of only the elements that got changed
        // curSize will equal to the index of the first element inserted because the list is 0-indexed
        int curSize = rcAdapter.getItemCount();
        rcAdapter.notifyItemRangeInserted(curSize, items.size() - 1);
    }




    private List<ItemObject> getListItemData()
    {
        List<ItemObject> listViewItems = new ArrayList<ItemObject>();
        listViewItems.add(new ItemObject("http://www.topgear.com/sites/default/files/styles/16x9_640w/public/cars-road-test/image/2015/04/Large%20Image_134.jpg?itok=fgfnlrNN", "George Orwell"));
        listViewItems.add(new ItemObject("http://i.kinja-img.com/gawker-media/image/upload/dqhwzcryunyv6tznrqjy.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://cars.mclaren.com/files/live/sites/mclaren/files/cars-mclaren-com-Main/McLaren%20Model%20Section/650S%20Coupe/Design/650S_Hero_Design_Height4.jpg?t=w1440", "George Orwell"));
        listViewItems.add(new ItemObject("http://cars.mclaren.com/files/live/sites/mclaren/files/cars-mclaren-com-Main/McLaren%20Model%20Section/GT%20Sprint%20650S/McLaren_650SGTSprint_front3q_2f-Edit.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://images.cdn.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/mclaren-650s-rt-325_0.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://www.telegraph.co.uk/cars/images/2015/12/30/McLaren-650S-front-large_trans++_emuMSIF920-7wOLsuHQL5-4UITJmy5HzCeWHAP_eZw.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://ag-spots-2014.o.auroraobjects.eu/2014/06/23/mclaren-650s-c489723062014153820_2.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://cdn9.themanual.com/wp-content/uploads/2014/04/2015-McLaren-650S-22.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://pullzone1.motoringresearch.netdna-cdn.com/wp-content/uploads/2014/03/McLaren-650S-orange.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("https://i.ytimg.com/vi/OMB4TS6sCYo/hqdefault.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://bitcast-r.v1.sjc1.bitgravity.com/wapitltd/images2/550000/9000/900/559912.jpg", "George Orwell"));


        listViewItems.add(new ItemObject("http://www.topgear.com/sites/default/files/styles/16x9_640w/public/cars-road-test/image/2015/04/Large%20Image_134.jpg?itok=fgfnlrNN", "George Orwell"));
        listViewItems.add(new ItemObject("http://i.kinja-img.com/gawker-media/image/upload/dqhwzcryunyv6tznrqjy.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://cars.mclaren.com/files/live/sites/mclaren/files/cars-mclaren-com-Main/McLaren%20Model%20Section/650S%20Coupe/Design/650S_Hero_Design_Height4.jpg?t=w1440", "George Orwell"));
        listViewItems.add(new ItemObject("http://cars.mclaren.com/files/live/sites/mclaren/files/cars-mclaren-com-Main/McLaren%20Model%20Section/GT%20Sprint%20650S/McLaren_650SGTSprint_front3q_2f-Edit.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://images.cdn.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/mclaren-650s-rt-325_0.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://www.telegraph.co.uk/cars/images/2015/12/30/McLaren-650S-front-large_trans++_emuMSIF920-7wOLsuHQL5-4UITJmy5HzCeWHAP_eZw.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://ag-spots-2014.o.auroraobjects.eu/2014/06/23/mclaren-650s-c489723062014153820_2.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://cdn9.themanual.com/wp-content/uploads/2014/04/2015-McLaren-650S-22.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://pullzone1.motoringresearch.netdna-cdn.com/wp-content/uploads/2014/03/McLaren-650S-orange.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("https://i.ytimg.com/vi/OMB4TS6sCYo/hqdefault.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://bitcast-r.v1.sjc1.bitgravity.com/wapitltd/images2/550000/9000/900/559912.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://www.topgear.com/sites/default/files/styles/16x9_640w/public/cars-road-test/image/2015/04/Large%20Image_134.jpg?itok=fgfnlrNN", "George Orwell"));
        listViewItems.add(new ItemObject("http://i.kinja-img.com/gawker-media/image/upload/dqhwzcryunyv6tznrqjy.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://cars.mclaren.com/files/live/sites/mclaren/files/cars-mclaren-com-Main/McLaren%20Model%20Section/650S%20Coupe/Design/650S_Hero_Design_Height4.jpg?t=w1440", "George Orwell"));
        listViewItems.add(new ItemObject("http://cars.mclaren.com/files/live/sites/mclaren/files/cars-mclaren-com-Main/McLaren%20Model%20Section/GT%20Sprint%20650S/McLaren_650SGTSprint_front3q_2f-Edit.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://images.cdn.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/mclaren-650s-rt-325_0.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://www.telegraph.co.uk/cars/images/2015/12/30/McLaren-650S-front-large_trans++_emuMSIF920-7wOLsuHQL5-4UITJmy5HzCeWHAP_eZw.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://ag-spots-2014.o.auroraobjects.eu/2014/06/23/mclaren-650s-c489723062014153820_2.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://cdn9.themanual.com/wp-content/uploads/2014/04/2015-McLaren-650S-22.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://pullzone1.motoringresearch.netdna-cdn.com/wp-content/uploads/2014/03/McLaren-650S-orange.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("https://i.ytimg.com/vi/OMB4TS6sCYo/hqdefault.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://bitcast-r.v1.sjc1.bitgravity.com/wapitltd/images2/550000/9000/900/559912.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://www.topgear.com/sites/default/files/styles/16x9_640w/public/cars-road-test/image/2015/04/Large%20Image_134.jpg?itok=fgfnlrNN", "George Orwell"));
        listViewItems.add(new ItemObject("http://i.kinja-img.com/gawker-media/image/upload/dqhwzcryunyv6tznrqjy.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://cars.mclaren.com/files/live/sites/mclaren/files/cars-mclaren-com-Main/McLaren%20Model%20Section/650S%20Coupe/Design/650S_Hero_Design_Height4.jpg?t=w1440", "George Orwell"));
        listViewItems.add(new ItemObject("http://cars.mclaren.com/files/live/sites/mclaren/files/cars-mclaren-com-Main/McLaren%20Model%20Section/GT%20Sprint%20650S/McLaren_650SGTSprint_front3q_2f-Edit.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://images.cdn.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/mclaren-650s-rt-325_0.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://www.telegraph.co.uk/cars/images/2015/12/30/McLaren-650S-front-large_trans++_emuMSIF920-7wOLsuHQL5-4UITJmy5HzCeWHAP_eZw.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://ag-spots-2014.o.auroraobjects.eu/2014/06/23/mclaren-650s-c489723062014153820_2.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://cdn9.themanual.com/wp-content/uploads/2014/04/2015-McLaren-650S-22.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://pullzone1.motoringresearch.netdna-cdn.com/wp-content/uploads/2014/03/McLaren-650S-orange.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("https://i.ytimg.com/vi/OMB4TS6sCYo/hqdefault.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://bitcast-r.v1.sjc1.bitgravity.com/wapitltd/images2/550000/9000/900/559912.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://www.topgear.com/sites/default/files/styles/16x9_640w/public/cars-road-test/image/2015/04/Large%20Image_134.jpg?itok=fgfnlrNN", "George Orwell"));
        listViewItems.add(new ItemObject("http://i.kinja-img.com/gawker-media/image/upload/dqhwzcryunyv6tznrqjy.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://cars.mclaren.com/files/live/sites/mclaren/files/cars-mclaren-com-Main/McLaren%20Model%20Section/650S%20Coupe/Design/650S_Hero_Design_Height4.jpg?t=w1440", "George Orwell"));
        listViewItems.add(new ItemObject("http://cars.mclaren.com/files/live/sites/mclaren/files/cars-mclaren-com-Main/McLaren%20Model%20Section/GT%20Sprint%20650S/McLaren_650SGTSprint_front3q_2f-Edit.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://images.cdn.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/mclaren-650s-rt-325_0.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://www.telegraph.co.uk/cars/images/2015/12/30/McLaren-650S-front-large_trans++_emuMSIF920-7wOLsuHQL5-4UITJmy5HzCeWHAP_eZw.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://ag-spots-2014.o.auroraobjects.eu/2014/06/23/mclaren-650s-c489723062014153820_2.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://cdn9.themanual.com/wp-content/uploads/2014/04/2015-McLaren-650S-22.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://pullzone1.motoringresearch.netdna-cdn.com/wp-content/uploads/2014/03/McLaren-650S-orange.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("https://i.ytimg.com/vi/OMB4TS6sCYo/hqdefault.jpg", "George Orwell"));
        listViewItems.add(new ItemObject("http://bitcast-r.v1.sjc1.bitgravity.com/wapitltd/images2/550000/9000/900/559912.jpg", "George Orwell"));

        //listViewItems.add(new ItemObject("Pride and Prejudice", "Jane Austen"));
        //listViewItems.add(new ItemObject("One Hundred Years of Solitude", "Gabriel Garcia Marquez"));
        //listViewItems.add(new ItemObject("The Book Thief", "Markus Zusak"));
        //listViewItems.add(new ItemObject("The Hunger Games", "Suzanne Collins"));
        //listViewItems.add(new ItemObject("The Hitchhiker's Guide to the Galaxy", "Douglas Adams"));
        //listViewItems.add(new ItemObject("The Theory Of Everything", "Dr Stephen Hawking"));

        return listViewItems;
    }
}