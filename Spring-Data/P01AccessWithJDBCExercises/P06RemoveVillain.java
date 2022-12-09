package P01AccessWithJDBCExercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P06RemoveVillain {
    private final static String GET_VILLAIN_BY_ID = "select name from villains where id = ?";
    private final static String GET_MINION_COUNT_BY_VILLAIN_ID = "select count(minion_id) as m_count from minions_villains where villain_id = ?";
    private final static String DELETE_MINIONS_VILLAINS_BY_VILLAIN_ID = "delete from minions_villains where villain_id = ?";
    private final static String DELETE_VILLAIN_BY_ID = "delete from villains where id = ?";
    private final static String COLUMN_LABEL_MINION_COUNT = "m_count";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = Utils.getSQLConnection();

        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement statement = connection.prepareStatement(GET_VILLAIN_BY_ID);
        statement.setInt(1, villainId);
        ResultSet villainSet = statement.executeQuery();

        if (!villainSet.next()) {
            System.out.println("No such villain was found");
            return;
        }

        String villainName = villainSet.getString("name");

        PreparedStatement selectAllMinions = connection.prepareStatement(GET_MINION_COUNT_BY_VILLAIN_ID);
        selectAllMinions.setInt(1, villainId);

        ResultSet countOfMinionsSet = selectAllMinions.executeQuery();
        countOfMinionsSet.next();

        int countOfDeletedMinions = countOfMinionsSet.getInt(COLUMN_LABEL_MINION_COUNT);

        connection.setAutoCommit(false);

        try (PreparedStatement deleteMinionStatement = connection.prepareStatement(DELETE_MINIONS_VILLAINS_BY_VILLAIN_ID);
             PreparedStatement deleteVillainStatement = connection.prepareStatement(DELETE_VILLAIN_BY_ID)) {

            deleteMinionStatement.setInt(1, villainId);
            deleteMinionStatement.executeUpdate();

            deleteVillainStatement.setInt(1, villainId);
            deleteVillainStatement.executeUpdate();

            connection.commit();

            System.out.printf("%s was deleted%n", villainName);
            System.out.printf("%d minions released", countOfDeletedMinions);

        } catch (SQLException e) {
            e.printStackTrace();

            connection.rollback();
        }
        connection.close();
    }
}
