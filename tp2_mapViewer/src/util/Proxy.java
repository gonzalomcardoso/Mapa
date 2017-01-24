package util;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class Proxy 
{
	public static void autenticar() {
		final String authUser = "lvargas1";
		final String authPassword = "Luk3jv04";
		Authenticator.setDefault(new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(authUser, authPassword.toCharArray());
			}
		});
		
		System.setProperty("http.proxyHost", "136.17.0.7");
        System.setProperty("http.proxyPort", "83");
		System.setProperty("http.proxyUser", authUser);
		System.setProperty("http.proxyPassword", authPassword);

	}
}
