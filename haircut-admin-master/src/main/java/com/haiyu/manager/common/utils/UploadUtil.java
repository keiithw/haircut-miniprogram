package com.haiyu.manager.common.utils;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UploadUtil {

    public static String singFile(MultipartFile file, String fileName, String folder) throws FileNotFoundException {

//使用ResourceUtils  来获取真实路径  确保部署时不会出错

        File path = new File(ResourceUtils.getURL("classpath:").getPath());

        System.out.println(path.getAbsolutePath());

//如果上传的文件为/static/upload/  如下

        File upload = new File(path.getAbsolutePath(), folder);

        if (!upload.exists())

            upload.mkdirs();

        String uploadPath = upload + "\\";

        System.out.println("图片上传后的路径："+uploadPath);

        try {

            File fileUpload=new File(uploadPath + fileName + ".jpg");

            file.transferTo(fileUpload);

            return "/"+folder+fileName+".jpg";

        } catch (IllegalStateException | IOException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        }

        return "error";

    }

}
