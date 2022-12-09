package P01AccessWithJDBCExercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class P02GetVillainsNames {
    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSQLConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT name, COUNT(distinct minion_id) AS minions_count FROM villains AS v" +
                        " JOIN minions_villains AS mv" +
                        " ON mv.villain_id = v.id" +
                        " GROUP BY mv.villain_id" +
                        " HAVING minions_count > 15" +
                        " ORDER BY minions_count");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.print(resultSet.getString("name") + " " + resultSet.getInt("minions_count"));
        }
        connection.close();
    }
}

