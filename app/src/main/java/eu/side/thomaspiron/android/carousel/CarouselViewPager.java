package eu.side.thomaspiron.android.carousel;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by mdupierreux1 on 5/04/17.
 */

public class CarouselViewPager extends ViewPager{
    private CarouselAdapter carouselAdapter;

    public CarouselViewPager(Context context) {
        super(context);
    }

    public CarouselViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CarouselViewPager(Context context, CarouselAdapter carouselAdapter) {
        super(context);
        this.carouselAdapter = carouselAdapter;
    }

    public CarouselViewPager(Context context, AttributeSet attrs, CarouselAdapter carouselAdapter) {
        super(context, attrs);
        this.carouselAdapter = carouselAdapter;
    }


}
