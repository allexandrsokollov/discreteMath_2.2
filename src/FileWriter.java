import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {

	public static void writeStringToFile (String fileName, String filePath, String str) throws IOException {

		if (!fileName.endsWith(".txt")) {
			fileName = fileName + ".txt";
		}


		File file = new File(filePath + fileName);
		FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());

		byte[] buffer = str.getBytes();
		fos.write(buffer, 0, buffer.length);
		fos.close();
	}
}