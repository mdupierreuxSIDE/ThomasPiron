package eu.side.thomaspiron.android.carousel;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

/**
 * Created by mdupierreux1 on 5/04/17.
 */

public class CarouselAdapter extends PagerAdapter {

    private CarouselImageListener carouselImageListener;
    private List<Uri> urls;
    private Context context;


    public CarouselAdapter(List<Uri> urls) {
        this.urls = urls;
    }

    public CarouselAdapter(List<Uri> urls, Context context) {
        this.urls = urls;
        this.context = context;
    }

    public CarouselAdapter(List<Uri> uris, Context context, CarouselImageListener carouselImageListener) {
        this.urls = uris;
        this.context = context;
        this.carouselImageListener = carouselImageListener;
    }


    @Override
    public int getCount() {
        return urls == null ? 0 : urls.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250));  //setting image position
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context)
                .load(urls.get(position))
                .into(imageView);
        //Picasso.with(context).load(urls.get(position).toString()).into(imageView);
        carouselImageListener.setImageForPosition(position,imageView);
        container.addView(imageView);

        return imageView;

    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}
