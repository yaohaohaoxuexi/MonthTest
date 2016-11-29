package com.hao.monthtest2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.hao.monthtest2.adapter.MyAdapter;
import com.hao.monthtest2.fragment.Fragment1;
import com.hao.monthtest2.url.HttpUrl;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends FragmentActivity {

    String[] s1 = new String[]{"小学", "初中", "高中"};
    String[] s2 = new String[]{"一年级", "二年级", "三年级", "四年级", "五年级", "六年级"};
    String[] s3 = new String[]{"初一", "初二", "初三"};
    String[] s4 = new String[]{"高一", "高二", "高三"};
    private LinearLayout linearLayout;
    private ListView listView1;
   private ListView listView2;
    private PopupWindow pw;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SlidingMenu slidingMenu=new SlidingMenu(MainActivity.this);
        tv = (TextView) findViewById(R.id.tv_gragde);
    }
    public void grade(View v) {
        View v1 = View.inflate(MainActivity.this, R.layout.list_view, null);
        linearLayout = (LinearLayout) v1.findViewById(R.id.linearLayout);
        listView1 = (ListView) v1.findViewById(R.id.listView1);
        listView2 = (ListView) v1.findViewById(R.id.listView2);

        pw = new PopupWindow(v1, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        listView1.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, s1));

        pw.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        listView2.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, s2));
                        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                                if (position == 3) {
                                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                                    beginTransaction.replace(R.id.frame, Fragment1.newInstance(HttpUrl.url2)).commit();
                                    runOnUiThread(new Runnable() {
                                        public void run() {
                                            tv.setText(s2[position]);
                                        }
                                    });
                                    pw.dismiss();
                                }
                            }
                        });

                        break;
                    case 1:
                        listView2.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, s3));
                        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                                if (position == 0) {
                                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                                    beginTransaction.replace(R.id.frame, Fragment1.newInstance(HttpUrl.url1)).commit();
                                    runOnUiThread(new Runnable() {
                                        public void run() {
                                            tv.setText(s3[position]);
                                        }
                                    });
                                    pw.dismiss();
                                }
                            }
                        });
                        break;
                    case 2:
                        listView2.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, s4));
                        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                                if (position == 0) {
                                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                                    beginTransaction.replace(R.id.frame, Fragment1.newInstance(HttpUrl.url3)).commit();
                                    runOnUiThread(new Runnable() {
                                        public void run() {
                                            tv.setText(s4[position]);
                                        }
                                    });
                                    pw.dismiss();
                                }
                            }
                        });
                        break;
                }
            }
        });
        pw.showAtLocation(linearLayout, Gravity.LEFT, 0, 0);

    }
}
