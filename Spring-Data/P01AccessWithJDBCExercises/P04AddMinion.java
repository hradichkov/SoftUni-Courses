package P01AccessWithJDBCExercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P04AddMinion {

    private final static String GET_TOWN_BY_NAME = "select id from towns where name = ?";
    private final static String INSERT_INTO_TOWNS = "insert into towns (name) values (?)";
    private final static String TOWN_ADDED_FORMAT = "Town %s was added to the database.%n";

    private final static String GET_VILLAIN_BY_NAME = "select id from villains where name = ?";
    private final static String INSERT_VILLAIN = "insert into villains (name, evilness_factor) values (?, ?)";
    private final static String VILLAIN_ADDED_FORMAT = "Villain %s was added to the database.%n";

    private final static String INSERT_INTO_MINIONS = "insert into minions (name, age, town_id) values (?,?,?)";
    private final static String GET_LAST_MINION = "select id from minions order by id desc limit 1";

    private final static String INSERT_INTO_MINIONS_VILLAINS = "insert into minions_villains (minion_id,villain_id) values (?,?)";

    private final static String ID_COLUMN = "id";
    private final static String RESULT_FORMAT = "Successfully added %s to be minion of %s%n";


    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSQLConnection();

        Scanner scanner = new Scanner(System.in);

        String[] minionInfo = scanner.nextLine().split(" ");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];

        String[] villainInfo = scanner.nextLine().split(" ");
        String villainName = villainInfo[1];

        PreparedStatement townStatement = connection.prepareStatement(GET_TOWN_BY_NAME);
        townStatement.setString(1, minionTown);
        ResultSet townSet = townStatement.executeQuery();

        int townId;

        if (!townSet.next()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_TOWNS);
            statement.setString(1, minionTown);

            statement.executeUpdate();

            ResultSet newTownSet = townStatement.executeQuery();
            newTownSet.next();

            System.out.printf(TOWN_ADDED_FORMAT, minionTown);

            townId = newTownSet.getInt(ID_COLUMN);
        } else {
            townId = townSet.getInt(ID_COLUMN);
        }


        PreparedStatement villainStatement = connection.prepareStatement(GET_VILLAIN_BY_NAME);
        villainStatement.setString(1, villainName);
        ResultSet villainSet = villainStatement.executeQuery();

        int villainId;

        if (!villainSet.next()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_VILLAIN);
            statement.setString(1, villainName);
            statement.setString(2,"evil");

            statement.executeUpdate();

            ResultSet newVillainSet = villainStatement.executeQuery();
            newVillainSet.next();

            System.out.printf(VILLAIN_ADDED_FORMAT, villainName);

            villainId = newVillainSet.getInt(ID_COLUMN);
        } else {
            villainId = villainSet.getInt(ID_COLUMN);
        }

        PreparedStatement insertIntoMinionsStatement = connection.prepareStatement(INSERT_INTO_MINIONS);
        insertIntoMinionsStatement.setString(1, minionName);
        insertIntoMinionsStatement.setInt(2, minionAge);
        insertIntoMinionsStatement.setInt(3, townId);

        insertIntoMinionsStatement.executeUpdate();

        PreparedStatement lastMinion = connection.prepareStatement(GET_LAST_MINION);
        ResultSet resultSet = lastMinion.executeQuery();
        resultSet.next();

        int lastMinionId = resultSet.getInt(ID_COLUMN);

        PreparedStatement minionsVillainsStatement = connection.prepareStatement(INSERT_INTO_MINIONS_VILLAINS);
        minionsVillainsStatement.setInt(1, lastMinionId);
        minionsVillainsStatement.setInt(2, villainId);

        System.out.printf(RESULT_FORMAT, minionName, villainName);
        connection.close();
    }
}
