package de.kimminich.pitfalls;

import javax.annotation.Nullable;

public class ValueLabelizerFixed {

    private static final Labelizer<ValueObject> instance = new Labelizer<ValueObject>() {
        @Override
        public String labelize(ValueObject o) {
            return o != null ? o.getValue().toString() : ""; // Handle case that
                                                             // object is
                                                             // declared
                                                             // @Nullable in
                                                             // interface method
        }
    };

    public static String labelize(ValueObject o) {
        return instance.labelize(o);
    }

    private static interface Labelizer<T> {
        String labelize(@Nullable T o);
    }
}
