


import java.io.PrintWriter;

public class my_main {
	public boolean validate(String id,String gender, String path) {
		String str="";
		String str2="";
		String str3="";
		String str4="";
		String gen= gender.charAt(0)+gender.substring(1).toLowerCase();
	//	System.out.println(s);
		// System.out.println(str);
		 String input_file=path;
		 String output_file="C:\\Users\\monika12\\Desktop\\output.txt";
		 String tesseract_install_path="C:\\Program Files (x86)\\Tesseract-OCR\\tesseract"
		 		+ "";
		 String[] command =
		    {
		        "cmd",
		    };
		 String s=null;
		    Process p;
		 try {
		 p = Runtime.getRuntime().exec(command);
		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
		        new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
		        PrintWriter stdin = new PrintWriter(p.getOutputStream());
		        stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
		        stdin.close();
		        p.waitFor();
		        System.out.println();
		        System.out.println();
		        System.out.println();
		        System.out.println();
		        System.out.println(Read_File.read_a_file(output_file+".txt"));
		      s=Read_File.read_a_file(output_file+".txt");
		      if(id.length()==12)
				 {str2+=id;
					 str+=id.substring(0,4)+" "+id.substring(4,8)+" "+id.substring(8,12);
					 str3+=id.substring(0,4)+" "+id.substring(4,8)+id.substring(8,12);
					 str4+=id.substring(0,4)+id.substring(4,8)+" "+id.substring(8,12);

					 if(s.contains(str)&&s.contains(gender))
					 {System.out.println("hello");
						 return true;
					 }
					 else if(s.contains(str2)&&s.contains(gender))
					 {System.out.println("hello2");
						 return true;
						 
					 }
					 else if(s.contains(str3)&&s.contains(gender))
					 {System.out.println("hello3");
						 return true;
						 
					 }
					 else if(s.contains(str4)&&s.contains(gender))
					 {System.out.println("hello4");
						 return true;
						 
					 }
					 else if(s.contains(str)&&s.contains(gen))
					 {System.out.println("hello");
						 return true;
					 }
					 else if(s.contains(str2)&&s.contains(gen))
					 {System.out.println("hello2");
						 return true;
						 
					 }
					 else if(s.contains(str3)&&s.contains(gen))
					 {System.out.println("hello3");
						 return true;
						 
					 }
					 else if(s.contains(str4)&&s.contains(gen))
					 {System.out.println("hello4");
						 return true;
						 
					 }
					 
			        }
		      else {
		    	  return false;
		      }
		      
				} catch (Exception e) {
		 e.printStackTrace();
		 
		    }
		 
		 return false;
	}}
		  
		


