package org.embulk.output.jdbc.setter;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import org.embulk.spi.PageReader;
import org.embulk.spi.time.Timestamp;
import org.embulk.output.jdbc.JdbcColumn;
import org.embulk.output.jdbc.BatchInsert;

public class SqlTimeColumnSetter
        extends ColumnSetter
{
    public SqlTimeColumnSetter(BatchInsert batch, PageReader pageReader,
            JdbcColumn column)
    {
        super(batch, pageReader, column);
    }

    @Override
    protected void booleanValue(boolean v) throws IOException, SQLException
    {
        nullValue();
    }

    @Override
    protected void longValue(long v) throws IOException, SQLException
    {
        nullValue();
    }

    @Override
    protected void doubleValue(double v) throws IOException, SQLException
    {
        nullValue();
    }

    @Override
    protected void stringValue(String v) throws IOException, SQLException
    {
        nullValue();
    }

    @Override
    protected void timestampValue(Timestamp v) throws IOException, SQLException
    {
        Time t = new Time(v.toEpochMilli());
        batch.setSqlTime(t, getSqlType());
    }
}