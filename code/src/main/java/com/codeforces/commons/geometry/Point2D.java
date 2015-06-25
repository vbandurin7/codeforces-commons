package com.codeforces.commons.geometry;

import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.DoublePair;
import com.codeforces.commons.text.StringUtil;

import javax.annotation.Nonnull;

import static com.codeforces.commons.math.Math.hypot;
import static com.codeforces.commons.math.Math.sumSqr;

/**
 * @author Maxim Shipko (sladethe@gmail.com)
 *         Date: 22.07.13
 */
public class Point2D extends DoublePair {
    public static final double DEFAULT_EPSILON = 1.0E-6D;

    public Point2D(double x, double y) {
        super(x, y);
    }

    public Point2D(@Nonnull Point2D point) {
        super(point.getX(), point.getY());
    }

    public double getX() {
        return getFirst();
    }

    public void setX(double x) {
        setFirst(x);
    }

    public double getY() {
        return getSecond();
    }

    public void setY(double y) {
        setSecond(y);
    }

    public Point2D add(Vector2D vector) {
        setX(getX() + vector.getX());
        setY(getY() + vector.getY());
        return this;
    }

    public Point2D add(double x, double y) {
        setX(getX() + x);
        setY(getY() + y);
        return this;
    }

    public Point2D subtract(Vector2D vector) {
        setX(getX() - vector.getX());
        setY(getY() - vector.getY());
        return this;
    }

    public Point2D subtract(double x, double y) {
        setX(getX() - x);
        setY(getY() - y);
        return this;
    }

    public double getDistanceTo(@Nonnull Point2D point) {
        return hypot(getX() - point.getX(), getY() - point.getY());
    }

    public double getDistanceTo(double x, double y) {
        return hypot(getX() - x, getY() - y);
    }

    public double getSquaredDistanceTo(@Nonnull Point2D point) {
        return sumSqr(getX() - point.getX(), getY() - point.getY());
    }

    public double getSquaredDistanceTo(double x, double y) {
        return sumSqr(getX() - x, getY() - y);
    }

    @Nonnull
    public Point2D copy() {
        return new Point2D(this);
    }

    public boolean nearlyEquals(@Nonnull Point2D point, double epsilon) {
        return point != null
                && NumberUtil.nearlyEquals(getX(), point.getX(), epsilon)
                && NumberUtil.nearlyEquals(getY(), point.getY(), epsilon);
    }

    public boolean nearlyEquals(@Nonnull Point2D point) {
        return nearlyEquals(point, DEFAULT_EPSILON);
    }

    public boolean nearlyEquals(double x, double y, double epsilon) {
        return NumberUtil.nearlyEquals(getX(), x, epsilon)
                && NumberUtil.nearlyEquals(getY(), y, epsilon);
    }

    public boolean nearlyEquals(double x, double y) {
        return nearlyEquals(x, y, DEFAULT_EPSILON);
    }

    @Override
    public String toString() {
        return StringUtil.toString(this, false, "x", "y");
    }
}
