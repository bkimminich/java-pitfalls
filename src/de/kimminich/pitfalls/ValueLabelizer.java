package de.kimminich.pitfalls;

import javax.annotation.Nullable;

public class ValueLabelizer {

    private static final Labelizer<ValueObject> instance = new Labelizer<ValueObject>() {
        @Override
        public String labelize(ValueObject o) {
            return o.getValue().toString();
        }
    };

    public static String labelize(ValueObject o) {
        return instance.labelize(o);
    }

    private static interface Labelizer<T> {
        String labelize(@Nullable T o);
    }
}
