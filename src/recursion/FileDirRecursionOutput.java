package recursion;

import java.io.File;

public class FileDirRecursionOutput {

	/**
	 * Output all files in a directory, use recursion
	 */
	public static void main(String[] args) {
		File f = new File("d:" + File.separator + "web");
		listAllFiles(f);
	}
	
	public static void listAllFiles(File f){
		File[] files = f.listFiles();
		for(File file : files){
			if(file.isDirectory()){
				listAllFiles(file);
			}else{
				System.out.println(file);
			}
		}
	}

}
