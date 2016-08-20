/**
 *
 */
package com.meat.fileupload;

import com.meat.dao.ItemImagesRepository;
import com.meat.domain.Item;
import com.meat.domain.ItemImages;
import com.meat.domain.SubCategory;
import com.meat.domain.SubCategoryImages;
import com.meat.service.IItemImagesService;
import com.meat.service.ISubCategoryImagesService;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author varma
 *
 */
@Controller
@ImportResource("classpath:spring-thymeleaf.xml")
@PropertySource("classpath:application.properties")
public class ImageUploadController {
    @Value("${url}")
    private String url;
    @Autowired
    private ISubCategoryImagesService subCategoryImagesService;
    @Autowired
    private IItemImagesService itemImagesService;
    @Autowired
    private ItemImagesRepository itemImagesRepository;

    @RequestMapping(value = "/itemImages/item/{itemId}", method = RequestMethod.GET)
    public String getItemImagesByItem(@PathVariable(value = "itemId") final String itemId, final Model model) {

        List<ItemImages> itemImags = itemImagesService.getItemImagesByItem(itemId);
        if (itemImags != null) {
            String itemImages[] = new String[3];
            for (ItemImages itemImage : itemImags) {
                if (itemImage.getImageType().equals("MAINIMAGE")) {
                    itemImages[0] = itemImage.getImageLocation();
                }
                if (itemImage.getImageType().equals("LISTIMAGE")) {
                    itemImages[1] = itemImage.getImageLocation();
                }
                if (itemImage.getImageType().equals("THUMBIMAGE")) {
                    itemImages[2] = itemImage.getImageLocation();
                }
            }
            model.addAttribute("mainimagelocation", itemImages[0]);
            model.addAttribute("listimagelocation", itemImages[1]);
            model.addAttribute("thumbimagelocation", itemImages[2]);
        }
        return "/uploadImage::itemImageFragment";

    }

    @RequestMapping(value = "/editItemImage/imageupload", method = RequestMethod.POST)
    public String uploadEditItemImage(@RequestParam(value = "imageType", defaultValue = "item", required = false) final String imageType,
            final Model model, @RequestParam("file") final MultipartFile file, final HttpServletRequest req,
            @RequestParam(value = "itemId") final String itemId) {

        UUID uniqueName = UUID.randomUUID();
        FileUploadImage uploadImage = new FileUploadImage();

        int imageWidth = 0, imageHeight = 0, listImageWidth = 181, listImageHeight = 152, mainImageWidth = 360, mainImageHeight = 360,
                thumbImageWidth = 47, thumbImageHeight = 36;
        String contentType = file.getContentType();
        String webAppPath = (req.getServletContext().getRealPath("/"));
        BufferedImage img = null;
        try {
            img = ImageIO.read(file.getInputStream());
            imageWidth = img.getWidth();
            imageHeight = img.getHeight();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        String imagePath = "/images_upload/" + imageType + "_media/" + uniqueName + fileExtension;
        String images[] = new String[3];
        if (contentType.split("/")[0].equals("image")) {
            if (imageWidth == mainImageWidth && imageHeight == mainImageHeight) {
                BufferedOutputStream stream;
                try {
                    List<ItemImages> itemImags = itemImagesService.getItemImagesByItem(itemId);
                    if (itemImags != null) {
                        itemImagesRepository.delete(itemImags);
                    }
                    stream = new BufferedOutputStream(new FileOutputStream(new File(webAppPath + imagePath)));
                    FileCopyUtils.copy(file.getInputStream(), stream);
                    BufferedImage listImg = Scalr.resize(img, Method.QUALITY, Mode.FIT_EXACT, listImageWidth, listImageHeight,
                            Scalr.OP_ANTIALIAS);
                    BufferedImage thumbImg = Scalr.resize(img, Method.QUALITY, Mode.FIT_EXACT, thumbImageWidth, thumbImageHeight,
                            Scalr.OP_ANTIALIAS);

                    stream.close();
                    UUID listUniqueName = UUID.randomUUID();
                    UUID thumbUniqueName = UUID.randomUUID();
                    images[0] = url + imagePath;
                    fileExtension = fileExtension.replace(".", "");
                    String listImagePath = "/images_upload/" + imageType + "_media/" + listUniqueName + "." + fileExtension;
                    String thumbImagePath = "/images_upload/" + imageType + "_media/_thumb/" + thumbUniqueName + "." + fileExtension;
                    images[1] = url + listImagePath;
                    images[2] = url + thumbImagePath;

                    File f2 = new File(webAppPath + listImagePath);
                    ImageIO.write(listImg, fileExtension, f2);
                    File f3 = new File(webAppPath + thumbImagePath);
                    ImageIO.write(thumbImg, fileExtension, f3);
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                uploadImage.setImageLocation(url + "/images_upload/" + imageType + "_media/" + uniqueName + fileExtension);
                uploadImage.setUploadStatus("SUCCESS::: Image Has Been Uploaded SuccessFully");
                uploadImage.setImageName(uniqueName.toString());

                List<ItemImages> itemImages = new ArrayList<ItemImages>();
                for (int i = 0; i < images.length; i++) {
                    Item itm = new Item();
                    itm.setId(itemId);
                    ItemImages itmMainImage = new ItemImages();
                    itmMainImage.setImageLocation(images[i]);

                    itmMainImage.setItem(itm);
                    if (i == 0) {
                        itmMainImage.setImageType("MAINIMAGE");
                        itmMainImage.setImageName("Single Page Image");
                    }
                    if (i == 1) {
                        itmMainImage.setImageType("LISTIMAGE");
                        itmMainImage.setImageName("List Page Image");

                    }
                    if (i == 2) {
                        itmMainImage.setImageType("THUMBIMAGE");
                        itmMainImage.setImageName("Thumbnail Image");
                    }
                    itemImages.add(itmMainImage);
                    itemImagesService.create(itmMainImage);

                    model.addAttribute("mainimagelocation", images[0]);
                    model.addAttribute("listimagelocation", images[1]);
                    model.addAttribute("thumbimagelocation", images[2]);
                }

            }
            else {
                uploadImage.setUploadStatus("ERROR:::Please Select Only Image Of Resolution " + mainImageWidth + " X " + mainImageHeight);
            }
        }
        else {
            uploadImage.setUploadStatus("ERROR:::Please Select Only Image File Types");
        }
        /* for(i)*/

        return "uploadImage::itemImageFragment";
    }

    @RequestMapping(value = "/itemImageUpload", method = RequestMethod.POST)
    public String uploadImageFile(@RequestParam(value = "imageType", defaultValue = "item", required = false) final String imageType,
            final Model model, @RequestParam("file") final MultipartFile file, final HttpServletRequest req,
            @RequestParam(value = "itemId") final String itemId) {
        UUID uniqueName = UUID.randomUUID();
        FileUploadImage uploadImage = new FileUploadImage();

        int imageWidth = 0, imageHeight = 0, listImageWidth = 181, listImageHeight = 152, mainImageWidth = 360, mainImageHeight = 360,
                thumbImageWidth = 47, thumbImageHeight = 36;
        String contentType = file.getContentType();
        String webAppPath = (req.getServletContext().getRealPath("/"));
        BufferedImage img = null;
        try {
            img = ImageIO.read(file.getInputStream());
            imageWidth = img.getWidth();
            imageHeight = img.getHeight();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        String imagePath = "/images_upload/" + imageType + "_media/" + uniqueName + fileExtension;
        String images[] = new String[3];
        if (contentType.split("/")[0].equals("image")) {
            if (imageWidth == mainImageWidth && imageHeight == mainImageHeight) {
                BufferedOutputStream stream;
                try {
                    stream = new BufferedOutputStream(new FileOutputStream(new File(webAppPath + imagePath)));
                    FileCopyUtils.copy(file.getInputStream(), stream);
                    BufferedImage listImg = Scalr.resize(img, Method.QUALITY, Mode.FIT_EXACT, listImageWidth, listImageHeight,
                            Scalr.OP_ANTIALIAS);
                    BufferedImage thumbImg = Scalr.resize(img, Method.QUALITY, Mode.FIT_EXACT, thumbImageWidth, thumbImageHeight,
                            Scalr.OP_ANTIALIAS);

                    stream.close();
                    UUID listUniqueName = UUID.randomUUID();
                    UUID thumbUniqueName = UUID.randomUUID();
                    images[0] = url + imagePath;
                    fileExtension = fileExtension.replace(".", "");
                    String listImagePath = "/images_upload/" + imageType + "_media/" + listUniqueName + "." + fileExtension;
                    String thumbImagePath = "/images_upload/" + imageType + "_media/_thumb/" + thumbUniqueName + "." + fileExtension;
                    images[1] = url + listImagePath;
                    images[2] = url + thumbImagePath;

                    File f2 = new File(webAppPath + listImagePath);
                    ImageIO.write(listImg, fileExtension, f2);
                    File f3 = new File(webAppPath + thumbImagePath);
                    ImageIO.write(thumbImg, fileExtension, f3);
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                uploadImage.setImageLocation(url + "/images_upload/" + imageType + "_media/" + uniqueName + fileExtension);
                uploadImage.setUploadStatus("SUCCESS::: Image Has Been Uploaded SuccessFully");
                uploadImage.setImageName(uniqueName.toString());

                List<ItemImages> itemImages = new ArrayList<ItemImages>();
                for (int i = 0; i < images.length; i++) {
                    Item itm = new Item();
                    itm.setId(itemId);
                    ItemImages itmMainImage = new ItemImages();
                    itmMainImage.setImageLocation(images[i]);

                    itmMainImage.setItem(itm);
                    if (i == 0) {
                        itmMainImage.setImageType("MAINIMAGE");
                        itmMainImage.setImageName("Single Page Image");
                    }
                    if (i == 1) {
                        itmMainImage.setImageType("LISTIMAGE");
                        itmMainImage.setImageName("List Page Image");

                    }
                    if (i == 2) {
                        itmMainImage.setImageType("THUMBIMAGE");
                        itmMainImage.setImageName("Thumbnail Image");
                    }
                    itemImages.add(itmMainImage);
                    itemImagesService.create(itmMainImage);

                    model.addAttribute("mainimagelocation", images[0]);
                    model.addAttribute("listimagelocation", images[1]);
                    model.addAttribute("thumbimagelocation", images[2]);
                }

            }
            else {
                uploadImage.setUploadStatus("ERROR:::Please Select Only Image Of Resolution " + mainImageWidth + " X " + mainImageHeight);
            }
        }
        else {
            uploadImage.setUploadStatus("ERROR:::Please Select Only Image File Types");
        }
        /* for(i)*/

        return "uploadImage::itemImageFragment";
    }

    @RequestMapping(value = "/subCategoryImageUpload", method = RequestMethod.POST)
    public String uploadSubCategoryImageFile(
            @RequestParam(value = "imageType", defaultValue = "subcategory", required = false) final String imageType, final Model model,
            @RequestParam("file") final MultipartFile file, final HttpServletRequest req,
            @RequestParam("subCategoryId") final String subCategory) {
        UUID uniqueName = UUID.randomUUID();
        FileUploadImage uploadImage = new FileUploadImage();

        int imageWidth = 0, imageHeight = 0, mainImageWidth = 90, mainImageHeight = 90;

        String contentType = file.getContentType();
        String webAppPath = (req.getServletContext().getRealPath("/"));
        BufferedImage img = null;
        try {
            img = ImageIO.read(file.getInputStream());
            imageWidth = img.getWidth();
            imageHeight = img.getHeight();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        String imagePath = "/images_upload/" + imageType + "_media/" + uniqueName + fileExtension;

        if (contentType.split("/")[0].equals("image")) {
            if (imageWidth == mainImageWidth && imageHeight == mainImageHeight) {
                BufferedOutputStream stream;
                try {
                    stream = new BufferedOutputStream(new FileOutputStream(new File(webAppPath + imagePath)));
                    FileCopyUtils.copy(file.getInputStream(), stream);
                    stream.close();
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                /*
                uploadImage.setImageLocation(url + "/images_upload/" + imageType + "_media/" + uniqueName + fileExtension);
                uploadImage.setUploadStatus("SUCCESS::: Image Has Been Uploaded SuccessFully");
                uploadImage.setImageName(uniqueName.toString());
                */
                SubCategory subCat = new SubCategory();
                subCat.setId(subCategory);
                SubCategoryImages subCatMainImage = new SubCategoryImages();
                subCatMainImage.setImageLocation(url + imagePath);

                subCatMainImage.setSubCategory(subCat);

                subCatMainImage.setImageType("MAINIMAGE");
                subCatMainImage.setImageName("Single Page Image");

                subCategoryImagesService.create(subCatMainImage);
                model.addAttribute("imagelocation", url + imagePath);

            }
            else {
                uploadImage.setUploadStatus("ERROR:::Please Select Only Image Of Resolution " + mainImageWidth + " X " + mainImageHeight);
            }
        }
        else {
            uploadImage.setUploadStatus("ERROR:::Please Select Only Image File Types");
        }
        /* for(i)*/

        return "uploadImage::subCategoryImageFragment";
    }
}
