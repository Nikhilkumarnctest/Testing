//package utilities;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Properties;
//
//public class ReadPropertyFile {
//
//	public static void main(String[] args) throws IOException {
//		
//		FileReader fr = new FileReader("C:\\Users\\Nikhilkumar\\eclipse-workspace\\TestAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
//		System.out.println(fr);
//		Properties p = new Properties();	//	we need to have the object of the 'Properties' class as well
//		p.load(fr);
//		
//		System.out.println(p.getProperty("browser"));
//		System.out.println(p.getProperty("testurl"));
//		
//	}
//
//}
