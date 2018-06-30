package com.zhuxl.component.util.image;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zhuxl@paxsz.com on 2016/7/21.
 */

public class ImageUtils {

    /**
     * 将本地图片编码为base64
     *
     * @param file
     * @return
     * @throws RuntimeException
     */
    public static String encodeImageToBase64(File file) {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("图片上传失败,请联系客服!");
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        String base64 = encoder.encode(data);
        return base64;//返回Base64编码过的字节数组字符串
    }

    /**
     * 将网络图片编码为base64
     *
     * @param url
     * @return
     * @throws RuntimeException
     */
    public static String encodeImageToBase64(URL url) throws RuntimeException {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        //打开链接
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            //设置请求方式为"GET"
            conn.setRequestMethod("GET");
            //超时响应时间为5秒
            conn.setConnectTimeout(5 * 1000);
            //通过输入流获取图片数据
            InputStream inStream = conn.getInputStream();
            //得到图片的二进制数据，以二进制封装得到数据，具有通用性
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            //创建一个Buffer字符串
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕
            int len = 0;
            //使用一个输入流从buffer里把数据读取出来
            while ((len = inStream.read(buffer)) != -1) {
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                outStream.write(buffer, 0, len);
            }
            //关闭输入流
            inStream.close();
            byte[] data = outStream.toByteArray();
            //对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            String base64 = encoder.encode(data);
//            logger.info("网络文件[{}]编码成base64字符串:[{}]", url.toString(), base64);
            return base64;//返回Base64编码过的字节数组字符串
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("图片上传失败,请联系客服!");
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        String imagePath = "C:\\Users\\zhuxl\\Desktop\\报表转word\\16.png";

        String base64 = ImageUtils.encodeImageToBase64(new File(imagePath));

        String base64NoRN = base64.replaceAll("\r|\n", "");

        String imgtag = "<img src=\"data:image/png;base64," + base64NoRN + "\"/>";
        System.out.println(imgtag);

    }

    public static boolean generateImage(String imgStr, String path, String fileName) {
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
// Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            File file = new File(path);
            file.mkdir();
            OutputStream out = new FileOutputStream(path + File.separator + fileName);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断是否是图片的base64
     *
     * @param base64Str
     * @return
     */

    public static boolean isImageFromBase64(String base64Str) {
        boolean flag = false;
        try {
            BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(base64Str)));
            if (null == bufImg) {
                return flag;
            }
            flag = true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return flag;
    }

}
