package com.ltsh.admin.mvc.controller;

import com.fjz.util.*;
import com.fjz.util.log.Logs;
import com.ltsh.admin.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "file")
public class FileController {
    public static final String ROOT;
    static {
        ROOT=Systems.isWin?"E:/var/upload/":"/var/upload/";
    }
    private final ResourceLoader resourceLoader;

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


    //文件上传相关代码  WangEditor编辑器上传代码
    @RequestMapping(value = "uploadWangEditor")
    @ResponseBody
    public WangEditroUpload uploadWangEditor(MultipartFile file) throws IOException {
        LayMsg layMsg = uploadLayMsg(file);
        return WangEditroUpload.success(layMsg);
    }
    public static class WangEditroUpload{
        private int errno=-1;
        private List<String> data;
        public int getErrno() {
            return errno;
        }
        public void setErrno(int errno) {
            this.errno = errno;
        }
        public List<String> getData() {
            return data;
        }
        public void setData(List<String> data) {
            this.data = data;
        }
        public static WangEditroUpload success(LayMsg layMsg){
            WangEditroUpload wangEditroUpload = new WangEditroUpload();
            if(layMsg.isTrue()){
                wangEditroUpload.setErrno(0);
                wangEditroUpload.setData(Lists.as(layMsg.getData().getSrc()));
            }
            return wangEditroUpload;
        }
    }
    //文件上传相关代码
    @RequestMapping(value = "upload")
    @ResponseBody
    public LayMsg upload(MultipartFile file) throws IOException {
        return uploadLayMsg(file);
//        return err.setMsg("上传失败");
    }
    @RequestMapping(value = "uploadImage")
    @ResponseBody
    public LayMsg uploadImage(MultipartFile imageUrl) throws IOException {
        return uploadLayMsg(imageUrl);
//        return err.setMsg("上传失败");
    }
    private LayMsg uploadLayMsg(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return err.setMsg("文件为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        Logs.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        Logs.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath =ROOT+ Dates.nowDate()+"/";
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath +fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        Logs.info("上传本地地址：{}",dest.getAbsoluteFile());
//      return success(Requests.getBasePath(SpringContextHolder.getRequest())+"file/"+Dates.nowDate()+"/"+fileName, fileName);不用全路径
        return success("/"+SpringContextHolder.getRequest().getContextPath()+"file/"+Dates.nowDate()+"/"+fileName, fileName);

    }


    //显示图片的方法关键 匹配路径像 localhost:8080/b7c76eb3-5a67-4d41-ae5c-1642af3f8746.png
    @RequestMapping(method = RequestMethod.GET, value = "/{date}/{filename:.+}")
//    @ResponseBody
    public void getFile(@PathVariable String date,@PathVariable String filename,HttpServletResponse response) {
//        try {
//            return ResponseEntity.ok( resourceLoader.getResource("file:" +ROOT+date+"/"+filename));
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//        response.setContentType("image/gif");
        File file = new File(ROOT+date+"/"+filename);
        try ( FileInputStream fis = new FileInputStream(file)){
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //文件下载相关代码
    @RequestMapping("/download")
    public String downloadFile(org.apache.catalina.servlet4preview.http.HttpServletRequest request, HttpServletResponse response) {
        String fileName = "FileUploadTests.java";
        if (fileName != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
            String realPath = request.getServletContext().getRealPath(
                    "//WEB-INF//");
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
//                FileInputStream fis = null;
//                BufferedInputStream bis = null;
                try(FileInputStream fis = new FileInputStream(file);BufferedInputStream bis = new BufferedInputStream(fis)){
//                    fis = new FileInputStream(file);
//                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                finally {
//                    if (bis != null) {
//                        try {
//                            bis.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    if (fis != null) {
//                        try {
//                            fis.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
            }
        }
        return null;
    }

    //多文件上传
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();

                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "upload successful";
    }
    public static LayMsg err=new LayMsg();
    public static LayMsg success(String src,String title){
        LayMsg m = new LayMsg();
        m.setCode(0);
        LayData data=new LayData();
        data.setSrc(src);
        data.setTitle(title);
        m.setData(data);
        return m;
    }
    //lay ui的图片上传
    static class LayMsg{
        private int code=-1;//0是成功的
        private String msg;
        private LayData data;
        public boolean isTrue(){
            return 0==code;
        }
        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public LayMsg setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public LayData getData() {
            return data;
        }

        public void setData(LayData data) {
            this.data = data;
        }
    }
    static class LayData{
        private String src;
        private String title;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}