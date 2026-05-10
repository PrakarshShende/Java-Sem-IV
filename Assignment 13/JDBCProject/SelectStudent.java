import java.sql.*;

public class SelectStudent {

    public static void main(String[] args) {

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/college",
                            "root",
                            "root"
                    );

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "select * from student"
                    );

            System.out.println(
                    "ID\tNAME\tMARKS");

            while (rs.next()) {

                System.out.println(
                        rs.getInt(1) + "\t"
                                + rs.getString(2) + "\t"
                                + rs.getInt(3)
                );
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}