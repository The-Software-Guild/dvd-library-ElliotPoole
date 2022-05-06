package dvdroster.ui;

import java.util.Date;

public interface userIO {
    void print(String string);

    void print(Date date);

    String next();

    double getDouble();

    //double getDouble(String prompt, double min, double max);

    float getFloat();

    //float getFloat(String prompt, float min, float max);

    int getInt();

    int getInt(int min, int max);

    long getLong();

    //long getLong(String prompt, long min, long max);

    String getString();

    Date getDate();
}
