package com.example.yhh.firstest;

import android.graphics.Color;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;


/**
 * Created by yhh on 17-10-11.
 */

public class LineChart {


    private LineChartView lineChart = null;//折线图
    String[] date = {"10-01","10-02","10-03","10-04","10-05","10-06","10-07","10-08",
            "10-09","10-10","10-11","10-12","10-13","10-14","10-15","10-16","10-17","10-18",
            "10-19","10-20","10-21","10-22","10-23","10-24","10-25","10-26","10-27","zxc"};//X轴的标注
    int[] score= {74,22,18,79,20,74,20,74,42,90,74,42,90,
            50,42,90,33,10,74,22,18,79,20,74,22,18,78,20};//图表的数据
    private List<PointValue> mPointValues = new ArrayList<>();
    private List<AxisValue> mAxisXValues = new ArrayList<>();

    public LineChart(LineChartView lineChart) {
        this.lineChart = lineChart;
    }

    /**
     * 初始化LineChart
     */
    public void initLineChart() {

        Line line = new Line(mPointValues).setColor(Color.parseColor("#FFCD41"));  //折线的颜色
        List<Line> lines = new ArrayList<>();
        line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状为圆形
        line.setCubic(false);//曲线是否平滑
        line.setFilled(false);//不填充曲线的面积
        line.setHasLabels(true);//曲线的数据坐标加上备注
        line.setHasLines(true);//是否用直线显示
        line.setHasPoints(true);//是否显示圆点
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);


        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setName("日期");
        axisX.setTextSize(14);//设置字体大小
        axisX.setHasTiltedLabels(true);  //X轴下面坐标轴字体是斜的显示还是直的，true是斜的显示
        axisX.setTextColor(Color.parseColor("#D6D6D9"));//灰色

        axisX.setMaxLabelChars(7);
        axisX.setValues(mAxisXValues);
        data.setAxisXBottom(axisX); //x 轴在底部
        axisX.setHasLines(true); //x 轴分割线

        Axis axisY = new Axis();
        axisY.setName("流量/L");
        axisY.setTextSize(14);
        data.setAxisYLeft(axisY);  //Y轴设置在左边


        //设置支持缩放以及滑
        lineChart.setInteractive(true);
        lineChart.setZoomType(ZoomType.HORIZONTAL);  //缩放类型，水平
        lineChart.setMaxZoom((float) 3);//缩放比例
        lineChart.setLineChartData(data);
        lineChart.setVisibility(View.VISIBLE);
        Viewport v = new Viewport(lineChart.getMaximumViewport());
        v.left = 0;
        v.right= 7;
        lineChart.setCurrentViewport(v);
    }

    /**
     * X 轴的显示
     */
    public void getAxisXLables() {
        for (int i = 0; i < date.length; i++) {
            mAxisXValues.add(new AxisValue(i).setLabel(date[i]));
        }
    }
    /**
     * 图表中每个数据点的显示
     */
    public void getAxisPoints() {
        for (int i = 0; i < score.length; i++) {
            mPointValues.add(new PointValue(i, score[i]));
        }
    }
}
