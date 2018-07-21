package ashura.project.ashura;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSA {
	private String pri,pub;

	RSA(String pri, String pub) throws GeneralSecurityException, IOException {
		super();
		this.pri = pri;
		this.pub = pub;
		java.io.File f1=new java.io.File(pri),f2=new java.io.File(pub);
		if(!f1.exists()||!f2.exists())buatKunci();
	}

	private void buatKunci() throws GeneralSecurityException, IOException {
		java.security.KeyPairGenerator kpg=java.security.KeyPairGenerator.getInstance("RSA");
		kpg.initialize(2101);
		java.security.KeyPair kp=kpg.generateKeyPair();
		savePri(kp.getPrivate());
		savePub(kp.getPublic());
	}

	private void savePub(PublicKey key) throws IOException {
		java.io.File f=new java.io.File(pub);
		if(!f.getParentFile().exists())f.getParentFile().mkdirs();
		if(f.exists())f.delete();
		java.io.FileOutputStream fo=new java.io.FileOutputStream(f);
		java.io.ObjectOutputStream o=new java.io.ObjectOutputStream(fo);
		o.writeObject(key);
		o.close();
		fo.close();
	}

	private void savePri(PrivateKey key) throws IOException {
		java.io.File f=new java.io.File(pri);
		if(!f.getParentFile().exists())f.getParentFile().mkdirs();
		if(f.exists())f.delete();
		java.io.FileOutputStream fo=new java.io.FileOutputStream(f);
		java.io.ObjectOutputStream o=new java.io.ObjectOutputStream(fo);
		o.writeObject(key);
		o.close();
		fo.close();
	}

	public String encrypt(String s) throws GeneralSecurityException, ClassNotFoundException, IOException {
		javax.crypto.Cipher c=javax.crypto.Cipher.getInstance("RSA");
		PublicKey key=loadPub();
		c.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		java.math.BigInteger bi=new java.math.BigInteger(c.doFinal(s.getBytes()));
		return bi.toString(21);
	}

	public String decrypt(String e) throws GeneralSecurityException, ClassNotFoundException, IOException {
		java.math.BigInteger bi=new java.math.BigInteger(e, 21);
		javax.crypto.Cipher c=javax.crypto.Cipher.getInstance("RSA");
		PrivateKey key=loadPri();
		c.init(javax.crypto.Cipher.DECRYPT_MODE, key);
		byte[]d=c.doFinal(bi.toByteArray());
		return new String(d);
	}

	private PrivateKey loadPri() throws ClassNotFoundException, IOException {
		java.io.File f=new java.io.File(pri);
		java.io.FileInputStream fi=new java.io.FileInputStream(f);
		java.io.ObjectInputStream i=new java.io.ObjectInputStream(fi);
		PrivateKey key=(PrivateKey) i.readObject();
		i.close();
		fi.close();
		return key;
	}

	private PublicKey loadPub() throws IOException, ClassNotFoundException {
		java.io.File f=new java.io.File(pub);
		java.io.FileInputStream fi=new java.io.FileInputStream(f);
		java.io.ObjectInputStream i=new java.io.ObjectInputStream(fi);
		PublicKey key=(PublicKey) i.readObject();
		i.close();
		fi.close();
		return key;
	}
}
