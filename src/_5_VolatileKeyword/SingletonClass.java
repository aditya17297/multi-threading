package _5_VolatileKeyword;

public class SingletonClass {

    /**
     * 1. Static is used so it can be accessed in static method.
     * 2. volatile is used to avoid threads reading the value from local cache.
     */
    private static volatile SingletonClass object = null;

    private SingletonClass() {

    }

    /**
     * 1. Static method is used so caller can call the method without making the object
     * 2. Double Locking is used for best optimisation
     * @return
     */
    public static SingletonClass getInstance() {
        if (object == null) {
            synchronized (SingletonClass.class) {
                if (object == null) {
                    object = new SingletonClass();
                }
            }
        }
        return object;
    }

}
