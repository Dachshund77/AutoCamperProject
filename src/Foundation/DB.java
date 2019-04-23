package Foundation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DB {

    private static java.lang.String port;
    private static java.lang.String databaseName;
    private static java.lang.String userName;
    private static java.lang.String password;

    private static Connection conn;
    private static CallableStatement cstmt;
    private static ResultSet rs;
    private static ResultSetMetaData rsmd;

    private DB() {

    }

    static {
        Properties props = new Properties();
        java.lang.String fileName = "src/Foundation/db.properties";
        InputStream input;
        try {
            input = new FileInputStream(fileName);
            props.load(input);
            port = props.getProperty("port", "1433");
            databaseName = props.getProperty("databaseName");
            userName = props.getProperty("userName", "sa");
            password = props.getProperty("password");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Step 2
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    //TODO method to execute a single stored procedure
    public static ArrayList<Object[]> executeStoredProcedure(String sp, Object... param) {
        rsmd = null;
        ArrayList<Object[]> returnArrayList = new ArrayList<>();
        try {
            // Preparing metaData
            ArrayList<ProcedureMetaData> metaDataArray = getSPMetaData(sp);
            //Setting callable statement
            cstmt = conn.prepareCall(buildProcedureCall(sp, metaDataArray.size()));
            //Build parameters
            for (int i = 0; i < metaDataArray.size(); i++) {
                ProcedureMetaData tempMetaData = metaDataArray.get(i);
                setCallParameter(tempMetaData.getPosition(), tempMetaData.getDataType(), param[i]);
            }
            //Getting results
            rs = cstmt.executeQuery();
            rsmd = rs.getMetaData();
            Integer noOfColumns = rsmd.getColumnCount();
            // return values
            while (rs.next()) {
                Object[] tempArray = new Object[noOfColumns];
                for (int i = 0; i < tempArray.length; i++) {
                    tempArray[i] = rs.getObject(i + 1);
                }
                returnArrayList.add(tempArray);
            }
            // cleaning up
            cstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnArrayList;
    }

    //TODO method to execute batch stored procedure + Commit method

    private static ArrayList<ProcedureMetaData> getSPMetaData(String sp) {
        ArrayList<ProcedureMetaData> returnArrayList = new ArrayList<>();
        try {
            //Establishing call
            cstmt = conn.prepareCall("{call sp_GetSPMetaData(?)}");
            cstmt.setString(1, sp);
            rs = cstmt.executeQuery();
            // Getting the Metadata
            while (rs.next()) {
                int position = (int) rs.getObject("ORDINAL_POSITION");
                java.lang.String type = (java.lang.String) rs.getObject("DATA_TYPE");
                ProcedureMetaData tempMetaData = new ProcedureMetaData(position, type);
                returnArrayList.add(tempMetaData);
            }
            // Cleaning up
            cstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnArrayList;
    }

    private static java.lang.String buildProcedureCall(String sp, int parameters) { //TODO yeah there probably a bug here
        StringBuilder builder = new StringBuilder();
        builder.append("{call ");
        builder.append(sp);
        if (parameters > 0) {
            builder.append(" (");
            for (int questionMarks = parameters; questionMarks != 0; questionMarks--) {
                builder.append("?");
                if (questionMarks > 1) {
                    builder.append(",");
                }
            }
            builder.append(")");
        }
        builder.append("}");
        return builder.toString();
    }

    private static void setCallParameter(int index, String dataType, Object dataValue) {
        try {
            switch (dataType) {
                case "int":
                    cstmt.setInt(index, (int) dataValue);
                    break;
                case "varchar":
                case "nvarchar":
                    cstmt.setString(index, (String) dataValue);
                    break;
                case "numeric":
                    cstmt.setBigDecimal(index, (BigDecimal) dataValue);
                    break;
                case "date":
                    cstmt.setDate(index, (Date) dataValue);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:" + port + ";databaseName=" + databaseName, userName, password);
        } catch (SQLException e) { //TODO error handling could be improved in this class in genneral
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            if (cstmt != null) {
                cstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSetMetaData getRsmd() {
        return rsmd;
    }
}
