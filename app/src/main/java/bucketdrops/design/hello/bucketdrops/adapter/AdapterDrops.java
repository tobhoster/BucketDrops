package bucketdrops.design.hello.bucketdrops.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bucketdrops.design.hello.bucketdrops.R;
import bucketdrops.design.hello.bucketdrops.beans.Drop;

/**
 * Created by oeade on 6/19/2016.
 */
public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder> {
    private LayoutInflater mInflater;
    private ArrayList<String> mItems = new ArrayList<>();
    public static final String TAG = "BULLION";

    public AdapterDrops(Context context) {
        mInflater = LayoutInflater.from(context);
        mItems = generateValues();
    }

    public static ArrayList<String> generateValues() {
        ArrayList<String> dummyValues = new ArrayList<>();
        for (int i = 1; i < 101; i++){
            dummyValues.add("Item " + i);
        }
        return dummyValues;
    }

    @Override
    public DropHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_drop, parent, false);
        DropHolder dropHolder = new DropHolder(view);
        Log.d(TAG, "onCreateViewHolder: ");
        return dropHolder;
    }

    @Override
    public void onBindViewHolder(DropHolder holder, int position) {
        holder.mTextWhat.setText(mItems.get(position));
        Log.d(TAG, "onBindViewHolder: " + position);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class DropHolder extends RecyclerView.ViewHolder{

        TextView mTextWhat;

        public DropHolder(View itemView) {
            super(itemView);
            mTextWhat = (TextView) itemView.findViewById(R.id.tv_what);
        }
    }
}
