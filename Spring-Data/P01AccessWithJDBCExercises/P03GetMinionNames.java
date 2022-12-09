package P01AccessWithJDBCExercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P03GetMinionNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = Utils.getSQLConnection();

        PreparedStatement villainStatement = connection.prepareStatement(
                "select name from villains where id = ?");

        int villainId = Integer.parseInt(scanner.nextLine());

        villainStatement.setInt(1, villainId);

        ResultSet villainSet = villainStatement.executeQuery();

        if (!villainSet.next()) {
            System.out.println("No villain with ID 10 exists in the database.");
            connection.close();
            return;
        }

        String villainName = villainSet.getString("name");
        System.out.printf("Villain: %s%n", villainName);

        PreparedStatement minionStatement = connection.prepareStatement(
                "select name, age from minions as m" +
                        " join minions_villains as mv on  mv.minion_id = m.id \n" +
                        " where mv.villain_id = ?");

        minionStatement.setInt(1, villainId);
        ResultSet minionsSet = minionStatement.executeQuery();

        for (int i = 1; minionsSet.next(); i++) {
            String minionName = minionsSet.getString("name");
            int minionAge = minionsSet.getInt("age");

            System.out.printf("%d. %s %d%n", i, minionName, minionAge);
        }

        connection.close();
    }
}
