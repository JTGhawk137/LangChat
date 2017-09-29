package me.jtghawk137.test;

import me.jtghawk137.langchat.config.LanguageConfig;

public class JsonTest
{

    public static void main(String[] args)
    {
        LanguageConfig languageConfig = new LanguageConfig("Spanish");
        languageConfig.read();
        System.out.println(languageConfig.getId());
    }
}
