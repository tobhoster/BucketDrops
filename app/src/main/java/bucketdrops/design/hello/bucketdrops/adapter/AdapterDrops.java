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
import io.realm.RealmResults;

/**
 * Created by oeade on 6/19/2016.
 */
public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder> {
    private LayoutInflater mInflater;
    private RealmResults<Drop> mResults;
    public static final String TAG = "BULLION";

    public AdapterDrops(Context context, RealmResults<Drop> results) {
        mInflater = LayoutInflater.from(context);
        update(results);
    }

    public void update(RealmResults<Drop> results) {
        mResults = results;
        notifyDataSetChanged();
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
        Drop drop = mResults.get(position);
        holder.mTextWhat.setText(drop.getWhat());
        Log.d(TAG, "onBindViewHolder: " + position);
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public static class DropHolder extends RecyclerView.ViewHolder{

        TextView mTextWhat;

        public DropHolder(View itemView) {
            super(itemView);
            mTextWhat = (TextView) itemView.findViewById(R.id.tv_what);
        }
    }
}
