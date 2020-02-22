package sneakyg.giang.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class UpLoadFileUtil {

	private final static String UPLOAD_IMAGE_DIR = "D:/SneakyG/git/BanSach/BanSach/sneakyg.giang/src/main/webapp/images/";

	public static String upLoadFile(HttpServletRequest req) throws ServletException {
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
			for (FileItem item : items) {
				if (item.isFormField()) {
					continue;
				} else {
					// Process form file field (input type="file").
//	                String fieldName = item.getFieldName();
					String fileName = FilenameUtils.getBaseName(item.getName());
					String extention = FilenameUtils.getExtension(item.getName());
					InputStream fileContent = item.getInputStream();

//	                BufferedImage bi = ImageIO.read(fileContent);
//	                File targetFile = new File(UPLOAD_IMAGE_DIR + fileName);
//	                System.out.println(targetFile.exists());
//	                ImageIO.write(bi,"jpg",new FileOutputStream(targetFile));

					Path folder = Paths.get(UPLOAD_IMAGE_DIR);
					Path file = Files.createTempFile(folder, fileName + "-", "." + extention);
					Files.copy(fileContent, file, StandardCopyOption.REPLACE_EXISTING);
					return "images/" + file.getFileName();
				}
			}
		} catch (FileUploadException | IOException e) {
			throw new ServletException("Cannot parse multipart request.", e);
		}
		return null;
	}
}
