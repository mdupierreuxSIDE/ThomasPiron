package eu.side.thomaspiron.android.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import eu.side.thomaspiron.android.R;

/**
 * Created by mdupierreux1 on 23/11/15.
 */
public class SlidingImageAdapter extends PagerAdapter {
    private static final String LOG_TAG = SlidingImageAdapter.class.getSimpleName();
    private Context context;
    private LayoutInflater layoutInflater;
    private String[] images;

    public SlidingImageAdapter(String[] images, Context context ) {
        this.images = images;
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object==view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.sliding_image_item,container,false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        Picasso.with(context).load(images[position]).into(imageView);
        Log.d(LOG_TAG,"in instantiateItem "+images[position]);
        container.addView(itemView,0);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    public float getPageWidth(int position) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;



        return 335f/dpWidth;
    }
}
