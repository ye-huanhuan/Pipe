package com.example.yhh.firstest;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;

/**
 * Created by yhh on 17-10-11.
 */

public class ColumChart {

    private ColumnChartView columnChartView = null; //柱状图

    public ColumChart(ColumnChartView columnChartView) {
        this.columnChartView = columnChartView;
    }

    public void generateDefaultData(){
        int numColumns = 8;
        ColumnChartData columnChartData;
        List<Column> columns = new ArrayList<>();   //使用容器来装柱子


        //设置每一个柱子
        for(int i=0;i<numColumns;i++){

            List<SubcolumnValue> values = new ArrayList<>();  //使用容器来装每个柱子中的小柱子
            //设置每一个小柱子
            for (int j=0; j<3; j++) {
                values.add(new SubcolumnValue((float) Math.random() * 90f + 5, ChartUtils.pickColor()));  //随机生成5-95的数
            }
            //初始化Column
            Column column = new Column(values);
            column.setHasLabels(true);
            column.setHasLabelsOnlyForSelected(true);
            columns.add(column);

        }

        //给表格添加写好数据的柱子
        columnChartData = new ColumnChartData(columns);

        //设置坐标轴
        Axis axisBootom = new Axis();
        Axis axisLeft = new Axis();
        axisBootom.setName("日期");
        axisLeft.setName("流量/L");

        List<AxisValue> axisValuess=new ArrayList<>();
        for(int i=0;i<numColumns;i++){
            axisValuess.add(new AxisValue(i).setLabel("第" + i + "天"));
        }
        axisBootom.setValues(axisValuess);

        columnChartData.setAxisXBottom(axisBootom);
        columnChartData.setAxisYLeft(axisLeft);

        //设置选中变大
        columnChartView.setValueSelectionEnabled(true);
        //给画表格的View添加要画的表格
        columnChartView.setColumnChartData(columnChartData);

    }
}
