package me.jtghawk137.langchat.mysql;

import me.jtghawk137.langchat.config.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection
{
    public String host, database, username, password, table;
    public int port;
    private Connection connection;

    public void mysqlSetup()
    {
        host = FileManager.get("mysql.yml").getString("host");
        port = FileManager.get("mysql.yml").getInt("port");
        database = FileManager.get("mysql.yml").getString("database");
        username = FileManager.get("mysql.yml").getString("username");
        password = FileManager.get("mysql.yml").getString("password");
        table = FileManager.get("mysql.yml").getString("table");

        try
        {

            synchronized (this)
            {
                if (getConnection() != null && !getConnection().isClosed())
                {
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":"
                        + this.port + "/" + this.database, this.username, this.password));

                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL CONNECTED");

                connection.createStatement().executeUpdate(
                        "CREATE TABLE IF NOT EXISTS " + table + " (" +
                                "uuid VARCHAR(36)," +
                                "languages VARCHAR(255)," +
                                "llevel VARCHAR(255)," +
                                "PRIMARY KEY (uuid, languages));");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }


    public Connection getConnection()
    {
        return connection;
    }

    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }
}