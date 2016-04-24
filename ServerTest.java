import java.io.*;
import java.net.*;
class ServerTest
{
public static void main(String s[])
{
try
{
System.out.println("server started");
ServerSocket ss=new ServerSocket(1500);
System.out.println("waiting for the client request");
Socket sk=ss.accept();
System.out.println("client connected");
DataInputStream din=new DataInputStream(sk.getInputStream());
DataOutputStream dout=new DataOutputStream(sk.getOutputStream());
while(true)
{
String str=din.readUTF();
if(str.equals("stop"))
{
System.out.println("client disconnected");
break;
}
System.out.println("msg read :"+str);
str=str.toUpperCase();
dout.writeUTF("server mssg :"+str);
dout.flush();
}
}
catch(Exception e)
{
e.printStackTrace();
}
}
}