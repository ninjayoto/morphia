package dev.morphia.geo;

/**
 * Creates Point instances representing a <a href="http://docs.mongodb.org/manual/apps/geospatial-indexes/#geojson-objects">GeoJSON</a>
 * point type. The advantage of using the builder is to reduce confusion of the order of the latitude and longitude double values.
 * <p/>
 * Supported by server versions 2.4 and above.
 *
 * @see dev.morphia.geo.Point
 * @deprecated use the driver-provided types instead
 */
@SuppressWarnings("removal")
@Deprecated(since = "2.0", forRemoval = true)
public class PointBuilder {
    private double longitude;
    private double latitude;

    /**
     * Convenience method to return a new PointBuilder.
     *
     * @return a new instance of PointBuilder.
     */
    public static PointBuilder pointBuilder() {
        return new PointBuilder();
    }

    /**
     * Creates an immutable point
     *
     * @return the Point with the specifications from this builder.
     */
    public Point build() {
        return new Point(latitude, longitude);
    }

    /**
     * Add a latitude.
     *
     * @param latitude the latitude of the point
     * @return this PointBuilder
     */
    public PointBuilder latitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * Add a longitude.
     *
     * @param longitude the longitude of the point
     * @return this PointBuilder
     */
    public PointBuilder longitude(double longitude) {
        this.longitude = longitude;
        return this;
    }
}
