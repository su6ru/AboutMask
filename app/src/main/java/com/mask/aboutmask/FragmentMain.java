package com.mask.aboutmask;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.Calendar;
import java.util.Date;

public class FragmentMain extends Fragment {
    int test=123;
    private TextView fragmentMainTxv;
    private ConstraintLayout fragmentMainConstraintLayout;
    private IFragmentMain iFragmentMain;
    private TextClock textClock;
    private TextView txvMaskTitle;
    private TextView txvMaskDate;
    private TextView txvDate;
    private TextView txvWeek;
    private TextView updateTime;
    private Button btnIdentify;
    private Button btnInfect;
    private int w;
    private MaterialToolbar materialToolbar;
    FragmentMain(IFragmentMain ifragment){
        this.iFragmentMain=ifragment;
    }
    @SuppressLint("Range")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main,container,false);
        fragmentMainConstraintLayout=view.findViewById(R.id.fragmentMainConstraintLayout);
        txvMaskDate=view.findViewById(R.id.txvMaskDate);
        txvDate=view.findViewById(R.id.txvDate);
        txvWeek=view.findViewById(R.id.txvWeek);
        btnInfect=view.findViewById(R.id.btnInfect);
        btnIdentify=view.findViewById(R.id.btnIdentify);

        getTime();
        setMaskDate(txvMaskDate);
        setTxvFont(txvDate,txvWeek,txvMaskDate);
        btnInfect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iFragmentMain.useFragmentMain();
            }
        });
        btnIdentify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iFragmentMain.goIdentify();
            }
        });
        return view;
    }

    private void getTime() {
        long time=System.currentTimeMillis();
        Date date=new Date(time);
        /*SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 EEEE");
        Log.e("time","time1="+format.format(date));
        format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log.e("time","time2="+format.format(date));
        format=new SimpleDateFormat("yyyy/MM/dd");
        Log.e("time","time3="+format.format(date));
        format=new SimpleDateFormat("HH:mm:ss");
        Log.e("time","time4="+format.format(date));
        format=new SimpleDateFormat("EEEE");
        Log.e("time","time5="+format.format(date));
        format=new SimpleDateFormat("E");
        Log.e("time","time6="+format.format(date));*/
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        Log.e("time","time6="+w);


    }

    @SuppressLint("SetTextI18n")
    private void setMaskDate(TextView txv) {

        if (w==0){
            txvMaskDate.setText("0~9");
        }else {
            if (w%2==0){
                txvMaskDate.setText("0、2、4、6、8");
            }else if (w%2==1) {
                txvMaskDate.setText("1、3、5、7、9");
            }else {
                txvMaskDate.setText("發生不明錯誤");
            }
        }
    }
    private void setTxvFont(TextView txvDate,TextView txvWeek,TextView txvMaskDate) {

        iFragmentMain.setFont(txvDate,txvWeek,txvMaskDate);

    }
}
