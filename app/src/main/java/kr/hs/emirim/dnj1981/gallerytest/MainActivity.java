package kr.hs.emirim.dnj1981.gallerytest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Gallery gallery;
    ImageView imgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery=(Gallery)findViewById(R.id.gallery_1);
        imgMain=(ImageView)findViewById(R.id.imgv_main);
        MyGalleryAdapter adapter=new MyGalleryAdapter(this);
        gallery.setAdapter(adapter);
    }

    public class MyGalleryAdapter extends BaseAdapter{
        Context context;
        int[] posterIDs={R.drawable.movie01,R.drawable.movie02,R.drawable.movie03,
                R.drawable.movie04,R.drawable.movie05,R.drawable.movie06,
                R.drawable.movie07,R.drawable.movie08,R.drawable.movie09,
                R.drawable.movie10,};

        public MyGalleryAdapter(Context context){
            this.context=context;

        }
        public int getCount(){
            return posterIDs.length;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imgV=new ImageView(context);
            imgV.setLayoutParams(new Gallery.LayoutParams(100,150));
            imgV.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgV.setPadding(5,5,5,5);
            imgV.setImageResource(posterIDs[position]);
            final int pos=position;
            imgV.setOnTouchListener(new View.OnTouchListener(){
                public boolean onTouch(View v, MotionEvent event){
                    imgMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imgMain.setImageResource(posterIDs[pos]);
                    return false;
                }
            });
            return imgV;
        }
        public long getItemId(int position){
            return 0;
        }
        public Object getItem(int position){
            return null;
        }
    }
}
