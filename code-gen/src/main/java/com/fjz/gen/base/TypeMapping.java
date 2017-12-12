package com.fjz.gen.base;

import java.sql.SQLException;
import java.sql.Types;

public class TypeMapping {
	public static String getColumnClassName( int sqlType) throws SQLException {
        String className = String.class.getName();
        switch (sqlType) {
        case Types.NUMERIC:
        	  className = java.lang.Long.class.getName();
              break;
        case Types.DECIMAL:
            className = java.math.BigDecimal.class.getName();
            break;

        case Types.BIT:
            className = java.lang.Boolean.class.getName();
            break;

        case Types.TINYINT:
            className = java.lang.Byte.class.getName();
            break;

        case Types.SMALLINT:
            className = java.lang.Short.class.getName();
            break;

        case Types.INTEGER:
            className = java.lang.Integer.class.getName();
            break;

        case Types.BIGINT:
            className = java.lang.Long.class.getName();
            break;

        case Types.REAL:
            className = java.lang.Float.class.getName();
            break;

        case Types.FLOAT:
        case Types.DOUBLE:
            className = java.lang.Double.class.getName();
            break;
        case Types.BINARY:
        case Types.VARBINARY:
        case Types.LONGVARBINARY:
            className = "byte[]";
            break;

        case Types.DATE:
//            className = java.sql.Date.class.getName();
//            break;

        case Types.TIME:
//            className = java.sql.Time.class.getName();
//            break;

        case Types.TIMESTAMP:
//            className = java.sql.Timestamp.class.getName();
        	className=java.util.Date.class.getName();
            break;

        case Types.BLOB:
//            className = java.sql.Blob.class.getName();
        	 className = "byte[]";
            break;
        case Types.NCLOB:
        case Types.CLOB:
            className = java.lang.String.class.getName();
            break;
         default://默认给String类型
             className = java.lang.String.class.getName();
             break;
        }

        return className;
    }
}
