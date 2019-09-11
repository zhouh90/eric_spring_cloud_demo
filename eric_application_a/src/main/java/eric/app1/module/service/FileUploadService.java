package eric.app1.module.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import eric.app1.framework.config.MessageProperties;
import eric.app1.framework.dto.Res;
import eric.app1.framework.dto.enums.CodeEnum;
import net.coobird.thumbnailator.Thumbnails;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年9月4日 上午10:15:29
 * @Description
 */
@Service
public class FileUploadService {

	@Autowired
	private MessageProperties properties;

	public Res<Map<String, Object>> uploadPicture(MultipartFile file) throws IllegalStateException, IOException {
		if (file == null) {
			return new Res<Map<String, Object>>(CodeEnum.ERROR, null, "文件对象为空");
		}
		final String[] imageTypes = properties.getImageType().split(",");
		boolean flag = false;
		for (String type : imageTypes) {
			if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			return new Res<Map<String, Object>>(CodeEnum.ERROR, null, "文件类型不支持");
		}
		Map<String, Object> resMap = new HashMap<String, Object>();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		String fileType = file.getContentType();
		// 文件扩展名
		String imageType = fileType.substring(fileType.indexOf("/") + 1);
		String originalFilename = file.getOriginalFilename();
		String newFileName = uuid + "." + imageType;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String basedir = sdf.format(new Date());

		String path = properties.getUpPath() + "/" + basedir + "/" + newFileName;
		File uploadFile = new File(path);
		// 如果目录不存在则创建目录
		if (!uploadFile.exists()) {
			uploadFile.mkdirs();
		}
		file.transferTo(uploadFile);
		if (file.getSize() > properties.getFileSize()) {
			// 压缩图片
			Thumbnails.of(uploadFile).scale(properties.getScaleRatio()).toFile(path);
		}
		resMap.put("path", path);
		resMap.put("oldFileName", originalFilename);
		resMap.put("newFileName", newFileName);
		resMap.put("fileSize", file.getSize());
		return new Res<Map<String, Object>>(CodeEnum.OK, resMap);
	}

}
