package com.example.yhh.firstest;


import java.util.Timer;
import java.util.TimerTask;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.ColumnChartView;
import android.app.Activity;
import android.os.Bundle;



public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取布局中的元素
        LineChartView lineChart = (LineChartView)findViewById(R.id.line_chart);
        LineChart line = new LineChart(lineChart);
        ColumnChartView columnChartView = (ColumnChartView) findViewById(R.id.columnchart);
        final ColumChart colum = new ColumChart(columnChartView);

        //折线图的设置
        line.getAxisXLables();//获取x轴的标注
        line.getAxisPoints();//获取坐标点
        line.initLineChart();//初始化

        //使用定时器实时刷新数据
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                colum.generateDefaultData();
            }
        }, 1000, 1000);

    }






}