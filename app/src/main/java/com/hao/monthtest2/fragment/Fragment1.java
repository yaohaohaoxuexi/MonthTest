package com.hao.monthtest2.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hao.monthtest2.R;
import com.hao.monthtest2.adapter.MyAdapter;
import com.hao.monthtest2.bean.Bean3;
import com.hao.monthtest2.utils.JsonUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016-11-27.
 */

public class Fragment1 extends Fragment {
    private ListView listView_f1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.f1, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        String url1 = bundle.getString("url");

        listView_f1 = (ListView) getView().findViewById(R.id.listView_f1);

        MyAsyncTask myAsyncTask=new MyAsyncTask();
        myAsyncTask.execute(url1);
    }

    class MyAsyncTask extends AsyncTask<String, Void, ArrayList<Bean3>> {

        @Override
        protected void onPostExecute(ArrayList<Bean3> bean3s) {
            super.onPostExecute(bean3s);
            listView_f1.setAdapter(new MyAdapter(getActivity(),bean3s));
        }

        @Override
        protected ArrayList<Bean3> doInBackground(String... params) {
            String url2 = params[0];
            ArrayList<Bean3> list=new ArrayList<Bean3>();
            try {
                URL url3 = new URL(url2);

                HttpURLConnection conn = (HttpURLConnection) url3.openConnection();
                conn.setConnectTimeout(3000);
                conn.setReadTimeout(3000);
                conn.setRequestMethod("GET");
                if (conn.getResponseCode() == 200) {
                    InputStream inputStream = conn.getInputStream();
                    String json = inputStream2String(inputStream);
                    list = JsonUtils.parseJson(json);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }
    }

    public String inputStream2String(InputStream in) {
        String s1 = "";
        String s2 = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            while ((s1 = br.readLine()) != null) {
                s2 += s1;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s2;
    }

    public static Fragment1 newInstance(String url) {
        Fragment1 fragment1 = null;
        if (fragment1 == null) {
            fragment1 = new Fragment1();
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        fragment1.setArguments(bundle);
        return fragment1;
    }
}
