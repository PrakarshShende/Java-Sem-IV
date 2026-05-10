import java.sql.*;

public class DeleteStudent {

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
                            "delete from student where id=?"
                    );

            ps.setInt(1, 2);

            int i = ps.executeUpdate();

            if (i > 0) {

                System.out.println(
                        "Record Deleted Successfully");
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}