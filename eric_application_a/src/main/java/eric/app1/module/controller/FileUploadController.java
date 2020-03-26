package eric.app1.module.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import eric.app1.framework.dto.Res;
import eric.app1.module.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年9月4日 上午10:38:37
 * @Description
 */

@Slf4j
@Controller
@RequestMapping("upload")
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;

	@RequestMapping("page")
	public ModelAndView uploadPage(Model model) {
		log.info("enter upload page....");
		return new ModelAndView("upload_file");
	}

	@PostMapping("uploadImage")
	@ResponseBody
	public Res<Map<String, Object>> uploadImage(@RequestParam(value = "file") MultipartFile file)
			throws IllegalStateException, IOException {
		log.info("enter FileUploadController.uploadImage...file:{}", file);
		Res<Map<String, Object>> res = fileUploadService.uploadPicture(file);
		return res;
	}

	@RequestMapping(value = "/image", produces = { MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE })
	public ResponseEntity<byte[]> showImage(@RequestParam("path") String path) throws Exception {
		log.info("enter FileUploadController.showImage...path:{}", path);
		byte[] imageContent = fileToByte(new File(path));
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
	}

	private byte[] fileToByte(File file) {
		byte[] bytes = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			BufferedImage bi;
			bi = ImageIO.read(file);
			ImageIO.write(bi, "png", baos);
			bytes = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bytes;
	}
}
