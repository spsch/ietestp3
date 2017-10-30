package cz.neoris.ietestp3.basic;

import java.util.UUID;

public class RandomGen {

    public static String GenerateStr() {
        /*char [] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);*/
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
