package me.jtghawk137.langchat.mysql;

import me.jtghawk137.langchat.LangChat;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class MySQLSetterGetter
{
    MySQLConnection connection = LangChat.getInstance().getConnection();

    public boolean languageExists(UUID uuid, String language)
    {
        try
        {
            PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM " + connection.table + " WHERE uuid=? AND languages=?");
            statement.setString(1, uuid.toString());
            statement.setString(2, language);
            ResultSet results = statement.executeQuery();
            if (results.next())
            {
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public void addLanguage(Player player, UUID uuid, String language, String level)
    {
        try
        {
            if (!languageExists(uuid, language))
            {
                PreparedStatement statement = connection.getConnection().prepareStatement("INSERT INTO " + connection.table + " (uuid, languages, mlevel) VALUES (?, ?, ?)");
                statement.setString(1, uuid.toString());
                statement.setString(2, language);
                statement.setString(3, level);
                statement.executeUpdate();
                player.sendMessage("§f" + language + " §ahas been added with a proficiency of§f " + level + "§a!");
            } else
            {
                player.sendMessage("§cYou have already added that language.");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void removeLanguage(UUID uuid, String language)
    {
        try
        {
            PreparedStatement statement = connection.getConnection().prepareStatement(
                    "DELETE FROM " + connection.table + " WHERE uuid = ? AND languages = ?");
            statement.setString(1, uuid.toString());
            statement.setString(2, language);
            statement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void changeLanguage(UUID uuid, String language, String proficiency)
    {
        try
        {
            PreparedStatement statement = connection.getConnection().prepareStatement("UPDATE " + connection.table + " SET mlevel=? WHERE uuid=? AND languages=?");
            statement.setString(1, proficiency);
            statement.setString(2, uuid.toString());
            statement.setString(3, language);
            statement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Map<String, String> getLanguages(UUID uuid)
    {
        Map<String, String> langscontainer = new HashMap<>();
        Map<String, String> langs = new TreeMap<>((o1, o2) ->
        {
            int diff = -langscontainer.get(o1)
                    .compareTo(langscontainer.get(o2));
            return diff == 0 ? o1.compareTo(o2) : diff;
        });

        try
        {
            PreparedStatement stmt = connection.getConnection().prepareStatement("SELECT languages, mlevel FROM " + connection.table + " WHERE uuid=?");
            stmt.setString(1, uuid.toString());
            ResultSet results = stmt.executeQuery();
            while (results.next())
            {
                langscontainer.put(results.getString(1), results.getString(2));
                langs.put(results.getString(1), results.getString(2));
            }
            results.close();
            stmt.close();
        } catch (SQLException e)
        {
            System.out.println("Could not get language mastery data from DB");
            e.printStackTrace();
        }

        return langs;
    }
}
