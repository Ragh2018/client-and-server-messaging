import java.net.*;
import java.io.*;
class ClientTest
{
public static void  main(String s[])
{
try
{
System.out.println("client started");
Socket sk=new Socket("192.168.0.2",1500);
System.out.println("connection established");
DataInputStream din=new DataInputStream(sk.getInputStream());
DataOutputStream dout=new DataOutputStream(sk.getOutputStream());
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
while(true)
{
System.out.println("Enter the msg, enter 'stop' to terminate");
String str=br.readLine();
dout.writeUTF(str);
dout.flush();
if(str.equals("stop"))
break;
str=din.readUTF();
System.out.println(str);
}
}
catch(Exception e)
{
e.printStackTrace();
}
}
}