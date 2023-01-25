package klasy;

import java.sql.*;
import java.util.Scanner;

class Terminal {
    Scanner skaner = new Scanner(System.in);
    String login, password;
    String status;

    private boolean connect(String login, String password) throws SQLException {
        Connection connection;
        int x = 0;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/jsos",
                    "kontrol", "kontrol1!"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (PreparedStatement statement = connection.prepareStatement("""
            SELECT COUNT(*)
            FROM Uzytkownicy
            WHERE id = ? AND haslo = ?;
        """)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                x = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(x == 1) {
            try (PreparedStatement statement = connection.prepareStatement("""
            SELECT status
            FROM Statusy AS S
            JOIN Uzytkownik_Status AS US ON S.id=US.status_id
            JOIN Uzytkownicy AS U ON US.uzytkownik_id=U.id
            WHERE U.id = ?;
        """)) {
                statement.setString(1, login);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    status = resultSet.getString(1);
                }
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            connection.close();
            return true;
        }
        return false;
    }
    void start() throws SQLException {
        do {
            System.out.println("Witaj w jsos");
            System.out.println("------------------");
            System.out.println("Login: ");
            login = skaner.nextLine();
            System.out.println("Haslo: ");
            password = skaner.nextLine();
        } while (!connect(login, password));

        switch(status) {
            case "student":
                student();
                break;
            case "wykladowca":
                wykladowca();
                break;
            case "admin":
                admin();
                break;
            default:
                System.out.println("Nieobslugiwany status");
        }
    }

    void student() throws SQLException {
        Connection connection;
        String odp;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/jsos",
                    "student", "student1!"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        do {
            System.out.println("Co chcesz zrobic?\n1. Wyswietl oceny\n2. Wyswietl srednia\n3. zakoncz\nOdp: ");
            odp = skaner.nextLine();
            if(odp.compareTo("1") == 0) {
                System.out.println("Podaj przedmiot: ");
                odp = skaner.nextLine();
                try (PreparedStatement statement = connection.prepareStatement("""
                CALL Wyswietl_Oceny(?, ?);
            """)) {
                    statement.setString(1, login);
                    statement.setString(2, odp);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        System.out.print(resultSet.getInt(1) + "  ");
                        System.out.print(resultSet.getString(2) + "  ");
                        System.out.print(resultSet.getString(3) + "  ");
                        System.out.print(resultSet.getString(4) + "  ");
                        System.out.print("\n");
                    }
                    System.out.print("\n");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(odp.compareTo("2") == 0) {
                System.out.println("Podaj przedmiot: ");
                odp = skaner.nextLine();
                try (PreparedStatement statement = connection.prepareStatement("""
                CALL Wyswietl_Srednia(?, ?);
            """)) {
                    statement.setString(1, login);
                    statement.setString(2, odp);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        System.out.print(resultSet.getFloat(1) + "  ");
                        System.out.print(resultSet.getString(2) + "  ");
                        System.out.print("\n");
                    }
                    System.out.print("\n");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } while(odp != "3");
        connection.close();
    }

    void wykladowca() throws SQLException {
        Connection connection;
        String odp;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/jsos",
                    "wykladowca", "wykladowca1!"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        do {
            System.out.println("Co chcesz zrobic?\n1. Wyswietl oceny studenta\n2. Wyswietl srednia studenta\n3. Dodaj ocene\n4. Usun ocene\n5. Zakoncz\nOdp: ");
            odp = skaner.nextLine();
            if(odp.compareTo("1") == 0) {
                System.out.println("Podaj przedmiot: ");
                odp = skaner.nextLine();
                System.out.println("Podaj id studenta: ");
                String id_studenta = skaner.nextLine();
                try (PreparedStatement statement = connection.prepareStatement("""
                CALL Wyswietl_Oceny(?, ?);
            """)) {
                    statement.setString(1, id_studenta);
                    statement.setString(2, odp);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        System.out.print(resultSet.getInt(1) + "  ");
                        System.out.print(resultSet.getString(2) + "  ");
                        System.out.print(resultSet.getString(3) + "  ");
                        System.out.print("\n");
                    }
                    System.out.print("\n");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(odp.compareTo("2") == 0) {
                System.out.println("Podaj przedmiot: ");
                odp = skaner.nextLine();
                System.out.println("Podaj id studenta: ");
                String id_studenta = skaner.nextLine();
                try (PreparedStatement statement = connection.prepareStatement("""
                CALL Wyswietl_Srednia(?, ?);
            """)) {
                    statement.setString(1, id_studenta);
                    statement.setString(2, odp);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        System.out.print(resultSet.getFloat(1) + "  ");
                        System.out.print(resultSet.getString(2) + "  ");
                        System.out.print("\n");
                    }
                    System.out.print("\n");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(odp.compareTo("3") == 0) {
                System.out.println("Podaj ocene: ");
                int ocena = Integer.parseInt(skaner.nextLine());
                System.out.println("Podaj przedmiot: ");
                odp = skaner.nextLine();
                System.out.println("Podaj opis oceny: ");
                String opis = skaner.nextLine();
                System.out.println("Podaj id studenta: ");
                int id_studenta = Integer.parseInt(skaner.nextLine());
                try (PreparedStatement statement = connection.prepareStatement("""
                CALL Dodaj_Ocene(?, ?, ?, ?, ?);
            """)) {
                    statement.setInt(1, ocena);
                    statement.setString(2, odp);
                    statement.setString(3, opis);
                    statement.setInt(4, id_studenta);
                    statement.setInt(5, Integer.parseInt(login));
                    ResultSet resultSet = statement.executeQuery();

                    System.out.print("Done!\n");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(odp.compareTo("4") == 0) {
                System.out.println("Podaj id oceny: ");
                int id_oceny = Integer.parseInt(skaner.nextLine());
                try (PreparedStatement statement = connection.prepareStatement("""
                CALL Dodaj_Ocene(?, ?);
            """)) {
                    statement.setInt(1, id_oceny);
                    statement.setInt(2, Integer.parseInt(login));
                    ResultSet resultSet = statement.executeQuery();

                    System.out.print("Done!\n");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } while(odp.compareTo("5") != 0);
        connection.close();
    }

    void admin() throws SQLException {
        Connection connection;
        String odp;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/jsos",
                    "wykladowca", "wykladowca1!"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        do {
            System.out.println("Co chcesz zrobic?\n1. Wykonaj Komende\n2. Zakoncz");
            odp = skaner.nextLine();
            if(odp.compareTo("1") == 0) {
                System.out.println("Podaj komende:");
                odp = skaner.nextLine();

                try (PreparedStatement statement = connection.prepareStatement("""
                ?
                """)) {
                    statement.setString(1, odp);
                    ResultSet resultSet = statement.executeQuery();
                }
            }
        } while(odp.compareTo("2") != 0);

        connection.close();
    }
}
