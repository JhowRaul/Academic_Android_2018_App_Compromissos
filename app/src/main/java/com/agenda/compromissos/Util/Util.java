package com.agenda.compromissos.Util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String toMD5(String data){

        MessageDigest md5 = null;

        try {

            md5 = MessageDigest.getInstance("MD5");

            md5.update(StandardCharsets.UTF_8.encode(data));

            return String.format("%032x", new BigInteger(1, md5.digest()));

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

        }

        return null;

    }

    public static Date toDate (String data) throws Exception {
        return new SimpleDateFormat("dd/MM/yyyy").parse(data);
    }

    public static String toString (Date data) throws Exception {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

}
