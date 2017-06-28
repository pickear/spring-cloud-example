package com.weasel.springcloud.sleuth.stream.zipkin.server;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;

/**
 * Created by dell on 2017/3/16.
 */
public class JasyptTest {

    @Test
    public void encode(){
        StandardPBEStringEncryptor spe = new StandardPBEStringEncryptor();
        spe.setPassword("666");
       /* spe.setAlgorithm("PBEWithMD5AndDES");*/
        String encrype = spe.encrypt("5805703");
        System.out.println(encrype);
    }
}
