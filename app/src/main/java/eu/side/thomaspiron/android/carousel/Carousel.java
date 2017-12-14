package eu.side.thomaspiron.android.carousel;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

import eu.side.thomaspiron.android.R;

/**
 * Created by mdupierreux1 on 5/04/17.
 */

public class Carousel extends FrameLayout {

    private CarouselViewPager carouselViewPager;
    private CarouselImageListener carouselImageListener;
    private CarouselAdapter adapter;

    public Carousel(@NonNull Context context) {
        super(context);
    }

    public Carousel(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initCarousel(context, attrs, 0, 0);
    }

    public Carousel(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCarousel(context, attrs, defStyleAttr, 0);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Carousel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initCarousel(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initCarousel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        View view = LayoutInflater.from(context).inflate(R.layout.carousel_view,this,true);
        carouselViewPager = (CarouselViewPager)view.findViewById(R.id.carousel_viewpager);
    }

    public void setData(List<Uri> uris){
        adapter = new CarouselAdapter(uris,getContext(),carouselImageListener);
        carouselViewPager.setAdapter(adapter);

    }

    public void setCarouselImageListener(CarouselImageListener carouselImageListener) {
        this.carouselImageListener = carouselImageListener;
    }
}
