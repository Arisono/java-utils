package rsa;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;


/**
 * RSA非对称加密算法安全编码组件
 */
public abstract class RSACoder {
    // 非对称加密密钥算法
    private static final String KEY_ALGORITHM = "RSA";
    // 数字签名 签名/验证算法
    private static final String SIGNATURE_ALGORRITHM = "SHA1withRSA";
    // 公钥
    private static final String PUBLIC_KEY = "RSAPublicKey";
    // 私钥
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    // RSA密钥长度,默认为1024,密钥长度必须是64的倍数,范围在521~65526位之间
    private static final int KEY_SIZE = 1024;

    /**
     * 私钥解密
     *
     * @param data 待解密数据
     * @param key  私钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    private static byte[] decryptByPrivateKey(byte[] data, byte[] key) throws Exception {
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     *
     * @param data       待解密数据
     * @param privateKey 私钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String privateKey) throws Exception {
        return decryptByPrivateKey(data, getKey(privateKey));
    }

    /**
     * 公钥解密
     *
     * @param data 待解密数据
     * @param key  公钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, byte[] key) throws Exception {
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 生成公钥
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥解密
     *
     * @param data      待解密数据
     * @param publicKey 公钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String publicKey) throws Exception {
        return decryptByPublicKey(data, getKey(publicKey));
    }

    /**
     * 公钥加密
     *
     * @param data 待加密数据
     * @param key  公钥
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] key) throws Exception {
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥加密
     *
     * @param data      待加密数据
     * @param publicKey 公钥
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
        return encryptByPublicKey(data, getKey(publicKey));
    }


    public static String encryptByPublicKey(String data, String publicKey) throws Exception {
        byte[] pubKey = RSAUtil.decodeBase64(publicKey);
        byte[] enSign = encryptByPublicKey(data.getBytes(), pubKey);
        return Base64.encodeBase64String(enSign);
    }

    /**
     * 私钥加密
     *
     * @param data 待加密数据
     * @param key  私钥
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] key) throws Exception {
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥加密
     *
     * @param data 待加密数据
     * @param key  私钥
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String key) throws Exception {
        return encryptByPrivateKey(data, getKey(key));
    }

    /**
     * 取得私钥
     *
     * @param keyMap 密钥Map
     * @return byte[] 私钥
     * @throws Exception
     */
    public static byte[] getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }

    /**
     * 取得公钥
     *
     * @param keyMap 密钥Map
     * @return byte[] 公钥
     * @throws Exception
     */
    public static byte[] getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }

    /**
     * 初始化密钥
     *
     * @return 密钥Map
     * @throws Exception
     */
    public static Map<String, Object> initKey() throws Exception {
        // 实例化实钥对生成器
        KeyPairGenerator keyPairGen = KeyPairGenerator
                .getInstance(KEY_ALGORITHM);
        // 初始化密钥对生成器
        keyPairGen.initialize(KEY_SIZE);
        // 生成密钥对
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 封装密钥
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    /**
     * 签名
     *
     * @param data       待签名数据
     * @param privateKey 私钥
     * @return byte[] 数字签名
     * @throws Exception
     */
    public static byte[] sign(byte[] data, byte[] privateKey) throws Exception {
        // 转接私钥材料
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
        // 实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取私钥对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORRITHM);
        // 初始化Signature
        signature.initSign(priKey);
        // 更新
        signature.update(data);
        // 签名
        return signature.sign();
    }

    /**
     * 公钥校验
     *
     * @param data      待校验数据
     * @param publicKey 公钥
     * @param sign      数字签名
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data, byte[] publicKey, byte[] sign) throws Exception {
        // 转接公钥材料
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
        // 实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 生成公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORRITHM);
        // 初始化Signature
        signature.initVerify(pubKey);
        // 更新
        signature.update(data);
        // 验证
        return signature.verify(sign);
    }

    /**
     * 私钥签名
     *
     * @param data 待签名数据
     * @param privateKey 私钥
     * @return String 十六进制签名字符串
     * @throws Exception
     */
    /*public static String sign(byte[] data, String privateKey) throws Exception {
		byte[] sign = sign(data, getKey(privateKey));
		return Hex.encodeHexString(sign);
	}*/

    /**
     * 公钥校验
     *
     * @param data      待验证数据
     * @param publicKey 公钥
     * @param sign      签名
     * @return boolean 成功返回true,失败返回false
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
        return verify(data, getKey(publicKey), Hex.decodeHex(sign.toCharArray()));
    }

    /**
     * 取得私钥十六进制表示形式
     *
     * @param keyMap 密钥Map
     * @return String 私钥十六进制字符串
     * @throws Exception
     */

    public static String getPrivateKeyString(Map<String, Object> keyMap) throws Exception {
        return Hex.encodeHexString(getPrivateKey(keyMap));
        // return AESTool.byteToHex(getPrivateKey(keyMap));
    }


    /**
     * 取得公钥十六进制表示形式
     *
     * @param keyMap 密钥Map
     * @return String 公钥十六进制字符串
     * @throws Exception
     */
    public static String getPublicKeyString(Map<String, Object> keyMap) throws Exception {
        return Hex.encodeHexString(getPublicKey(keyMap));
        // return AESTool.byteToHex(getPublicKey(keyMap));
    }

    /**
     * 获取密钥
     *
     * @param key 密钥
     * @return byte[] 密钥
     * @throws Exception
     */
    public static byte[] getKey(String key) throws Exception {
        return Base64.decodeBase64(key);
    }


    public static void main(String[] args) {
        try {
            Map<String, Object> keyMap = initKey();
            String publicKeyString = (String) keyMap.get("publicKeyString");
            String privateKeyString = (String) keyMap.get("privateKeyString");
            System.out.println("公钥:" + publicKeyString);
            System.out.println("私钥:" + privateKeyString);
            publicKeyString = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCChWF6a78lN/AgM/4rJTGNQqrydd3QsNryP3FFtB2wZoDE2XtCTwtsSuv21rFbtBRCsE37DOOs7eIylrW88A2u63s7/vXHLiTamCo5qEPwgFiOHkqGnX/R4QbO9sYIWG2XqQ1gc/Eo5wP/+gyoQE33I4LXscHdr4uKf6wHkam//QIDAQAB";
            privateKeyString = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIKFYXprvyU38CAz/islMY1CqvJ13dCw2vI/cUW0HbBmgMTZe0JPC2xK6/bWsVu0FEKwTfsM46zt4jKWtbzwDa7rezv+9ccuJNqYKjmoQ/CAWI4eSoadf9HhBs72xghYbZepDWBz8SjnA//6DKhATfcjgtexwd2vi4p/rAeRqb/9AgMBAAECgYAFXH04jhx35uhSKlCSbSCv8MEc3IKUA++6a6i3eEKP8GXxsA1EGAMcG6e9p+v5HFiItL0/RrRDcjIMaexlKmclbRLaLwUnTlUDyGQH1v+0eIljAH6osdsxXPbeWXVZZuPI5Ea++LT1OlIHxibkjFR8VsRYIvzv7sV7t312d+5ocQJBANL5ereUYVEqt2eUeUwBhqB5X00JmBcUSoTAEeTvR/yLFP5cR5IYGMuBo0p8TQd1BANTBJPpp7fCF7doA/8OQacCQQCeYFoEHXfKTsMy4pFI5yvZOoT8dbE74ABO8NYk4wg6rahRt0FBVOKHnAd2QJlMh3vBZ9iBZ1a1dwxdpTTj7T27AkAiswu/A/WZnvf5Xk8w9BNLc4r8JbbRHPJAsUKAL+bcH5f9Wfofij0Rw6myx4z3zAQz88SN+2EtdQvni4EUwyiDAkBWHYf0ot1G2MrUuVNMM76o8GPtLkV/jA4+3j9icTxBQ7m5LQ7Dald+az23c+qnLSgCgue7fSgtpZzIspLuuEoPAkEApAGW9oRyab8RRCDGwXIFlL8SuKqXfw8I65gSsZOXN2dF7hCHH1CwOClkr17qlM9cQzqUtNYFz03Db9GqdYnpaw==";

            // 待加密数据
            String data = "123456";
            // 公钥加密
            String encrypt = encryptByPublicKey(data, publicKeyString);
            // 私钥解密
            String decrypt = RSAUtil.decryptByPriKey(encrypt, privateKeyString);

            System.out.println("加密前:" + data);
            System.out.println("加密后:" + encrypt);
            System.out.println("解密后:" + decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
