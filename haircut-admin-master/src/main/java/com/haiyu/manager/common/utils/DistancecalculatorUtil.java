package com.haiyu.manager.common.utils;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GlobalCoordinates;

public class DistancecalculatorUtil {

    public double getSphereDistanceMeter(double sourceLatitude,double sourceLongitude,double targetLatitude,double targetLongitude){
        GlobalCoordinates source = new GlobalCoordinates(sourceLatitude, sourceLongitude);
        GlobalCoordinates target = new GlobalCoordinates(targetLatitude, targetLongitude);
        return getDistanceMeter(source, target);
    }

    private double getDistanceMeter(GlobalCoordinates gpsFrom, GlobalCoordinates gpsTo) {
        //创建GeodeticCalculator，调用计算方法，传入坐标系、经纬度用于计算距离
        GeodeticCurve geoCurve = new GeodeticCalculator().calculateGeodeticCurve(Ellipsoid.Sphere, gpsFrom, gpsTo);
        return geoCurve.getEllipsoidalDistance();
    }
}
