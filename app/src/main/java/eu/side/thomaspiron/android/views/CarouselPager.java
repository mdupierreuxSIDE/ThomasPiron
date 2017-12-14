package eu.side.thomaspiron.android.views;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.LinkedList;
import java.util.List;

import eu.side.thomaspiron.android.adapters.SlidingImageAdapter;

/**
 * Created by mdupierreux1 on 5/04/17.
 */

public class CarouselPager extends ViewPager {

    private SlidingImageAdapter slidingImageAdapter;
    private List<Uri> urls;

    public CarouselPager(Context context) {
        super(context);
    }

    public CarouselPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CarouselPager(Context context, AttributeSet attrs, SlidingImageAdapter slidingImageAdapter) {
        super(context, attrs);
        this.slidingImageAdapter = slidingImageAdapter;
        this.urls = new LinkedList<>();
    }

    public CarouselPager(Context context, SlidingImageAdapter slidingImageAdapter) {
        super(context);
        this.slidingImageAdapter = slidingImageAdapter;
        this.urls = new LinkedList<>();
    }

    public CarouselPager(Context context, SlidingImageAdapter slidingImageAdapter, List<Uri> urls) {
        super(context);
        this.slidingImageAdapter = slidingImageAdapter;
        this.urls = urls;
    }

    public CarouselPager(Context context, AttributeSet attrs, SlidingImageAdapter slidingImageAdapter, List<Uri> urls) {
        super(context, attrs);
        this.slidingImageAdapter = slidingImageAdapter;
        this.urls = urls;
    }

    public void setData(List<Uri> urls){
        this.urls = urls;
    }



}
