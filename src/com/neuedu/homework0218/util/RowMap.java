package com.neuedu.homework0218.util;

import java.sql.ResultSet;

public interface RowMap<T> {
    public T rowMaping(ResultSet rs);
}
