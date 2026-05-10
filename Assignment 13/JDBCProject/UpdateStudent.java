import java.sql.*;

public class UpdateStudent {

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

            PreparedStatement ps =
                    con.prepareStatement(
                            "update student set marks=? where id=?"
                    );

            ps.setInt(1, 95);
            ps.setInt(2, 1);

            int i = ps.executeUpdate();

            if (i > 0) {

                System.out.println(
                        "Record Updated Successfully");
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}