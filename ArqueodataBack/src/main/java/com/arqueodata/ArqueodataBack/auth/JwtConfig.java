package com.arqueodata.ArqueodataBack.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpAIBAAKCAQEAwyyqpWNitY6+IxE1wbLJ+AhI+jiHEKutUgXEQQmuPQS1FjLm\r\n"
			+ "fowFbBUIJZHUbFJx1beJvsbUma42KvN6keSn0P0sK3txZCvhKKx8/38H0+FUaS7v\r\n"
			+ "Hf16beZeos0N8yZo6YAOe42bPtlDhY3U81clYmstJoS+RQZfvohrecmVlcrR6BP/\r\n"
			+ "+x70Se/0s7G4UZ6dTMKjPHPeo3EF0CKhhOIBt4uhSkvmndpzojxKu6MOWq8O1quh\r\n"
			+ "lxvrVE/eXgnPIx3p0fpwRrMi+dp91w74SPA4stTZMvYylFKXGt0GJ0gGfc7NCNWU\r\n"
			+ "PQKPt5S5wYsiw8glHgYF/Cp9sdY85OuC0e30CQIDAQABAoIBAEfzT3VpDhqgZLfI\r\n"
			+ "wGiH4KzvYPfdnu0mXN7AAXl4eCNGePuWCCLeu6D8n+Q5vnWwbwa6gq0x325IKu/q\r\n"
			+ "kmT2Rmdk7cOZ3lNvWbIE5I/L5LbXeqbMBpqnt1qMcpbRwTLCFir+alhh+7lPnvS9\r\n"
			+ "NKQAnGeL2zk39my7zNAQuo5LIjn1xd9udEuf0ok8LAzhydcQY9+BmSytI85fir84\r\n"
			+ "LCTk7s8NWCSRxgnw9idWErag4zNPRXP0cWCWeGTnwpWF6cHucrb8vlh3wpx6kFzc\r\n"
			+ "WvMcNm7WwDvtlXOL9+88unFq2H/VmH4GaLIjA55vOIIrMJvZv3rDPLl93RVPGmwn\r\n"
			+ "4WFjP4ECgYEA8XkUGnO/Rs3HZhCIMPwJTI8ZEuMA0TVvoQjIXwOe2GFqYCJ0mxQp\r\n"
			+ "zhVkZw4WNcIKgJNboGXGpJkdWmoO418z29Ivg64sABxEMuyJyWXosWOYH/JLJgOV\r\n"
			+ "F51Tu+HlqRaGqGK1xL5/dv5FINTBUXtjWv7Jzs0xJdWe8cDWbqTzINcCgYEAzuqL\r\n"
			+ "uYMXeYLIto1Qns5atZ27RfDytVF845rnMZUWMfDJso4iy8C3FosEtcS9D0/irsed\r\n"
			+ "mIkR4AqJ6riNaHYClpaEK8cV8CEXrrHCpGGY48Jh3KhHLXGHzYcmhHERj3kacxsd\r\n"
			+ "tHKFPVQRTc47jAmONLZu096ry5629RER4jvZlh8CgYB9hVXo5jAQyxkSuhdBd1IS\r\n"
			+ "JPSAt9WN6rwLNniJw2UHz6OvM1nv3wxYHxCg7VaoPSSeb3sapq0alKkIfccddDiN\r\n"
			+ "1PVz+s7Og+MDoaeCNGJAC6hhOt7LdONEcji7mpJ6UcZPs3gPPIMfxM8EYPPYuk4M\r\n"
			+ "WBNpV4prw16rBnWw8Ded4wKBgQCfDWoUUvGThPXWZbBIMmVF4BZZgAqBWD9BEgyP\r\n"
			+ "b4OdJfNVHq8eomfam0gmlTGi+IxOP8EjxJGJ/2/ejricSMJakR7OK/3wFPAIaDov\r\n"
			+ "c5o70Wq6XFxCUVfLpAz2l5ehCr1LJ9fgontLFjkq7tGVJq86U9XDZRH3tmv624E8\r\n"
			+ "vzbVjwKBgQDql7Yom4P9fCYyZ+x6ijYKnadzhc6Eof3nj2hiRqSf0d/m7sTZ2QBA\r\n"
			+ "asyjybz1P2NF3GkvRL5aoo8R7jm+KbYVakV8SNmH83Dq5Efpkq4Bc+OKe/JsRiXg\r\n"
			+ "SzzBjk9DpIump3dkMF7w3wa+vk8pGnYMKTrXcXgda1un6ut8b7BEjA==\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA ="-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwyyqpWNitY6+IxE1wbLJ\r\n"
			+ "+AhI+jiHEKutUgXEQQmuPQS1FjLmfowFbBUIJZHUbFJx1beJvsbUma42KvN6keSn\r\n"
			+ "0P0sK3txZCvhKKx8/38H0+FUaS7vHf16beZeos0N8yZo6YAOe42bPtlDhY3U81cl\r\n"
			+ "YmstJoS+RQZfvohrecmVlcrR6BP/+x70Se/0s7G4UZ6dTMKjPHPeo3EF0CKhhOIB\r\n"
			+ "t4uhSkvmndpzojxKu6MOWq8O1quhlxvrVE/eXgnPIx3p0fpwRrMi+dp91w74SPA4\r\n"
			+ "stTZMvYylFKXGt0GJ0gGfc7NCNWUPQKPt5S5wYsiw8glHgYF/Cp9sdY85OuC0e30\r\n"
			+ "CQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
	
}
