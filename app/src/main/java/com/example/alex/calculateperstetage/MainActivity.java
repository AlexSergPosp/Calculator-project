package com.example.alex.calculateperstetage;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class MainActivity extends AppCompatActivity {

    private Drawer.Result drawerResult;
    private double number = 1;
    private double percentage = 1;
    private double answer;
    public TextView textView3;
    private EditText editNumber;
    private EditText editPercentage;
    Standart standart;
    Discount discount;
    FragmentTransaction ftrans;
    Toolbar toolbar;
    RelativeLayout relative;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        relative = (RelativeLayout) findViewById(R.id.relativeLayout);
        standart = new Standart();
        discount = new Discount();
        ftrans = getFragmentManager().beginTransaction();
        ftrans.add(R.id.frgmCont,standart);
        ftrans.commit();



        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }

        inicializationDrawer(toolbar);

    }

    @Override
    public void onBackPressed() {
        if (drawerResult != null  && drawerResult.isDrawerOpen()){
            drawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }


    }

    private void inicializationDrawer(Toolbar toolbar) {
        AccountHeader.Result accaunt = createAccount();


        drawerResult = new Drawer()
                .withActivity(this)
                .withAccountHeader(accaunt)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(getiDrawerItems())
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        solution(iDrawerItem);
                    }
                })
                .build();

    }

    private void solution(IDrawerItem iDrawerItem) {
        switch (iDrawerItem.getIdentifier()) {
            case 1:
                Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                ftrans = getFragmentManager().beginTransaction();
                ftrans.replace(R.id.frgmCont,standart);
                ftrans.commit();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();
                ftrans = getFragmentManager().beginTransaction();
                relative.setBackgroundColor(getResources().getColor(R.color.colorRedWhite));
                ftrans.replace(R.id.frgmCont,discount);
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorRed));
                ftrans.commit();
                break;
            case 3:
                Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(getApplicationContext(), "4", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private IDrawerItem[] getiDrawerItems() {
        return new IDrawerItem[]{new PrimaryDrawerItem()
                .withName(R.string.nav_menu_item_home)
                .withIdentifier(1),
                new DividerDrawerItem(),

                new SecondaryDrawerItem()
                        .withName(R.string.nav_menu_item_contacts)
                        .withIdentifier(2),
                new SecondaryDrawerItem()
                        .withName(R.string.nav_menu_item_item_3)
                        .withIdentifier(3),
                new SecondaryDrawerItem()
                        .withName(R.string.nav_menu_item_item_4)
                        .withIdentifier(4)};
    }

    private AccountHeader.Result createAccount() {
        return new AccountHeader()
                .withActivity(this)
                .withHeaderBackground(R.drawable.kalculator)
                .build();
    }

}