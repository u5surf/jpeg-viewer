import java.io.*;  
import java.net.*;  
  
public class Main {  
 private static final int PORT = 4680;  
  
 public static void main(String argv[]) {  
  System.out.println("サーバ起動");  
  int num = 0;  
  ServerSocket serverSocket = null;
  GUI gui=new GUI(0) ; 
  while(true){  
   try {  
    // サーバーソケットの生成  
    if(serverSocket == null) serverSocket = new ServerSocket(PORT);  
    // クライアントからの接続を待ちます  
    Socket socket = serverSocket.accept(); 
    BufferedOutputStream out = new BufferedOutputStream(  
       new FileOutputStream(new File("0.jpg")));  
    // 入力ストリームを取得  
    BufferedInputStream in = new BufferedInputStream(socket.getInputStream());  
    byte[] buf = new byte[1024];  
    int len;  
    while((len=in.read(buf))!=-1){  
     out.write(buf, 0, len);  
    }  
    // GUIで画像を表示  
    gui.repaint();  
    // 入出力ストリームを閉じる  
    out.flush();  
    out.close();  
    in.close();  
    // ソケットを閉じる  
    socket.close();  
    num++;  
   } catch(Exception e) {  
    e.printStackTrace();  
   }  
  }  
 }  
} 
