package me.jtghawk137.langchat.config;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class LanguageConfig
{

    private String name;
    private int id;
    private String vocabFile;
    private JSONParser parser;

    public LanguageConfig(String name)
    {
        this.name = name;
    }

    public void read()
    {
        parser = new JSONParser();
        try
        {
            JSONArray json = (JSONArray) parser.parse(new FileReader("test/resources/languages.json"));

            for (Object o : json)
            {
                JSONObject language = (JSONObject) o;
                if(language.get("name").toString().equalsIgnoreCase(name))
                {
                    this.name = language.get("name").toString();
                    this.id = Integer.parseInt(language.get("id").toString());
                    this.vocabFile = language.get("vocabfile").toString();
                }
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public String getVocabFile()
    {
        return vocabFile;
    }
}
