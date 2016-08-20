package com.meat.fileupload;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@PropertySource("classpath:application.properties")
public class FileUploadController {
    @Value("${url}")
    private String url;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public FileUploadImage uploadImageFile(@RequestParam("imageType") final String imageType,
            @RequestParam("file") final MultipartFile file, final HttpServletRequest req) {
        UUID uniqueName = UUID.randomUUID();
        FileUploadImage uploadImage = new FileUploadImage();

        int imageWidth = 0, imageHeight = 0;
        String contentType = file.getContentType();
        String webAppPath = (req.getServletContext().getRealPath("/"));
        try {
            BufferedImage img = ImageIO.read(file.getInputStream());
            imageWidth = img.getWidth();
            imageHeight = img.getHeight();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        if (contentType.split("/")[0].equals("image")) {
            BufferedOutputStream stream;
            try {
                stream = new BufferedOutputStream(new FileOutputStream(
                        new File(webAppPath + "/images_upload/" + imageType + "_media/" + uniqueName + fileExtension)));
                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();
            }
            catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            uploadImage.setImageLocation(url + "/images_upload/" + imageType + "_media/" + uniqueName + fileExtension);
            uploadImage.setUploadStatus("SUCCESS::: Image Has Been Uploaded SuccessFully");
            uploadImage.setImageName(uniqueName.toString());
        }
        else {
            uploadImage.setUploadStatus("ERROR:::Please Select Only Image File Types");
        }

        return uploadImage;
    }
}
