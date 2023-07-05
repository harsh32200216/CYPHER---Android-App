package com.example.crypto;

import java.util.Arrays;

public class decode {
    public static String decryptRailFence(String cipher,int key)
    {
        char[][] rail = new char[key][cipher.length()];
        for (int i = 0; i < key; i++)
            Arrays.fill(rail[i], '\n');

        boolean dirDown = true;

        int row = 0, col = 0;

        for (int i = 0; i < cipher.length(); i++) {
            if (row == 0)
                dirDown = true;
            if (row == key - 1)
                dirDown = false;

            rail[row][col++] = '*';

            if (dirDown)
                row++;
            else
                row--;
        }

        int index = 0;
        for (int i = 0; i < key; i++)
            for (int j = 0; j < cipher.length(); j++)
                if (rail[i][j] == '*'
                        && index < cipher.length())
                    rail[i][j] = cipher.charAt(index++);

        StringBuilder result = new StringBuilder();

        row = 0;
        col = 0;
        for (int i = 0; i < cipher.length(); i++) {
            if (row == 0)
                dirDown = true;
            if (row == key - 1)
                dirDown = false;

            if (rail[row][col] != '*')
                result.append(rail[row][col++]);

            if (dirDown)
                row++;
            else
                row--;
        }
        return result.toString();
    }

    public static String DecryptScyTale(String s) {
        String decryptedString = "";
        for (int i = 0; i < s.length(); i++) {
            if (i % 3 == 0) {
                decryptedString += s.charAt(i);
            }
        }
        return decryptedString;
    }

    public static String stringMonoDecryption(String s)
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

        String decryptedString = "";

        for (int i = 0; i < s.length(); i++)
        {
            int k = 0;
            for (int j = 0; j <52; j++) {
                if (s.charAt(i) == codedChar[j])
                {
                    decryptedString += normalChar[j];
                    k = 1;
                    break;
                }
            }
            if(k == 0)
            {
                decryptedString += s.charAt(i);
            }
        }

        return decryptedString;
    }

    public static String decryptCeaserData(String inputStr, int shiftKey)
    {
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String decryptStr = "";


        for (int i = 0; i < inputStr.length(); i++)
        {
            int pos = ALPHABET.indexOf(inputStr.charAt(i));
            if((inputStr.charAt(i)>='A' && inputStr.charAt(i)<='Z') || (inputStr.charAt(i)>='a' && inputStr.charAt(i)<='z')){
                int decryptPos = (pos - shiftKey) % 52;
                if (decryptPos < 0){
                    decryptPos = ALPHABET.length() + decryptPos;
                }
                char decryptChar = ALPHABET.charAt(decryptPos);
                decryptStr += decryptChar;
            }
            else{
                decryptStr+=inputStr.charAt(i);
                continue;
            }
        }
        return decryptStr;
    }
}
