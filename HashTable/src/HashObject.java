import java.util.Objects;

public class HashObject {
	String name;
	char sex;
	int secret;
	
	public HashObject(String n, char s, int c) {
		name = n;
		sex = s;
		secret = c;
	}
	
	public HashObject(String n, char s) {
		name = n;
		sex = s;
	}
	
	public int getSecret() {
		return secret;
	}
	
	public int getHash() {
		int h = Objects.hash(name, sex);
		int j = Objects.hash(sex, name);
		if (h < 0) {h = -h;}
		if (j < 0) {j = -j;}
		return ((h^2)-1) % (j^2);
	}

}