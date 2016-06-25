package bucketdrops.design.hello.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import bucketdrops.design.hello.bucketdrops.adapter.AdapterDrops;
import bucketdrops.design.hello.bucketdrops.beans.Drop;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class ActivityMain extends AppCompatActivity {

    Toolbar mToolbar;
    Button mBtnAdd;
    RecyclerView mRecyclerView;
    Realm mRealm;
    RealmResults<Drop> mResults;
    AdapterDrops mAdapter;

    private final String TAG = "ActivityMain";

    private View.OnClickListener mBtnAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showDialogAdd();
        }
    };

    private RealmChangeListener mChangeListener = new RealmChangeListener() {
        @Override
        public void onChange(Object element) {
            Log.d(TAG, "onChange: was called");
            mAdapter.update(mResults);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); /* Set Layout for the Application   */
        mRealm = Realm.getDefaultInstance();
        mResults = mRealm.where(Drop.class).findAllAsync();
        mToolbar = (Toolbar) findViewById(R.id.toolbar); /* Define the View for TOolbar, toolbar  */
        mBtnAdd = (Button) findViewById(R.id.btn_add); /*   Define the View for Button, btn_add    */
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_drops);
        mAdapter = new AdapterDrops(this, mResults);
        mRecyclerView.setAdapter(mAdapter);
        mBtnAdd.setOnClickListener(mBtnAddListener);


        setSupportActionBar(mToolbar);  /*  Set ActionBar - Just define mToolBar as ActionBar   */
        initBackgroundImage(); /* Initialize the Background Method */
    }

    private void showDialogAdd() {
        DialogAdd dialog = new DialogAdd();
        dialog.show(getSupportFragmentManager(), "Add");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mResults.addChangeListener(mChangeListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mResults.removeChangeListener(mChangeListener);
    }

    /*  Set the background for the Home View    */
    /*  The initBackgroundImage
    *   Uses the ImageView to set the background. Defining the View as iv_background.
    *   A depencidies was import called Glide, used to set the background.*/
    private void initBackgroundImage() {
        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this)
                .load(R.drawable.background)
                .centerCrop()
                .into(background);
    }
}
