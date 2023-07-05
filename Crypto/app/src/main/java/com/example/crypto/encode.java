package com.example.crypto;

import java.util.Arrays;

public class encode {
    public static String encryptRailFence(String text, int key)
    {

        char[][] rail = new char[key][text.length()];


        for (int i = 0; i < key; i++)
            Arrays.fill(rail[i], '\n');

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < text.length(); i++) {

            if (row == 0 || row == key - 1)
                dirDown = !dirDown;

            rail[row][col++] = text.charAt(i);

            if (dirDown)
                row++;
            else
                row--;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < key; i++)
            for (int j = 0; j < text.length(); j++)
                if (rail[i][j] != '\n')
                    result.append(rail[i][j]);

        return result.toString();
    }

    public static String EncryptScyTale(String s) {
        String encryptedString = "";
        for (int i = 0; i < s.length(); i++) {
            encryptedString += s.charAt(i);
            int temp = (int) (Math.random() * 126);
            char c = (char) temp;
            encryptedString += c;
            temp = (int) (Math.random() * 126);
            c = (char) temp;
            encryptedString += c;
        }
        return encryptedString;
    }


    public static String stringMonoEncryption(String s)
    {
        char normalChar[]
                = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z','A',
                'B','C','D','E','F','G','H','I','J','K','L',
                'M','N','O','P','Q','R','S','T','U','V','W',
                'X','Y','Z'};

        char codedChar[]
                = { 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'h',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i','O','P',
                'Q','R','S','T','U','V','W','X','Y','Z','A',
                'B','C','D','E','F','G','H','I','J','K','L',
                'M','N'};


        String encryptedString = "";
        for (int i = 0; i < s.length(); i++) {
            int k = 0;
            for (int j = 0; j < 52; j++) {

                if (s.charAt(i) == normalChar[j])
                {
                    encryptedString += codedChar[j];
                    k = 1;
                    break;
                }
            }
            if(k == 0)
            {
                encryptedString += s.charAt(i);
            }
        }


        return encryptedString;
    }

    public static String encryptCeaserData(String inputStr, int shiftKey)
    {
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        String encryptStr = "";

        for (int i = 0; i < inputStr.length(); i++)
        {
            int pos = ALPHABET.indexOf(inputStr.charAt(i));
            if((inputStr.charAt(i)>='A' && inputStr.charAt(i)<='Z') || (inputStr.charAt(i)>='a' && inputStr.charAt(i)<='z')){
                int encryptPos = (shiftKey + pos) % 52;
                char encryptChar = ALPHABET.charAt(encryptPos);
                encryptStr += encryptChar;
            }
            else{
                encryptStr+=inputStr.charAt(i);
                continue;
            }
        }


        return encryptStr;
    }
}
