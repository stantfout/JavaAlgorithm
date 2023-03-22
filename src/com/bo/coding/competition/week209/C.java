package com.bo.coding.competition.week209;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int inPos= 0;//记录与站位点相同的观察点
        //计算所有点与站位点的角度
        for(List<Integer> point:points){
            if(point.get(1)==location.get(1)){
                if(point.get(0)==location.get(0)){
                    inPos++; continue;
                }
                angles.add(point.get(0)>location.get(0) ? 0D : 180D);
            }
            else if(point.get(0)==location.get(0))
                angles.add(point.get(1)>location.get(1) ? 90D : 270D);
            else {
                double tan = (point.get(1)-location.get(1))/(double)(point.get(0)-location.get(0));
                double ang = Math.toDegrees(Math.atan(tan));
                if(point.get(0)>location.get(0) && point.get(1)>location.get(1))
                    angles.add(ang);
                else if(point.get(0)>location.get(0) && point.get(1)<location.get(1))
                    angles.add(ang+360D);
                else angles.add(ang+180D);

            }
        }
        //排序
        angles.sort(Comparator.naturalOrder());
        int L=0, wsize=0, max=0, S=angles.size();
        //窗口大小wsize, 窗口范围 [L, i]
        OUTER: for(int i=0; i< S; i=(i+1)%S){
            //当窗口右边界来到i时，删除左边已经观察不到的点
            while ((angles.get(i)-angles.get(L)+360D)%360D > angle){
                L++;
                if(L==S) break OUTER;
                wsize--;
            }
            wsize++;
            if(wsize>=S) return wsize+inPos;
            max=Math.max(max, wsize);
        }
        return max+inPos;
    }
}
