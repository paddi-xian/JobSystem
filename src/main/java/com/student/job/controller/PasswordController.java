package com.student.job.controller;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Controller
public class PasswordController {
//    @Resource
//    private UserMapper userMapper;
//    @Resource
//    private UserService userService;
//    @RequestMapping(value = "/updatePwd", method = RequestMethod.PUT)
//    public @ResponseBody Object changPwd(@RequestParam("u_id") Integer u_id, @RequestParam("old_pass") String old_pass, @RequestParam("new_pass") String new_pass)  throws NoSuchAlgorithmException {
//        User user = userMapper.selectById(u_id);
//        if (user != null && old_pass.equals(user.getU_pass())) {
//            String sha1NewPass = getSHA1Hash(new_pass);
//            boolean result = updatePassword(u_id, sha1NewPass);
//            if(result){
//                return new ResponseEntity<>("Password updated successfully!", HttpStatus.OK);
//            }else{
//                return new ResponseEntity<>("Failed to update password!", HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//        return new ResponseEntity<>("Failed to update password! Invalid username or password", HttpStatus.UNAUTHORIZED);
//    }
//
//    private String getSHA1Hash(String input) throws NoSuchAlgorithmException {
//        MessageDigest md = MessageDigest.getInstance("SHA-1");
//        md.update(input.getBytes(StandardCharsets.UTF_8));
//        byte[] digest = md.digest();
//        return bytesToHex(digest); // 将字节数组转换为十六进制字符串
//    }
//
//    private boolean updatePassword(Integer u_id, String sha1NewPass) {
//        try {
//            userMapper.updatePwd(u_id,sha1NewPass);
//            return true;
//        } catch (Exception e) {
//
//        }
//        return false;
//    }
//    public static String bytesToHex(byte[] bytes) {
//        StringBuilder result = new StringBuilder();
//        for (byte b : bytes) {
//            result.append(String.format("%02x", b));
//        }
//        return result.toString();
//    }
}
