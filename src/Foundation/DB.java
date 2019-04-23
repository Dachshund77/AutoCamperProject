package Foundation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * The Main access point for Database interaction. This Class will mostly execute stored procedure.
 * Note that it is the callers responsibility to call {@link DB#connect()} and {@link DB#disconnect()}.
 * Any Calling method should be encapsulated in a try catch block that has afinallyy clause to disconnect.
 */
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

    /**
     * Method that will execute a stored procedure and return the result.
     * Note that it is the callers responsibility to provide the correct amount of parameters.
     * @param sp String with the name of the Stored Procedure
     * @param param Variable parameter for the Procedure
     * @return ArrayList of Object arrays.
     */
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


    /**
     * Hardcoded execution of the sp_GetSPMetaData.
     * This method is used to determine what the parameter should be cast set to.
     * @param sp The Stored procedure we want to get Meta Data for
     * @return ArrayList of ProcedureMetaData
     * @see ProcedureMetaData
     */
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

    /**
     * Helper method that will construct the String for a callable statement.
     * @param sp The name of the Stored procedure
     * @param parameters Number of Parameters for the Stored procedure
     * @return String with the Callable statement
     */
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

    /**
     * Helper method to set the callable statement values.
     * @param index Index of callable statment Parameter
     * @param dataType Type of Data at this Parameter
     * @param dataValue The Object value provided from the application
     */
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

    /**
     * Method to establish a connection to the Database.
     * Note that this must be called before running any other methods from this class.
     */
    public static void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:" + port + ";databaseName=" + databaseName, userName, password);
        } catch (SQLException e) { //TODO error handling could be improved in this class in genneral
            e.printStackTrace();
        }
    }

    /**
     * Method to close connection to the Database.
     */
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
