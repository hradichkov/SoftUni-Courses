package P01AccessWithJDBCExercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05ChangeTownNamesCasing {

    private final static String GET_ALL_TOWNS_BY_COUNTRY_NAME = "select name from towns where country = ?";
    private final static String UPDATE_TOWN_NAME = "update towns set name = upper(name) where country = ?";

    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSQLConnection();

        Scanner scanner = new Scanner(System.in);

        String countryName = scanner.nextLine();

        PreparedStatement statement = connection.prepareStatement(UPDATE_TOWN_NAME);
        statement.setString(1, countryName);

        int updatedCount = statement.executeUpdate();

        if (updatedCount == 0){
            System.out.println("No town names were affected.");
            return;
        }

        System.out.printf("%d town names were affected.%n", updatedCount);
        List<String> towns = new ArrayList<>();

        PreparedStatement selectAllTowns = connection.prepareStatement(GET_ALL_TOWNS_BY_COUNTRY_NAME);
        selectAllTowns.setString(1, countryName);

        ResultSet resultSet = selectAllTowns.executeQuery();

        while (resultSet.next()){
            towns.add(resultSet.getString("name"));
        }

        System.out.println(towns);
    }
}
