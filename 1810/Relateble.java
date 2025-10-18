public interface Relateble {

    /**
     * Compares this instance with another object of the same type.
     *
     * @param other another relatable instance to compare against
     * @return a positive number if this object is larger, 0 if they are equal,
     *         and a negative number if this object is smaller
     */
    int isLargerThan(Relateble other);

    /**
     * Convenience check to see whether this instance is smaller than the other one.
     *
     * @param other another relatable instance to compare against
     * @return true if this object is smaller than the other, false otherwise
     */
    default boolean isSmallerThan(Relateble other) {
        return isLargerThan(other) < 0;
    }

    /**
     * Convenience check to see whether this instance has the same "size" as the other one.
     *
     * @param other another relatable instance to compare against
     * @return true if both instances are considered equal in size, false otherwise
     */
    default boolean isEqualTo(Relateble other) {
        return isLargerThan(other) == 0;
    }

    /**
     * Convenience check to see whether this instance is larger than the other one.
     *
     * @param other another relatable instance to compare against
     * @return true if this object is larger than the other, false otherwise
     */
    default boolean isGreaterThan(Relateble other) {
        return isLargerThan(other) > 0;
    }

    /**
     * Selects the larger instance between two relatable objects.
     *
     * @param first  the first relatable instance
     * @param second the second relatable instance
     * @return the larger of the two instances; if they are equal, the first is returned
     */
    static Relateble max(Relateble first, Relateble second) {
        return first.isLargerThan(second) >= 0 ? first : second;
    }
}
