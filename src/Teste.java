import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Teste {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

		SSLSocketFactory factory=(SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket sslsocket=(SSLSocket) factory.createSocket("smtp.gmail.com",465);

		InputStreamReader le = new InputStreamReader(sslsocket.getInputStream());
		BufferedReader lei = new BufferedReader(le);
		OutputStreamWriter out = new OutputStreamWriter(sslsocket.getOutputStream(),"UTF-8");
		out.write("EHLO smtp.gmail.com \r\n");
		out.flush();
		
		
		Thread.sleep(1000);
		out.write("AUTH LOGIN \r\n");
		out.flush();
		Thread.sleep(1000);
		out.write("base64user\r\n");
		out.flush();
		out.write("base64pass\r\n");
		out.flush();
		out.write("MAIL FROM: <alex.junior.carlos23@gmail.com> \r\n");
		out.flush();
		Thread.sleep(1000);
		out.write("RCPT TO: <willoucassiano@gmail.com> \r\n");
		out.flush();
		Thread.sleep(1000);
		out.write("DATA \r\n");
		out.flush();
		out.write("Content-Type: text/plain;charset=utf-8\r\n");
		out.flush();
		
		out.write("Esse email é um teste");
		out.flush();
		out.write("\r\n.\r\n");
		out.flush();
		Thread.sleep(1000);
		sslsocket.close();
		lei.close();
		le.close();
		System.out.println("deu certo");


	}

}
