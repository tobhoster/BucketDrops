package bucketdrops.design.hello.bucketdrops;

import android.app.Dialog;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ActivityMain extends AppCompatActivity {

    Toolbar mToolbar;
    Button mBtnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); /* Set Layout for the Application   */
        mToolbar = (Toolbar) findViewById(R.id.toolbar); /* Define the View for TOolbar, toolbar  */
        mBtnAdd = (Button) findViewById(R.id.btn_add); /*   Define the View for Button, btn_add    */
        setSupportActionBar(mToolbar);  /*  Set ActionBar - Just define mToolBar as ActionBar   */
        initBackgroundImage(); /* Initialize the Background Method */

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAdd();
            }
        });
    }

    private void showDialogAdd() {
        DialogAdd dialog = new DialogAdd();
        dialog.show(getSupportFragmentManager(), "Add");
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
