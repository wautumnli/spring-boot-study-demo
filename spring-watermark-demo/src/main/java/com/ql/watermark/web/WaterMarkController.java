package com.ql.watermark.web;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.MessageFormat;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/15 15:19
 * 图片水印实现
 */
@Slf4j
@Controller
public class WaterMarkController {

    /**
     * 一般实现方法
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file) {

        String name = "";
        // 1.判断字符串是否为空
        if (file.isEmpty() || (name = file.getOriginalFilename()).isEmpty()) {
            log.error("图片非法: {}", name);
            return MessageFormat.format("图片非法: 【{0}】", name);
        }

        // 2.将MultipartFile 转换为 File
        File toFile = new File(name);
        try (InputStream ins = file.getInputStream(); OutputStream os = new FileOutputStream(toFile)){
            int byteRead = 0;
            byte[] buffer = new byte[8192];
            while ((byteRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, byteRead);
            }
        } catch (IOException ex) {
            log.error("图片转换发送异常: {}", ex.getMessage());
            return MessageFormat.format("水印添加失败: 【{0}】", name);
        }

        // 3.获取图片信息转到暂存区并添加水印
        BufferedImage bufferedImage = null;
        try {
            Image image = ImageIO.read(toFile);
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = bufferedImage.createGraphics();
            graphics.drawImage(image, 0, 0, width, height, null);
            graphics.setFont(new Font(null,1,100));
            graphics.setColor(new Color(35, 154, 107));
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP));
            graphics.drawString("万秋里", 50, 150);
            graphics.dispose();
        } catch (IOException ex) {
            log.error("图片转换发送异常: {}", ex.getMessage());
            return MessageFormat.format("水印添加失败: 【{0}】", name);
        }

        // 4.将缓存图片写入本地
        try {
            OutputStream os = new FileOutputStream("water_" + name);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
            encoder.encode(bufferedImage);
            return MessageFormat.format("水印添加成功: 【{0}】", name);
        } catch (FileNotFoundException ex) {
            log.error("图片路径错误: {}", ex.getMessage());
        } catch (IOException ex) {
            log.error("图片解码失败: {}", ex.getMessage());
        }
        return MessageFormat.format("水印添加失败: 【{0}】", name);
    }

    /**
     * Hutool工具实现方法
     * @param file
     * @return
     */
    @PostMapping("/hutool")
    @ResponseBody
    public String hutool(@RequestParam("file")MultipartFile file) {
        String name = "";
        // 1.判断字符串是否为空
        if (file.isEmpty() || (name = file.getOriginalFilename()).isEmpty()) {
            log.error("图片非法: {}", name);
            return MessageFormat.format("图片非法: 【{0}】", name);
        }

        // 2.将MultipartFile 转换为 File
        File toFile = new File(name);
        try (InputStream ins = file.getInputStream(); OutputStream os = new FileOutputStream(toFile)){
            int byteRead = 0;
            byte[] buffer = new byte[8192];
            while ((byteRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, byteRead);
            }
        } catch (IOException ex) {
            log.error("图片转换发送异常: {}", ex.getMessage());
            return MessageFormat.format("水印添加失败: 【{0}】", name);
        }

        String DIR = "D:\\wanqiuli\\Desktop\\wanqiuli\\spring-boot-study-demo\\";
        ImgUtil.pressText(
                FileUtil.file(DIR + name),
                FileUtil.file(DIR + "result.jpg"),
                "万秋里版权所有", Color.WHITE,
                new Font("黑体", Font.BOLD, 70),
                0, 0, 0.1f);
        return MessageFormat.format("水印添加成功: 【{0}】", name);
    }
}
