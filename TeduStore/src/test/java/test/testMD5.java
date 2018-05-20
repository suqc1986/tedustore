package test;

import java.io.FileInputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class testMD5 {
	@Test
	public void test() throws Exception {
		String str = DigestUtils.md5Hex("1");
		System.out.println(str);
		String file1 =  DigestUtils.md5Hex(new FileInputStream("pom.xml"));
		String file2 =  DigestUtils.md5Hex(new FileInputStream("pom2.xml"));
		System.out.println(file1);
		System.out.println(file2);
	}
}
