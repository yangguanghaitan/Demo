package java8;

public class TypeInference {
    public static class Value<T> {

        public static  <T> T defaultValue() {
            return null;
        }

        public T getOrDefault( T value, T defaultValue ) {
            return ( value != null ) ? value : defaultValue;
        }
    }

    public static void main(String[] args) {
        final Value< String > value = new Value<>();
        value.getOrDefault( "22", Value.defaultValue() );
    }
}
